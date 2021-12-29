package org.grace.practice.html.parsing.basic;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.scene.control.Tab;
import net.sf.jasperreports.engine.*;
import org.apache.commons.lang.StringEscapeUtils;
import org.grace.jasper.model.complex.*;
import org.grace.practice.html.parsing.model.Ulink;
import org.grace.practice.html.parsing.model.UlinkBean;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.*;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;


/**
 * Created by U6018134 on 6/25/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class HtmlParsingBySplitting {

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

    private List<String> splitContent(String content) {
        content = content.replaceAll("<paras><para>", "");
        content = content.replaceAll("</paras>", "");
        content = content.replaceAll("</para>", "");
        return Arrays.asList(content.split("<para>"));
    }

    private String replaceParas(String content) {
        content = content.replaceAll("<paras>", "");
        content = content.replaceAll("</paras>", "");
        return content;
    }

    public HtmlSection getHtmlSection(String content) {

        content = replaceXMLSpecialCharacters(content);
        content = "<content>" + content + "</content>";

        String tagContent = null;
        Ulink currentUlink = null;

        boolean isParaContent = false;
        boolean isTextContent = false;
        boolean isTableHeaderContent = false;
        boolean isTableRowContent = false;
        boolean isTableColumnContent = false;
        boolean isJsonContent = false;

        HtmlSection htmlSection = new HtmlSection();
        List<HtmlContent> htmlContents = new ArrayList<HtmlContent>();
        HtmlContent htmlContent = null;

        StringBuilder textContent = null;

        Object result = null;


        //Variables for HtmlTable
        HtmlTable htmlTable = null;
        List<TableHeader> tableHeaders = null;
        TableHeader tableHeader = null;

        List<TableRow> tableRows = null;
        TableRow tableRow = null;

        List<TableColumn> tableColumns = null;
        TableColumn tableColumn = null;


        try {
            XMLInputFactory factory = XMLInputFactory.newInstance();
            XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(content));


            while (reader.hasNext()) {
                int event = reader.next();
                switch (event) {

                    case XMLStreamConstants.START_ELEMENT:
                        if ("para".equalsIgnoreCase(reader.getLocalName())) {
                            tagContent = null;
                            isTextContent = true;
                            isParaContent = true;
                            textContent = new StringBuilder();
                        } else if ("span".equalsIgnoreCase(reader.getLocalName())) {
                            tagContent = null;
                            isJsonContent = true;
                        } else if ("table".equalsIgnoreCase(reader.getLocalName())) {
                            htmlContent = new HtmlContent();
                            htmlTable = new HtmlTable();
                        } else if ("thead".equalsIgnoreCase(reader.getLocalName())) {
                            tableHeaders = new ArrayList<TableHeader>();
                            tagContent = null;
                            isTableHeaderContent = true;
                        } else if ("tbody".equalsIgnoreCase(reader.getLocalName())) {
                            tagContent = null;
                            tableRows = new ArrayList<TableRow>();
                            isTableRowContent = true;
                        } else if ("tr".equalsIgnoreCase(reader.getLocalName())) {
                            tagContent = null;
                            if (isTableRowContent) {
                                tableRow = new TableRow();
                                tableColumns = new ArrayList<TableColumn>();
                            }
                        } else if ("th".equalsIgnoreCase(reader.getLocalName())) {
                            tagContent = null;
                            tableHeader = new TableHeader();

                        } else if ("td".equalsIgnoreCase(reader.getLocalName())) {
                            tagContent = null;
                            isTableColumnContent = true;

                        }
                        break;


                    case XMLStreamConstants.CHARACTERS:
                        if (tagContent != null) {
                            tagContent = tagContent + " " + reader.getText().trim();
                        } else {
                            tagContent = reader.getText().trim();
                        }
                        if (!isJsonContent) {
                            textContent.append(" " + reader.getText().trim());
                        }
                        break;


                    case XMLStreamConstants.END_ELEMENT:
                        if ("para".equalsIgnoreCase(reader.getLocalName()) && textContent != null) {
                            htmlContent = new HtmlContent();
                            htmlContent.setContentType("TEXT");
                            htmlContent.setHtmlContent(textContent.toString());
                            htmlContents.add(htmlContent);
                            isTextContent = false;
                            textContent = null;
                        } else if ("span".equalsIgnoreCase(reader.getLocalName()) && (tagContent.startsWith("{\"ulink"))) {

                            currentUlink = getUlinkObjectFromJson(tagContent);
                            result = extractUlinkData(currentUlink);
                            if (result != null && result instanceof String) {
                                tagContent = result.toString();
                                result = null;
                                if (isTextContent) {
                                    textContent.append(tagContent);
                                    isJsonContent = false;
                                }
                            } else if (result != null && result instanceof InputStream) {

                                if (isTableColumnContent) {
                                    tableColumn = new TableColumn();
                                    tableColumn.setColumnValue(result);
                                    tableColumns.add(tableColumn);
                                    isTableColumnContent = false;
                                    textContent = new StringBuilder();
                                    isJsonContent = false;
                                    tagContent = null;

                                } else {
                                    if (textContent != null) {
                                        htmlContent = new HtmlContent();
                                        htmlContent.setContentType("TEXT");
                                        htmlContent.setHtmlContent(textContent.toString());
                                        htmlContents.add(htmlContent);
                                        isTextContent = false;
                                    }
                                    htmlContent = new HtmlContent();
                                    htmlContent.setContentType("IMAGE");
                                    htmlContent.setHtmlContent(result);
                                    htmlContents.add(htmlContent);
                                    textContent = new StringBuilder();
                                    tagContent = null;
                                    isJsonContent = false;
                                }
                                result = null;

                            }

                        } else if ("table".equalsIgnoreCase(reader.getLocalName())) {
                            htmlContent.setHtmlContent(htmlTable);
                            htmlContent.setContentType("TABLE");
                            htmlContents.add(htmlContent);
                            tagContent = null;
                        } else if ("thead".equalsIgnoreCase(reader.getLocalName())) {
                            //htmlTable.setTableHeaderSection(new TableHeaderSection(tableHeaders));
                            isTableHeaderContent = false;
                        } else if ("th".equalsIgnoreCase(reader.getLocalName())) {
                            tableHeader.setHeaderName(tagContent);
                            tableHeaders.add(tableHeader);
                        } else if ("tbody".equalsIgnoreCase(reader.getLocalName())) {
                            isTableRowContent = false;
                           // htmlTable.setTableRowSection(new TableRowSection(tableRows));
                        } else if ("tr".equalsIgnoreCase(reader.getLocalName())) {
                            if (isTableRowContent) {
                               // tableRow.setTableColumnSection(new TableColumnSection(tableColumns));
                                tableRows.add(tableRow);
                            }
                        } else if ("td".equalsIgnoreCase(reader.getLocalName())) {
                            if (isTableColumnContent) {
                                tableColumn = new TableColumn();
                                tableColumn.setColumnValue(tagContent);
                                tableColumns.add(tableColumn);
                                isTableColumnContent = false;
                            }
                        }
                        break;
                }
            }
            htmlSection.setHtmlContents(htmlContents);
        } catch (
                XMLStreamException e)

        {
            e.printStackTrace();
        }


        return htmlSection;
    }


    private Object extractUlinkData(Ulink ulink) {
        Object result = null;
        String drugURL = "https://stable.cortellis.int.clarivate.com/intelligence/#/report/si/siDrug/";
        String diseaseBriefingUrl = "https://stable.cortellis.int.clarivate.com/intelligence/#/report/si/siDiseaseBriefing/";
        String imageServiceUrl = "http://mwa.us-west-2.stable.dev.cortellis.int.clarivate.com:8200/mr/RetrieveFileService/v1/media/fileName/";
        String structureServiceUrl = "http://mwa.us-west-2.stable.dev.cortellis.int.clarivate.com:8200/mr/ChemistrySIService/v1/image?id=";

        switch (ulink.getLinkType()) {
            case ("siReference"):
                result = ulink.getName();
                break;

            case ("siDrug"):
                result = " <a style=\"color:blue\" href=\"" + drugURL + ulink.getLinkID() + "\"><u>" + ulink.getName() + "</u></a>";
                break;


            case ("siLink"):
                result = " <a style=\"color:blue\" href=\"" + ulink.getLinkID() + "\"><u>" + ulink.getName() + "</u></a>";
                break;


            case ("siDiseaseBriefing"):
                result = " <a style=\"color:blue\" href=\"" + diseaseBriefingUrl + ulink.getLinkID() + "\"><u>" + ulink.getName() + "</u></a>";
                break;

            case ("siImage"):
                result = getImageFromUrl(imageServiceUrl + ulink.getLinkID());
                break;


            case ("siStructure"):
                result = getImageFromUrl(structureServiceUrl + ulink.getLinkID());
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

    private InputStream getImageFromUrl(String imageUrl) {
        if (!imageUrl.endsWith(".swf")) {
            ByteArrayOutputStream bis = new ByteArrayOutputStream();
            InputStream is = null;


            try {
                URL url = new URL(imageUrl);
                //URL url = new URL("http://diylogodesigns.com/blog/wp-content/uploads/2017/07/java-logo-vector-768x768.png");
                is = url.openStream();
                int n;
                byte[] bytebuff = new byte[4096];
                while ((n = is.read(bytebuff)) > 0) {
                    bis.write(bytebuff, 0, n);
                }
                is.close();
            } catch (FileNotFoundException e) {
                System.out.println(e.toString());
                return null;
            } catch (IOException e) {
                System.out.println(e.toString());
                return null;
            }

            return new ByteArrayInputStream(bis.toByteArray());
        }
        return null;
    }

    private void generateReportWithParsedHtmlContent(HtmlSection htmlSection) throws Exception {

        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/htmlMasterTemplate.jrxml-new", "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/complexHtmlMasterTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/htmlSubTemplate.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/complexHtmlSubTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/dynamicTableMasterTemplate.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/dynamicTableMasterTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/dynamicTableHeaderTemplate.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/dynamicTableHeaderTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/dynamicTableColumnTemplate.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/dynamicTableColumnTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/dynamicTableBodyTemplate.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/dynamicTableBodyTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/htmlTemplate.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/htmlTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/htmlTemplate.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/htmlTemplate.jasper");

        String masterReportLocation = "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/complexHtmlMasterTemplate.jasper";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("HTML_SECTION", htmlSection);


        JasperPrint jasperPrint = JasperFillManager.fillReport(masterReportLocation, parameters, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/Practice/java-practice/jasper-practice/t    arget/complex/complexHtml_report.pdf");
    }

    public static void main(String[] args) throws Exception {
        HtmlParsingBySplitting htmlParsingBySplitting = new HtmlParsingBySplitting();
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_Reference_99_2572.txt");
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_Image_99_4650.txt");
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_Iink_Bullet_DiseasebriefingId_Video_99_2556.txt");
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_CITable_99_2570.txt");
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_CITableWithImage_99_2567.txt");
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_SplittedTable_99_2563.txt");
        String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_SplittedTable_CITableWithImage_99_2572.txt");

        /*        List<String> splitContent = htmlParsingBySplitting.splitContent(content);


        for (String s : splitContent) {
            s = "<p>" + s + "</p>";
            System.out.println(htmlParsingBySplitting.replaceReferences(s));
        }*/

        HtmlSection htmlSection = htmlParsingBySplitting.getHtmlSection(content);
        htmlParsingBySplitting.generateReportWithParsedHtmlContent(htmlSection);

    }


}
