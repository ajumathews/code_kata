package com.thomson.salesforecastcharts;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.apache.commons.io.FileUtils;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MainClass {


    public static void main(String[] args) throws Exception {
        // getCompanySvgStringFromFulHtmlStream();
        generateSimpleReport();
    }


    private static void generateSimpleReport() throws Exception {
        JasperReport jasperMasterReport = JasperCompileManager.compileReport("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/salesForecastCharts/simpleTemplate.jrxml");
        Map<String, Object> parameters = new HashMap<String, Object>();
        String content = " Studies have shown increased resistance to the addictive effects of nicotine among individuals with a genetic variant that decreases the function of the enzyme cytochrome P450 (CYP) 2A6.<i> CYP2A6</i> mediates a large share of the conversion of nicotine to cotinine, and genetic variations in the gene have been suggested to affect different aspects of nicotine dependence including nicotine kinetics and smoking behavior.<i> CYP2A6</i> also appears to exert different effects during the different phases of smoker's lifetime, beginning with initiation and progressing through the stages of conversion to dependence, consumption during dependence and smoking cessation (Malaiyandi, V. et al  (2005) ;Munafo, M. et al  (2004) ). For these and other reasons,<i> CYP2A6</i> modulation has been proposed as a possible target in the treatment of nicotine dependence (Benowitz, N.L. (2008) ).";
        parameters.put("content", content);
        //parameters.put("currentSvg", getCurrentChartSvg());
        parameters.put("companySvg", getCompanySvg());
       // parameters.put("companySvg", getCompanySvgStringFromFulHtmlStream());
        //parameters.put("regionSvg", getRegionSvg());
        //parameters.put("regionSvg", getRegionSvgStringFromFulHtmlStream());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, new JREmptyDataSource());


        // JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/salesForecastCharts/simple_report.pdf");

        ByteArrayOutputStream pdfBoas = new ByteArrayOutputStream();
        Exporter exporter = new JRPdfExporter();
        exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfBoas));
        exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
        exporter.exportReport();
        FileUtils.writeByteArrayToFile(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/salesForecastCharts/simple_report.pdf"),pdfBoas.toByteArray());
    }

    private static InputStream getCurrentChartSvg() throws Exception {
        return new ByteArrayInputStream(getCurrentChartSvgString().getBytes());
    }

    private static String getCurrentChartSvgString() throws Exception {
        return FileUtils.readFileToString(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/currentSvg.html"));
    }


    private static InputStream getCompanySvgStringFromFulHtmlStream() throws Exception {
        //String response = getRestTemplate().getForObject("http://localhost:4000/svg-extractor/salesforecastdr-company?drugId=6850&apiKey=Y29ydGVsbGlzQXBpVXNlcg", String.class);
        String response = getRestTemplate().getForObject("https://apps.dev-stable.clarivate.com/svg-extractor/salesforecastdr/company?drugId=6850&apiKey=Y29ydGVsbGlzQXBpVXNlcg", String.class);
        //String response= FileUtils.readFileToString(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/companySvgExtractFullResponse.html"));
        int startIndex = response.indexOf("<svg");
        int endIndex = response.indexOf("</svg>");
        response = response.substring(startIndex, endIndex + 6);

        System.out.println(response);
        return new ByteArrayInputStream(response.getBytes());
    }


    private static InputStream getRegionSvgStringFromFulHtmlStream() throws Exception {
        String response = getRestTemplate().getForObject("https://apps.dev-stable.clarivate.com/svg-extractor/salesforecastdr/company?drugId=6850&apiKey=Y29ydGVsbGlzQXBpVXNlcg", String.class);
        //String response= FileUtils.readFileToString(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/companySvgExtractFullResponse.html"));
        int startIndex = response.indexOf("<svg");
        int endIndex = response.indexOf("</svg>");
        response = response.substring(startIndex, endIndex + 6);

        System.out.println(response);
        return new ByteArrayInputStream(response.getBytes());
    }


    private static RestTemplate getRestTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate;
    }

    private static InputStream getCompanySvg() throws Exception {
        //return new ByteArrayInputStream(FileUtils.readFileToString(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/companySvg.html")).getBytes());
        return new ByteArrayInputStream(FileUtils.readFileToString(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/companySvgCurrent.html")).getBytes());
    }


    private static InputStream getRegionSvg() throws Exception {
        //return new ByteArrayInputStream(FileUtils.readFileToString(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/regionSvg.html")).getBytes());
        return new ByteArrayInputStream(FileUtils.readFileToString(new File("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/regionSvgCurrent.html")).getBytes());
    }


}
