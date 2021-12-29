package org.grace.practice.html.parsing.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang.StringEscapeUtils;
import org.grace.practice.html.parsing.model.Ulink;
import org.grace.practice.html.parsing.model.UlinkBean;

import javax.xml.stream.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Created by U6018134 on 6/25/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class HtmlParsingSimple {

    public String readFile(String fileName) {
        String content = null;
        try {
            content = new String(Files.readAllBytes(Paths.get(fileName)));
            return content;
        } catch (IOException e) {
            System.out.println(toString().toCharArray());
        }
        return content;
    }


    public String replaceReferences(String content) {

        content = replaceXMLSpecialCharacters(content);

        String tagContent = null;
        Ulink currentUlink = null;
        boolean startParsing = false;

        StringBuilder builder = new StringBuilder();

        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(content));

            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {

                    case XMLStreamConstants.START_ELEMENT:
                        if ("span".equals(reader.getLocalName())) {
                            startParsing = true;
                            tagContent = null;
                        } else {
                            builder.append("<" + reader.getLocalName() + ">");
                        }
                        break;

                    case XMLStreamConstants.CHARACTERS:
                        if (startParsing) {
                            if (tagContent != null)
                                tagContent = tagContent + " " + reader.getText().trim();
                            else
                                tagContent = reader.getText().trim();
                        } else {
                            builder.append(reader.getText().trim());
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        if ("span".equals(reader.getLocalName())) {
                           currentUlink = getUlinkObjectFromJson(tagContent);
                           builder.append(extractUlinkData(currentUlink));
                            startParsing = false;
                            tagContent = null;
                        } else {
                            builder.append("</" + reader.getLocalName() + ">");
                        }
                        break;
                }
            }
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }



        return builder.toString();
    }


    private String extractUlinkData(Ulink ulink) {
        String result = null;
        String drugURL= "https://stable.cortellis.int.clarivate.com/intelligence/#/report/si/siDrug/";
        String diseaseBriefingUrl="https://stable.cortellis.int.clarivate.com/intelligence/#/report/si/siDiseaseBriefing/";
        String imageServiceUrl="http://mwa.us-west-2.stable.dev.cortellis.int.clarivate.com:8200/mr/RetrieveFileService/v1/media/fileName/";
        String structureServiceUrl = "http://mwa.us-west-2.stable.dev.cortellis.int.clarivate.com:8200/mr/ChemistryService/v1/structure/";

        switch (ulink.getLinkType()) {
            case ("siReference"):
                result = ulink.getName();
                break;

            case ("siDrug"):
                result = "<a href="+drugURL+ulink.getLinkID()+">"+ulink.getName()+"</a>";
                break;


            case ("siLink"):
                result = "<a href=\""+ulink.getLinkID()+"\">"+ulink.getName()+"</a>";
                break;


            case ("siDiseaseBriefing"):
                result = "<a href=\""+diseaseBriefingUrl+ulink.getLinkID()+"\">"+ulink.getName()+"</a>";
                break;

            case ("siImage"):
                result = "<img src=\""+imageServiceUrl+ulink.getLinkID()+"\" alt=\""+ulink.getTitle()+"\"/>";
                break;


            case ("siStructure"):
                result = "<img src=\""+structureServiceUrl+ulink.getLinkID()+"/image\" alt=\""+ulink.getTitle()+"\"/>";
                break;

        }
        return result;
    }


    private Ulink getUlinkObjectFromJson(String jsonObject) {
        ObjectMapper objectMapper = new ObjectMapper();
        UlinkBean ulinkBean = null;
        try {
            ulinkBean = objectMapper.readValue(jsonObject, UlinkBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return ulinkBean.getUlink();
    }

    private String replaceXMLSpecialCharacters(String content) {
        content = content.replaceAll("&", "&amp;");
        return StringEscapeUtils.unescapeJava(content);
    }



    public static void main(String[] args) {
        HtmlParsingSimple htmlParsingSimple = new HtmlParsingSimple();
        //String content = htmlParsingSimple.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_Reference_99_2572.txt");
        //String content = htmlParsingSimple.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_Image_99_4650.txt");
        //String content = htmlParsingSimple.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_Iink_Bullet_DiseasebriefingId_Video_99_2556.txt");
        //String content = htmlParsingSimple.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_CITable_99_2570.txt");

        String content = htmlParsingSimple.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Delivered\\DiseaseBreifing_html\\RawHtml\\Text_Reference_99_2572.txt");
        //String content = htmlParsingSimple.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_SplittedTable_99_2563.txt");
        //String content = htmlParsingSimple.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\  Text_SplittedTable_CITableWithImage_99_2572.txt");
        String output = htmlParsingSimple.replaceReferences(content);
        System.out.println(output);

    }





}
