package org.grace.practice.html.parsing.basic;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.io.JsonStringEncoder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.thomson.ls.soa.stack.soaservices.service.export.exceptions.ExportRestClientException;
import net.sf.jasperreports.engine.*;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.grace.jasper.model.complex.*;
import org.grace.practice.html.parsing.model.UTable;
import org.grace.practice.html.parsing.model.UTableBean;
import org.grace.practice.html.parsing.model.Ulink;
import org.grace.practice.html.parsing.model.UlinkBean;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


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
public class HtmlParsingBySplittingFreeTableV2 {

    private final RestTemplate chemistryServiceTemplate = new RestTemplate();
    private final XMLInputFactory factory = XMLInputFactory.newInstance();

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


    public HtmlSection getHtmlSection(String content) {

        //content = "<content>" + content + "</content>";  // XML is not well formed . Accumulating whole content inside root tag

        //  content = StringUtils.replaceEach(content, new String[]{"<BR/>","</BR>", "<br/>", "<br />", "&nbsp;"}, new String[]{"\n","\n", "\n", "\n", "\t"});

   /*     content = content.replaceAll("<BR/>" ,"\n");
        content = content.replaceAll("<br/>" ,"\n");
            content = content.replaceAll("<br />" ,"\n");
        content = content.replaceAll("&nbsp;" ,"\t");*/
        //content = stripNonValidXMLCharacters(content);
         // content = StringUtils.replaceEach(content, new String[]{"<br>", "&nbsp;"}, new String[]{"\n", "\t"});
        content = StringUtils.replaceEach(content, new String[]{"<BR>", "&nbsp;"}, new String[]{"\n", "\t"});


        // content = StringUtils.replaceEach(content, new String[]{"<br>", "&nbsp;"}, new String[]{"</br>", "\t"});

        String tagContent = null;
        Ulink currentUlink = null;


        boolean isTextContent = false;
        boolean isTableBodyContent = false;
        boolean isTableColumnContent = false;
        boolean isSpanContent = false;
        boolean isInternalHeader = false;
        boolean endOfSpan = false;

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
        int rowCount = 0;
        int columnCount = 0;

        boolean complexTable = false;

        Map<Integer, Integer> rowSpanMap = null;


        try {

            XMLStreamReader reader = factory.createXMLStreamReader(new StringReader(content));
            while (reader.hasNext()) {

                int event = reader.next();
                switch (event) {

                    case XMLStreamConstants.START_ELEMENT:

                        if (isSpanContent) {
                            //For extracting table content
                            if (tagContent != null && tagContent.startsWith("{\"utable")) {
                                if (textContent != null) {
                                    //If any text content is there before the image, Write the text accumulated before printing the image
                                    createHtmlTextContent(textContent.toString(), htmlContents);
                                }
                                isSpanContent = false;
                                isTextContent = true;
                                textContent = new StringBuilder();
                                textContent.append(tagContent);
                            }

                        }

                        tagContent = null;

                        if ("para".equalsIgnoreCase(reader.getLocalName())) {
                            isTextContent = true;
                            textContent = new StringBuilder();
                        } else if ("span".equalsIgnoreCase(reader.getLocalName())) {
                            isSpanContent = true;
                        } else if ("table".equalsIgnoreCase(reader.getLocalName())) {
                            //Utable
                            htmlContent = new HtmlContent();
                            htmlTable = new HtmlTable();
                            htmlTable.setTableTitle(getUTableObjectFromJson(textContent.toString()).getTitle());
                            htmlTable.setTableFooter(getUTableObjectFromJson(textContent.toString()).getFooter());
                            isTextContent = false;

                        } else if ("thead".equalsIgnoreCase(reader.getLocalName())) {
                            tableHeaders = new ArrayList<>();
                        } else if ("tbody".equalsIgnoreCase(reader.getLocalName())) {
                            tableRows = new ArrayList<TableRow>();
                            isTableBodyContent = true;
                            rowCount = 0;
                            rowSpanMap = new HashMap();
                        } else if ("tr".equalsIgnoreCase(reader.getLocalName())) {
                            if (isTableBodyContent) {


                                tableRow = new TableRow();
                                tableColumns = new ArrayList<TableColumn>();

                                rowCount++;
                                columnCount = 0;
                                System.out.println("Row" + rowCount);


                                for (int i = 1; i <= 5; i++) {

                                    if (rowSpanMap.get(i) != null) {

                                        int span = rowSpanMap.get(i);

                                        if (span != 0) {
                                            //  System.out.println("Before " + span);
                                            span = span - (rowCount) + 2;
                                            System.out.println("After " + span);
                                            tableColumns.add(new TableColumn());
                                            columnCount++;
                                            if (span == 0) {
                                                rowSpanMap.put(i, 0);
                                            }
                                        }
                                    }
                                }


                            }
                        } else if ("th".equalsIgnoreCase(reader.getLocalName())) {
                            tableHeader = new TableHeader();
                        } else if ("td".equalsIgnoreCase(reader.getLocalName())) {
                            textContent = new StringBuilder();
                            isTextContent = true;
                            columnCount++;


                            String headerClass = reader.getAttributeValue(null, "class");

                            String rowspan = reader.getAttributeValue(null, "ROWSPAN");


                            if (StringUtils.isNotEmpty(rowspan)) {
                                rowSpanMap.put(columnCount, Integer.valueOf(StringUtils.replaceEach(rowspan, new String[]{"\"", "\\"}, new String[]{"", ""})));
                                complexTable = true;

                            }


                            if (StringUtils.isNotEmpty(headerClass)) {

                                StringEscapeUtils.escapeJava(headerClass);
                                headerClass = StringUtils.replaceEach(headerClass, new String[]{"\"", "\\"}, new String[]{"", ""});
                                if ("internalheader".equalsIgnoreCase(headerClass)) {
                                    System.out.println("header");
                                    isInternalHeader = true;
                                    //   textContent.append("<B>");
                                }
                            }


                            isTableColumnContent = true;
                        } else if ("li".equalsIgnoreCase(reader.getLocalName())) {
                            isTextContent = true;
                            textContent.append("<LI>");
                        } else if ("I".equalsIgnoreCase(reader.getLocalName())) {
                            isTextContent = true;
                            textContent.append("<I>");

                        }
                        else if ("B".equalsIgnoreCase(reader.getLocalName())) {
                            isTextContent = true;
                            textContent.append("<B>");

                        }else if ("sup".equalsIgnoreCase(reader.getLocalName())) {
                            isTextContent = true;
                            textContent.append("<sup>");
                        }


                        break;


                    case XMLStreamConstants.CHARACTERS:
                        if (tagContent == null) {
                            tagContent = reader.getText();
                        } else {
                            tagContent = tagContent + reader.getText();
                        }

                        if (isTextContent && !isSpanContent) {
                            textContent.append(reader.getText());

                        }

                        break;


                    case XMLStreamConstants.END_ELEMENT:
                        if ("para".equalsIgnoreCase(reader.getLocalName()) && textContent != null) {
                            createHtmlTextContent(textContent.toString(), htmlContents);
                            isTextContent = false;
                            textContent = null;
                        } else if ("span".equalsIgnoreCase(reader.getLocalName())) {
                            //tagContent = tagContent.replaceAll("\\\\", "");

                            if (tagContent.startsWith("{\"ulink")) {
                                //Ulink
                                currentUlink = getUlinkObjectFromJson(tagContent);
                                result = extractUlinkData(currentUlink);

                                if (result instanceof String) {
                                    //Text
                                    if (textContent == null) {
                                        textContent = new StringBuilder();
                                    }
                                    textContent.append(result);
                                    isTextContent = true;

                                } else {
                                    //Image
                                    if (isTableColumnContent) {
                                        tableColumn = new TableColumn();
                                        tableColumn.setColumnValue(result);
                                        tableColumns.add(tableColumn);
                                        isTableColumnContent = false;

                                    } else {
                                        if (textContent != null) {
                                            //If any text content is there before the image, Write the text accumulated before printing the image
                                            createHtmlTextContent(textContent.toString(), htmlContents);
                                            textContent = null;
                                            isTextContent = false;
                                        }
                                        createHtmlImageContent(result, currentUlink.getTitle(), htmlContents);
                                    }
                                }

               /*                 else if (result instanceof TableColumn) {
                                    //Image URLS
                                    if (isTableColumnContent) {
                                        tableColumn = new TableColumn();
                                        tableColumn.setColumnValue(result);
                                        tableColumns.add((TableColumn) result);
                                        isTableColumnContent = false;

                                    }
                                } else if (result instanceof HtmlContent) {
                                    if (textContent != null) {
                                        //If any text content is there before the image, Write the text accumulated before printing the image
                                        createHtmlTextContent(textContent.toString(), htmlContents);
                                        textContent = null;
                                        isTextContent = false;
                                    }
                                    htmlContents.add((HtmlContent) result);
                                }*/
                            }

                            isSpanContent = false;


                        } else if ("table".equalsIgnoreCase(reader.getLocalName())) {
                            if (complexTable) {
                                htmlContent.setHtmlContent("Table Available Online");
                                htmlContent.setContentType("TABLE_IMAGE");
                                htmlContents.add(htmlContent);
                                complexTable = false;
                            } else {
                                htmlContent.setHtmlContent(htmlTable);
                                htmlContent.setContentType("TABLE");
                                htmlContents.add(htmlContent);
                            }


                        } else if ("thead".equalsIgnoreCase(reader.getLocalName())) {
                            htmlTable.setTableHeaders(tableHeaders);
                        } else if ("th".equalsIgnoreCase(reader.getLocalName())) {
                            tableHeader.setHeaderName(tagContent);
                            tableHeaders.add(tableHeader);
                        } else if ("tbody".equalsIgnoreCase(reader.getLocalName())) {
                            isTableBodyContent = false;
                            //CallableFutures callableFutures = new CallableFutures();
                            //callableFutures.downloadImages(tableRows);
                            htmlTable.setTableRows(tableRows);
                        } else if ("tr".equalsIgnoreCase(reader.getLocalName())) {
                            if (isTableBodyContent) {
                                tableRow.setTableColumns(tableColumns);
                                tableRows.add(tableRow);
                            }
                            System.out.println("-------------------");
                        } else if ("td".equalsIgnoreCase(reader.getLocalName())) {
                            if (isTableColumnContent) {


                                tableColumn = new TableColumn();

                                if (isInternalHeader) {
                                    textContent.insert(0, "<B>");
                                    textContent.append("</B>");

                                    tableColumn.setInternalHeader(isInternalHeader);
                                    isInternalHeader = false;
                                }
                                tableColumn.setColumnValue(formatTagContent(textContent.toString()));
                                tableColumns.add(tableColumn);
                                isTableColumnContent = false;
                            }
                            isTextContent = false;
                            textContent = null;

                        } else if ("li".equalsIgnoreCase(reader.getLocalName())) {
                            textContent.append("</LI>");
                        } else if ("I".equalsIgnoreCase(reader.getLocalName())) {
                            textContent.append("</I>");
                        }else if ("B".equalsIgnoreCase(reader.getLocalName())) {
                            textContent.append("</B>");
                        }
                        else if ("sup".equalsIgnoreCase(reader.getLocalName())) {
                            textContent.append("</sup>");
                        }

/*                        if (tagContent != null && tagContent.startsWith("{\"utable")) {

                            if (textContent != null) {
                                //If any text content is there before the image, Write the text accumulated before printing the image
                                createHtmlTextContent(textContent.toString(), htmlContents);
                            }
                            //Utable
                            htmlContent = new HtmlContent();
                            htmlTable = new HtmlTable();
                            htmlTable.setTableTitle(getUTableObjectFromJson(tagContent).getTitle());
                            htmlTable.setTableFooter(getUTableObjectFromJson(tagContent).getFooter());
                            isSpanContent = false;
                            isTextContent = false;
                        }*/

                        tagContent = null;
                        break;
                }

            }

            //Writing any remaining texts
            if (textContent != null) {
                createHtmlTextContent(textContent.toString(), htmlContents);
            }
          /*  htmlSection.setHtmlContents(htmlContents);
            reader.close();
            CallableFuturesFull callableFuturesFull = new CallableFuturesFull();
            callableFuturesFull.downloadImages(htmlContents);*/
            reader.close();
        } catch (XMLStreamException e) {
            e.printStackTrace();
        }
        htmlSection.setHtmlContents(htmlContents);

        CallableFuturesFull callableFuturesFull = new CallableFuturesFull();
        callableFuturesFull.downloadImages(htmlContents);

        return htmlSection;
    }

    private String formatTagContent(String tagContent) {
        if (StringUtils.isNotEmpty(tagContent)) {
            return tagContent.replaceAll("\n", "<br>").replaceAll("\t", "&nbsp;").replaceAll("→", "\u2192 ");
        }
        return tagContent;
    }

    private void createHtmlImageContent(Object image, String title, List htmlContents) {
        HtmlContent htmlContent = new HtmlContent();
        htmlContent.setContentType("IMAGE");
        htmlContent.setHtmlContent(image);
        htmlContent.setTitle(title);
        htmlContents.add(htmlContent);
    }

    private void createHtmlTextContent(String textContent, List htmlContents) {
        HtmlContent htmlContent = new HtmlContent();
        htmlContent.setContentType("TEXT");
        textContent = formatTagContent(textContent);
        htmlContent.setHtmlContent(stripNonValidXMLCharacters(textContent));
        //htmlContent.setHtmlContent(textContent);
        htmlContents.add(htmlContent);
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
                result = "<a style=\"color:#3366BB\" href=\"" + drugURL + ulink.getLinkID() + "\"><u>" + ulink.getName() + "</u></a>";
                break;


            case ("siLink"):
                result = "<a style=\"color:#3366BB\" href=\"" + ulink.getLinkID() + "\"><u>" + ulink.getName() + "</u></a>";
                break;


            case ("siDiseaseBriefing"):
                result = "<a style=\"color:#3366BB\" href=\"" + diseaseBriefingUrl + ulink.getLinkID() + "\"><u>" + ulink.getName() + "</u></a>";
                break;

            case ("siImage"):
                result = getImageFromUrl(imageServiceUrl + ulink.getLinkID());
  /*              HtmlContent htmlContent = new HtmlContent();
                htmlContent.setContentType("IMAGE");
                htmlContent.setTitle(ulink.getTitle());
                htmlContent.setImageUrl(imageServiceUrl + ulink.getLinkID());
                result = htmlContent;*/
                break;


            case ("siStructure"):
                result = getImageFromUrl(structureServiceUrl + ulink.getLinkID());
   /*             TableColumn tableColumn = new TableColumn();
                tableColumn.setImage(true);
                tableColumn.setImageUrl(structureServiceUrl + ulink.getLinkID());
                result = tableColumn;*/
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

    private UTable getUTableObjectFromJson(String jsonObject) {
        jsonObject = jsonObject + "\"}}";
        jsonObject = jsonObject.replaceAll("\n", "");
        ObjectMapper objectMapper = new ObjectMapper();
        UTableBean uTableBean = null;
        try {
            uTableBean = objectMapper.readValue(jsonObject, UTableBean.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return uTableBean.getUtable();
    }

    private String replaceXMLSpecialCharacters(String content) {
        //Replacing all special Characters and improper xml elements
        content = content.replaceAll("&", "&amp;");
        content = content.replaceAll("</B>", "");
        content = stripNonValidXMLCharacters(content);
        return StringEscapeUtils.unescapeJava(content);
    }

    public String stripNonValidXMLCharacters(String in) {
        if (StringUtils.isNotEmpty(in)) {
            Document doc = Jsoup.parseBodyFragment(in);

            // String s=Jsoup.clean(in,"", new Whitelist().addTags("para","paras","span","img","i","ul","li","table","tbody","thead","th","tr","td"),new Document.OutputSettings().prettyPrint(false) );

            //s= s.replaceAll("\\s+"," ");
            doc.outputSettings().prettyPrint(true);
            String parsedHTML = doc.body().toString();

            //String newHtml = parsedHTML.replaceAll("\\n","");

            //return parsedHTML;
            //return StringEscapeUtils.escapeJava(s);

            return StringEscapeUtils.unescapeJava(parsedHTML);
            //return parsedHTML;
        }
        return null;
    }

  /*  private String getSectionFromUrl(String sectionUrl) {
        String sectionText = null;
        InputStream is = null;
        StringBuffer response = new StringBuffer();
        try {
            URL url = new URL(sectionUrl);
            is = url.openStream();

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(is));
            String inputLine;


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            is.close();
        } catch (IOException e) {
            System.out.println(e.toString());
            return null;
        }
        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(response.toString());

            JSONObject diseaseBriefing = (JSONObject) data.get("DiseaseBriefing");
            sectionText = diseaseBriefing.get("value").toString();
        } catch (ParseException e) {
            e.printStackTrace();
        }


        return sectionText;
    }
*/

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

        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/htmlMasterTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/htmlMasterTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/htmlSubTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/htmlSubTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableMasterTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableMasterTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/imageTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/imageTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/tableImageTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/tableImageTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableSingleHeaderTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableSingleHeaderTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableTwoHeaderTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableTwoHeaderTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableThreeHeaderTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableThreeHeaderTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableFourHeaderTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableFourHeaderTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableFiveHeaderTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableFiveHeaderTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableTwoColumnTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableTwoColumnTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableThreeColumnTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableThreeColumnTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableFourColumnTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableFourColumnTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableFiveColumnTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableFiveColumnTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableSingleColumnTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableSingleColumnTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/complex/dynamicTableBodyTemplate.jrxml", "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/dynamicTableBodyTemplate.jasper");

        String masterReportLocation = "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/complex/htmlMasterTemplate.jasper";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("htmlSection", htmlSection);
        parameters.put("name", "Facts about Nicotine Addiction");
        parameters.put("level", "1");

/*        parameters.put("name", "Pathophysiology of Addiction");
        parameters.put("level", "2");*/

/*        parameters.put("name", "Non-nicotine Therapies");
        parameters.put("level", "3");*/

        parameters.put("name", "Drugs acting on Dopamine Receptors");
        parameters.put("level", "4");

        JasperPrint jasperPrint = JasperFillManager.fillReport(masterReportLocation, parameters, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/complex/complexHtml_report.pdf");
    }

    public static void main(String[] args) throws Exception {
        long startTime = System.currentTimeMillis();
        HtmlParsingBySplittingFreeTableV2 htmlParsingBySplitting = new HtmlParsingBySplittingFreeTableV2();
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_Reference_99_2572.txt");
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_Image_99_4650.txt");
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_CITable_99_2570.txt");
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_Iink_Bullet_DiseasebriefingId_Video_99_2556.txt");
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_CITableWithImage_99_2567.txt");
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\Text_SplittedTable_99_2563.txt");
        //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\InputHtml\\splittedTable_chemotherapy.txt");

         //String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Requirements\\Current\\DiseaseBreifing_html\\RawHtml\\Test_File.txt");
        String content = htmlParsingBySplitting.readFile("C:\\Aju\\Work\\Cortellis\\Project_Details\\Current_Tasks_Stories\\Bugs\\Current Bugs\\DiseaseBriefing\\html\\test.txt");

        //String content = htmlParsingBySplitting.getSectionFromUrl("http://mwb.us-west-2.stable.dev.cortellis.int.clarivate.com:8347/mr/RetrieveSIService/rest/v1/retrieve/siDiseaseBriefings/section/text?diseaseBriefingId=99&sectionId=2552");


        //System.out.println(htmlParsingBySplitting.stripNonValidXMLCharacters(content));
        HtmlSection htmlSection = htmlParsingBySplitting.getHtmlSection(content);
        htmlParsingBySplitting.generateReportWithParsedHtmlContent(htmlSection);


        System.out.println("Time taken :" + (System.currentTimeMillis() - startTime));
    }


}
