package org.grace.jasper.main;

import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.grace.jasper.model.*;

import java.util.*;

/**
 * Created by U6018134 on 6/5/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class JasperMainClass {


    public static void main(String[] args) throws Exception {
        JasperMainClass jasperMainClass = new JasperMainClass();
        jasperMainClass.generateSimpleReport();
    }

    private void generateSuggestedReading() throws Exception {
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/nextgen_diseasebriefing_section_suggested_reading.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/nextgen_diseasebriefing_section_suggested_reading.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/nextgen_diseasebriefing_section_suggested_reading_link_section.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/nextgen_diseasebriefing_section_suggested_reading_link_section.jasper");

        Map<String, Object> parameters = new HashMap<String, Object>();

        SuggestedReading suggestedReading1 = new SuggestedReading("WHO report on the global tobacco epidemic 2017 - Monitoring tobacco use and prevention policies (World Health Organization, July 2017 WHO report on the global tobacco epidemic 2017 - Monitoring tobacco use and prevention policies (World Health Organization, July 2017 WHO report on the global tobacco epidemic 2017 - Monitoring tobacco use and prevention policies (World Health Organization, July 2017 WHO report on the global tobacco epidemic 2017 - Monitoring tobacco use and prevention policies (World Health Organization, July 2017", "WHO report on the global tobacco epidemic 2017 - Monitoring tobacco use and prevention policies (World Health Organization, July 2017");
        SuggestedReading suggestedReading2 = new SuggestedReading("Hello world","helloworld");




        List suggestedReadings = new ArrayList();
        suggestedReadings.add(suggestedReading1);
        suggestedReadings.add(suggestedReading1);
        suggestedReadings.add(suggestedReading1);
        suggestedReadings.add(suggestedReading2);
        suggestedReadings.add(suggestedReading2);
        suggestedReadings.add(suggestedReading1);
        suggestedReadings.add(suggestedReading2);
        suggestedReadings.add(suggestedReading1);
        suggestedReadings.add(suggestedReading2);


        parameters.put("section", "Related Websites");
        parameters.put("suggestedReadings", suggestedReadings);

        String masterReportLocation = "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/nextgen_diseasebriefing_section_suggested_reading.jasper";

        JasperPrint jasperPrint = JasperFillManager.fillReport(masterReportLocation, parameters, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/simple/suggestedReading.pdf");
    }


    private void generateSimpleReport() throws Exception {
        JasperReport jasperMasterReport = JasperCompileManager.compileReport("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/simple/simpleTemplate.jrxml");
        Map<String, Object> parameters = new HashMap<String, Object>();
        //String content=" Studies have shown increased resistance to the addictive effects of nicotine among individuals with a genetic variant that decreases the function of the enzyme cytochrome P450 (CYP) 2A6.<i> CYP2A6</i> mediates a large share of the conversion of nicotine to cotinine, and genetic variations in the gene have been suggested to affect different aspects of nicotine dependence including nicotine kinetics and smoking behavior.<i> CYP2A6</i> also appears to exert different effects during the different phases of smoker's lifetime, beginning with initiation and progressing through the stages of conversion to dependence, consumption during dependence and smoking cessation (Malaiyandi, V. et al  (2005) ;Munafo, M. et al  (2004) ). For these and other reasons,<i> CYP2A6</i> modulation has been proposed as a possible target in the treatment of nicotine dependence (Benowitz, N.L. (2008) ).";
        //String content= "<b>hello</b> world <i>new</i>  <u>new</u>";
        //String content= "<a href=https://stable.cortellis.int.clarivate.com/intelligence/#/report/si/siDrug/757854>NIC7</a>";
        //String content= " <TABLE WIDTH=\\\"443\\\"  class=\\\"flattable\\\"><THEAD> <TR> <TH COLSPAN=\\\"2\\\" > Drugs marketed for smoking cessation therapy</B></TH> </TR></THEAD><TBODY><TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" CLASS=\\\"internalHeader\\\" > Nicotine replacement therapies</B></TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Chewing gum:</TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > <UL> <LI>Nicorette Gum</LI> <LI>Nicotinell Gum</LI> <LI>Niquitin CQ Gum</LI> <LI>Nicogum</LI> </UL></TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Transdermal patches:</TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > <UL> <LI>Nicorette Patches</LI> <LI>Nicotinell Patches</LI> <LI>Niquitin CQ and Niquitin CQ Clear</LI> <LI>Nicopatch</LI> <LI>Habitrol transdermal patches</LI> <LI>Nicoderm CQ transdermal patches</LI> <LI>Nicotrol transdermal patches</LI> </UL></TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Sublingual tablets:</TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > <UL> <LI>Nicorette microtab</LI> </UL></TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Lozenges:</TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > <UL> <LI>Niquitin CQ Lozenges</LI> <LI>Nicotinell Lozenges</LI> <LI>Nicopass</LI> <LI>Commit Lozenges</LI> </UL></TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Inhalers:</TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > <UL> <LI>Nicorette inhalation cartridge</LI> <LI>Nicotrol inhalation cartridge</LI> </UL> </TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Nasal sprays:</TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > <UL> <LI>Nicorette nasal spray</LI> <LI>Nicotrol nasal spray</LI> </UL></TD> </TR> <TR> <TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" CLASS=\\\"internalHeader\\\" > Non-nicotine pharmacotherapies</B></TD> </TR> <TR> <TD WIDTH=\\\"223\\\" > <span class=\\\"dsJsonData\\\">{\\\"ulink\\\": {\\\"linkType\\\": \\\"siDrug\\\", \\\"linkID\\\": \\\"119021\\\", \\\"name\\\": \\\"Bupropion hydrochloride\\\"}}</span> (Zyban)</TD> <TD WIDTH=\\\"220\\\" > GlaxoSmithKline</TD> </TR> <TR> <TD WIDTH=\\\"223\\\" > <span class=\\\"dsJsonData\\\">{\\\"ulink\\\": {\\\"linkType\\\": \\\"siDrug\\\", \\\"linkID\\\": \\\"330290\\\", \\\"name\\\": \\\"Varenicline tartrate\\\"}}</span> (Chantix)</TD> <TD WIDTH=\\\"220\\\" > Pfizer</TD> </TR> <TR> <TD WIDTH=\\\"223\\\" > <span class=\\\"dsJsonData\\\">{\\\"ulink\\\": {\\\"linkType\\\": \\\"siDrug\\\", \\\"linkID\\\": \\\"274951\\\", \\\"name\\\": \\\"Cytisine\\\"}}</span> (Tabex)</TD> <TD WIDTH=\\\"220\\\" > Sopharma</TD> </TR> </TBODY></TABLE>";
/*
        String content="<body>\n" +
                "  While nicotine is the primary addictive substance in tobacco, most illnesses and conditions derived from its use are caused by the hundreds of other toxins and carcinogens it contains, including tar, carbon monoxide and other gases. Nicotine itself is not a recognized carcinogen ( Britton, J. et al (2008)). Smoking is a direct contributor to a staggering array of diseases and conditions affecting nearly every organ of the body ( Benowitz, N.L. (2008)), including at least 15 different types of cancer ( Thun, M.J. et al (2010)). \n" +
                " <ul> \n" +
                "  <li>The brain: smoking is a major cause of <a style=\"color:#3366BB\" href=\"https://stable.cortellis.int.clarivate.com/intelligence/#/report/si/siDiseaseBriefing/58\"><u>Stroke</u></a>.</li> \n" +
                "  <li>The eyes: cataracts, one of the leading causes of blindness, occur 2-3 times more often in smokers than in nonsmokers. Smokers are also reported to have an increased risk of age-related <a style=\"color:#3366BB\" href=\"https://stable.cortellis.int.clarivate.com/intelligence/#/report/si/siDiseaseBriefing/79\"><u>Macular Degeneration</u></a>.</li> \n" +
                "  <li>The mouth: smoking is a frequent cause of cancers affecting the mouth, oral cavity, pharynx, larynx and esophagus (see <a style=\"color:#3366BB\" href=\"https://stable.cortellis.int.clarivate.com/intelligence/#/report/si/siDiseaseBriefing/110\"><u>Head &amp; Neck Cancer</u></a>), as well as of periodontitis.</li> \n" +
                " </ul> \n" +
                "</body>";*/


        String content = "\nNicotine \t<br>addiction will reach >200 million by the year 2030 and aged <18 years will die prematurely as a result of smoking-related disease ";
/*
        String content2 = "WHO report on the global tobacco epidemic 2017 - Monitoring tobacco use and prevention policies (World Health\n" +
                "Organization, July 2017)";

        String content3 = "WHO report on the global tobacco epidemic, 2011: Warning about the dangers of tobacco (World Health\n" +
                "Organization, 2011)";*/
        parameters.put("content", content);


        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/simple/simple_report.pdf");
    }


    private void generateSimpleTable() throws Exception {

        JasperReport jasperMasterReport = JasperCompileManager.compileReport("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/simpleTableTemplate.jrxml");

        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(getEmployeeList());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, new HashMap<String, Object>(), jrBeanCollectionDataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/simple/simpleTable_report.pdf");
    }

    private void generatePDFWithHtmlPlugin() throws Exception {
        JasperReport jasperMasterReport = JasperCompileManager.compileReport("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/htmlTemplate.jrxml");

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, new HashMap<String, Object>(), new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/simple/html_report.pdf");
    }

    private void generateTableWithSubReport() throws Exception {
        JasperReport jasperMasterReport = JasperCompileManager.compileReport("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/tableWithSubReportTemplate.jrxml");
        JasperReport jasperSubReport = JasperCompileManager.compileReport("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/simpleTableTemplate.jrxml");

        Map<String, Object> parameters = new HashMap<String, Object>();

        parameters.put("SUB_REPORT_PARAMETER", jasperSubReport);
        parameters.put("EMPLOYEE_SECTION", getEmployeeSection());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, parameters, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/simple/tableWithSubReport_report.pdf");
    }


    private void generateHorizontalTable() throws Exception {
        JasperReport jasperMasterReport = JasperCompileManager.compileReport("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/horizontalTableTemplate.jrxml");

        JRBeanCollectionDataSource jrBeanCollectionDataSource = new JRBeanCollectionDataSource(getTableHeaders());
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperMasterReport, new HashMap<String, Object>(), jrBeanCollectionDataSource);

        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/simple/horizontalTable_report.pdf");
    }


    private void generateDynamicTable() throws Exception {

        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/dynamicTemplate.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/dynamicTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/horizontalTableTemplate.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/horizontalTableTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/tableTemplate.jrxml", "C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/tableTemplate.jasper");

        String jasperLocation = "C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/simple/dynamicTemplate.jasper";
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("TABLE_HEADERS", getTableHeaderSection());
        parameters.put("EMPLOYEE_SECTION", getEmployeeSection());

        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperLocation, parameters, new JREmptyDataSource());

        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/simple/dynamicTable_report.pdf");
    }

    private EmployeeSection getEmployeeSection() {
        EmployeeSection employeeSection = new EmployeeSection();
        employeeSection.setEmployeeList(getEmployeeListRandom());
        return employeeSection;
    }

    private TableHeaderSection getTableHeaderSection() {
        TableHeaderSection tableHeaderSection = new TableHeaderSection();
        tableHeaderSection.setTableHeaders(getTableHeadersRandom());
        return tableHeaderSection;
    }

    private List getTableHeaders() {
        TableHeader name = new TableHeader();
        name.setHeaderName("Name");

        TableHeader country = new TableHeader();
        country.setHeaderName("Country");

        List<TableHeader> list = new ArrayList();
        list.add(name);
        list.add(country);

        return list;
    }

    private List getEmployeeList() {
        Employee employee = new Employee();
        employee.setName("Aju");
        employee.setCountry("India");

        List<Employee> employeeList = new ArrayList<Employee>();
        employeeList.add(employee);
        return employeeList;
    }

    private List getTableHeadersRandom() {
        List<TableHeader> headerList = new ArrayList();
        TableHeader tableHeader;
        for (int i = 0; i < 2; i++) {
            tableHeader = new TableHeader();
            tableHeader.setHeaderName("headerName " + i);
            headerList.add(tableHeader);
        }
        return headerList;
    }

    private List getEmployeeListRandom() {
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee employee;
        for (int i = 0; i < 100; i++) {
            employee = new Employee();
            employee.setName("Emp " + i);
            employee.setCountry("Country " + i);
            employeeList.add(employee);
        }
        return employeeList;
    }


    private Set getHtmlcontents() {
        Set htmlContents = new HashSet();
        return htmlContents;
    }

}
