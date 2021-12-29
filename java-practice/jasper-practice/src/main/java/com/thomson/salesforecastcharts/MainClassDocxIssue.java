package com.thomson.salesforecastcharts;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.util.PDFTextStripper;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MainClassDocxIssue {


    public static void main(String[] args) throws Exception {
        // getCompanySvgStringFromFulHtmlStream();
        generateSimpleReport();
    }


    private static void generateSimpleReport() throws Exception {
        JasperReport jasperMasterReport = JasperCompileManager.compileReport("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/salesForecastCharts/simpleTemplate.jrxml");
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("regionSvg", getRegionSvgStringFromFulHtmlStream());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, new JREmptyDataSource());

        ByteArrayOutputStream pdfBoas = new ByteArrayOutputStream();
        Exporter exporter = new JRPdfExporter();
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfBoas));
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.exportReport();
        FileUtils.writeByteArrayToFile(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/salesForecastCharts/simple_report.pdf"),pdfBoas.toByteArray());

        ByteArrayOutputStream docxBoas = new ByteArrayOutputStream();
        Exporter docxExporter = new JRDocxExporter();
        docxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(docxBoas));
        docxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        docxExporter.exportReport();
        FileUtils.writeByteArrayToFile(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/salesForecastCharts/simple_report.docx"),docxBoas.toByteArray());


    }

    private static InputStream getRegionSvgStringFromFulHtmlStream() throws Exception {
        //String response= FileUtils.readFileToString(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/regionChartCurrent.html"));
         String response= FileUtils.readFileToString(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/regionChartGui.html"));
        // String response= FileUtils.readFileToString(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/regionChart4.html"));
        int startIndex = response.indexOf("<svg");
        int endIndex = response.indexOf("</svg>");
        response = response.substring(startIndex, endIndex + 6);

        System.out.println(response);
        return new ByteArrayInputStream(response.getBytes());
    }



}
