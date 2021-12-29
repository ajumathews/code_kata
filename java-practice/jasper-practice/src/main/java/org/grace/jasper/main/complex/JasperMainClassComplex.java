package org.grace.jasper.main.complex;


import net.sf.jasperreports.engine.*;
import org.grace.jasper.model.complex.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.URL;
import java.util.*;

/**
 * Created by U6018134 on 6/5/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class JasperMainClassComplex {


    public static void main(String[] args) throws Exception {
        JasperMainClassComplex jasperMainClass = new JasperMainClassComplex();
        jasperMainClass.generateReportWithParsedHtmlContent();
    }

    private void generateReportWithParsedHtmlContent() throws Exception {

        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/htmlMasterTemplate.jrxml-new","C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/complexHtmlMasterTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/htmlSubTemplate.jrxml","C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/complexHtmlSubTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/dynamicTableMasterTemplate.jrxml","C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/dynamicTableMasterTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/dynamicTableHeaderTemplate.jrxml","C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/dynamicTableHeaderTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/dynamicTableColumnTemplate.jrxml","C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/dynamicTableColumnTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/dynamicTableBodyTemplate.jrxml","C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/dynamicTableBodyTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/htmlTemplate.jrxml","C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/htmlTemplate.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/Practice/java-practice/jasper-practice/src/main/resources/complex/htmlTemplate.jrxml","C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/htmlTemplate.jasper");

        String masterReportLocation = "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/resources/complex/complexHtmlMasterTemplate.jasper";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("HTML_SECTION" ,getParsedHtmlSection());


        JasperPrint jasperPrint = JasperFillManager.fillReport(masterReportLocation, parameters, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/Practice/java-practice/jasper-practice/target/complex/complexHtml_report.pdf");
    }

    private HtmlSection getParsedHtmlSection(){
        HtmlSection parsedHtmlSection = new HtmlSection();
        parsedHtmlSection.setHtmlContents(getHtmlContents());
        return parsedHtmlSection;
    }

    private List getHtmlContents() {

        List htmlContents = new ArrayList();
       // htmlContents.add(getImageContent());
        htmlContents.add(getHtmlParaContent());
        htmlContents.add(getHtmlParaContentWithLinks());
        htmlContents.add(getHtmlParaContentWithBullets());

        htmlContents.add(getHtmlTableContent());
        htmlContents.add(getHtmlContentWithEmbeddedTable2());
        htmlContents.add(getHtmlContentWithEmbeddedTable3());
        return htmlContents;
    }

    private HtmlContent getHtmlParaContent(){
        HtmlContent paraContent = new HtmlContent();
        paraContent.setContentType("TEXT");
        paraContent.setHtmlContent("The concept of chemoprevention is based on the theory that by administering a drug to an individual who does not currently have a disease (primary prevention) or whose disease is in a subclinical or latent phase (secondary prevention), the probability of developing said disease could be reduced. A third type of prevention, called tertiary prevention, involves the administration of chemopreventive agents to individuals manifesting the first recognizable changes linked to more advanced stages of a particular neoplastic disorder, i.e., precancerous lesions. Due to its long latency period and consistent clinical course, prostate cancer is considered an ideal disease model for the implementation of chemoprevention strategies. Based on the pivotal role of androgen in prostate carcinogenesis, drugs targeting the androgen axis have often been suggested for evaluation in chemoprevention trials, although various other pharmacological approaches have also been taken");
        return paraContent;
    }

    private HtmlContent getHtmlParaContentWithLinks(){
        HtmlContent paraContent = new HtmlContent();
        paraContent.setContentType("TEXT");
        paraContent.setHtmlContent("This is a Sample text with links. <a href=\"https://www.cortellis.com\" style=\"color: blue\"><u>Go to Cortellis</u></a>");
        return paraContent;
    }

    private HtmlContent getHtmlParaContentWithBullets(){
        HtmlContent paraContent = new HtmlContent();
        paraContent.setContentType("TEXT");
        paraContent.setHtmlContent("<paras><para>Several diagnostic tools have been devised for purposes of quantifying nicotine dependence, including the following: \n" +
                "\n" +
                "<UL>\n" +
                "<LI>The 1978 <I>Fagerström Tolerance Questionnaire</I> (FTQ), which was subsequently modified and improved, resulting in the <I>Fagerström Test for Nicotine Dependence</I> (FTND) .</LI>\n" +
                "<LI>The <I>Tobacco Dependence Screener</I> (TDS), a 10-item questionnaire developed according to the ICD-10, DSM-III-R and DSM-IV .</LI>\n" +
                "<LI>The <I>CAGE Questionnaire for Smoking</I>, a four-item test adapted from the widely used CAGE questionnaire for alcoholism .</LI>\n" +
                "<LI>The <I>Nicotine Dependence Syndrome Scale</I> (NDSS), a multidimensional questionnaire for measuring nicotine dependence based on Edward's syndromal conceptualization of dependence.</LI>\n" +
                "</UL></para></paras>");
        return paraContent;
    }

    private HtmlContent getHtmlContentWithEmbeddedTable(){
        HtmlContent paraContent = new HtmlContent();
        paraContent.setContentType("HTML");
        paraContent.setHtmlContent("<table><thead><tr><th>Drug Name</th><th>Organizations</th><th>Mechanisms</th><th>Phase</th><th>Structure</th> </tr> </thead> <tbody> <tr> <td>(-)-Gossypol</td> <td>University of Michigan</td> <td>11beta-Hydroxysteroid Dehydrogenase (11beta-HSD) Inhibitors; Apoptosis Inducers; Apoptosis Regulator Bcl-2 Inhibitors; Bcl-2-Related Protein A1 (BFL-1; BCL2A1) Inhibitors; Bcl-w Inhibitors; Bcl-xl Inhibitors; Growth Factor Modulators; Induced Myeloid Leukemia Cell Differentiation Protein Mcl-1 Inhibitors; Lipid Peroxidation Inhibitors; RNA-Binding Protein Musashi Homolog 1 (MSI1)  Inhibitors; Signal Transduction Modulators</td> <td>Phase II</td> <td>301647</td></tr><tr><td>Celecoxib</td> <td>Emory University</td> <td>Angiogenesis Inhibitors; Apoptosis Inducers; Carbonic Anhydrase Inhibitors; Prostaglandin G/H Synthase 2 (PTGS2; COX-2) Inhibitors; Signal Transduction Modulators</td> <td>Phase I/II</td> <td>228583</td></tr></tbody></table>");
        return paraContent;
    }


    private HtmlContent getHtmlContentWithEmbeddedTable2(){
        HtmlContent paraContent = new HtmlContent();
        paraContent.setContentType("HTML");
        paraContent.setHtmlContent("<TABLE WIDTH=\\\"443\\\"  class=\\\"flattable\\\">\n" +
                "\t<THEAD>\n" +
                "\t\t<TR>\n" +
                "\t\t\t<TH COLSPAN=\\\"2\\\" > Drugs marketed for smoking cessation therapy</B>\n" +
                "\t\t</TH>\n" +
                "\t</TR>\n" +
                "</THEAD>\n" +
                "<TBODY>\n" +
                "\t<TR>\n" +
                "\t\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" CLASS=\\\"internalHeader\\\" > Nicotine replacement therapies</B>\n" +
                "\t</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Chewing gum:</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" >\n" +
                "\t\t<UL>\n" +
                "\t\t\t<LI>Nicorette Gum</LI>\n" +
                "\t\t\t<LI>Nicotinell Gum</LI>\n" +
                "\t\t\t<LI>Niquitin CQ Gum</LI>\n" +
                "\t\t\t<LI>Nicogum</LI>\n" +
                "\t\t</UL>\n" +
                "\t</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Transdermal patches:</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" >\n" +
                "\t\t<UL>\n" +
                "\t\t\t<LI>Nicorette Patches</LI>\n" +
                "\t\t\t<LI>Nicotinell Patches</LI>\n" +
                "\t\t\t<LI>Niquitin CQ and Niquitin CQ Clear</LI>\n" +
                "\t\t\t<LI>Nicopatch</LI>\n" +
                "\t\t\t<LI>Habitrol transdermal patches</LI>\n" +
                "\t\t\t<LI>Nicoderm CQ transdermal patches</LI>\n" +
                "\t\t\t<LI>Nicotrol transdermal patches</LI>\n" +
                "\t\t</UL>\n" +
                "\t</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Sublingual tablets:</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" >\n" +
                "\t\t<UL>\n" +
                "\t\t\t<LI>Nicorette microtab</LI>\n" +
                "\t\t</UL>\n" +
                "\t</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Lozenges:</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" >\n" +
                "\t\t<UL>\n" +
                "\t\t\t<LI>Niquitin CQ Lozenges</LI>\n" +
                "\t\t\t<LI>Nicotinell Lozenges</LI>\n" +
                "\t\t\t<LI>Nicopass</LI>\n" +
                "\t\t\t<LI>Commit Lozenges</LI>\n" +
                "\t\t</UL>\n" +
                "\t</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Inhalers:</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" >\n" +
                "\t\t<UL>\n" +
                "\t\t\t<LI>Nicorette inhalation cartridge</LI>\n" +
                "\t\t\t<LI>Nicotrol inhalation cartridge</LI>\n" +
                "\t\t</UL>\n" +
                "\t</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" > Nasal sprays:</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" >\n" +
                "\t\t<UL>\n" +
                "\t\t\t<LI>Nicorette nasal spray</LI>\n" +
                "\t\t\t<LI>Nicotrol nasal spray</LI>\n" +
                "\t\t</UL>\n" +
                "\t</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"2\\\" WIDTH=\\\"443\\\" CLASS=\\\"internalHeader\\\" > Non-nicotine pharmacotherapies</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"223\\\" > Bupropion hydrochloride</TD>\n" +
                "\t<TD WIDTH=\\\"220\\\" > GlaxoSmithKline</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"223\\\" >Varenicline tartrate</TD>\n" +
                "\t<TD WIDTH=\\\"220\\\" > Pfizer</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"223\\\" >Cytisine</TD>\n" +
                "\t<TD WIDTH=\\\"220\\\" > Sopharma</TD>\n" +
                "</TR>\n" +
                "</TBODY>\n" +
                "</TABLE>");
        return paraContent;
    }

    private HtmlContent getHtmlContentWithEmbeddedTable3(){
        HtmlContent paraContent = new HtmlContent();
        paraContent.setContentType("HTML");
        paraContent.setHtmlContent("<TABLE WIDTH=\\\"443\\\"  class=\\\"flattable\\\">\n" +
                "\t<THEAD>\n" +
                "\t\t<TR>\n" +
                "\t\t\t<TH COLSPAN=\\\"3\\\" > Agents marketed for the diagnosis and treatment of prostate cancer</B>\n" +
                "\t\t</TH>\n" +
                "\t</TR>\n" +
                "</THEAD>\n" +
                "<TBODY>\n" +
                "\t<TR>\n" +
                "\t\t<TD WIDTH=\\\"200\\\" CLASS=\\\"internalHeader\\\" > Drug name</B>\n" +
                "\t</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" CLASS=\\\"internalHeader\\\" > Originator/licensee</B>\n" +
                "</TD>\n" +
                "<TD WIDTH=\\\"93\\\" CLASS=\\\"internalHeader\\\" > Year of first launch</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"3\\\" CLASS=\\\"internalHeader\\\"> Antiandrogens</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Bayer</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1973</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Merck & Co.</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1983</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Sanofi</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1987</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > AstraZeneca</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1995</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" (Androcur)</TD>\n" +
                "\t\t\n" +
                "\t<TD WIDTH=\\\"150\\\" > Janssen</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2018</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"3\\\" CLASS=\\\"internalHeader\\\"> Androgen biosynthesis inhibitors</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Zytiga)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Janssen Biotech</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2011</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"3\\\" CLASS=\\\"internalHeader\\\"> Selective androgen receptor modulators</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Astellas/Medivation</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2012</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"3\\\" CLASS=\\\"internalHeader\\\"> Aromatase inhibitors</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Orimeten)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Novartis</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1981</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"3\\\" CLASS=\\\"internalHeader\\\"> GnRH agonists and antagonists</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Enantone)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > AbbVie</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1984</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Suprefact)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Sanofi</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1985</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t Trelstar)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Ferring/Ipsen</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1986</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > AstraZeneca</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1987</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Enantone depot)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Takeda</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1989</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Viadur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Alza/Bayer</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2001</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Eligard)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Sanofi</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2002</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Endo</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2004</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Firmagon)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Ferring</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2009</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"3\\\" CLASS=\\\"internalHeader\\\"> Estrogens and progestogens</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Estradurin)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Pfizer</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1954</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Depo-Provera)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Pfizer</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1985</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"3\\\" CLASS=\\\"internalHeader\\\"> Chemotherapeutic agents</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Estracyt)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Roche</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1980</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Novantrone)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Merck Serono</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1984</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Sanofi</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2004</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Sanofi</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2010</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"3\\\" CLASS=\\\"internalHeader\\\"> Immunotherapeutic cancer vaccines</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Dendreon</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2010</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"3\\\" CLASS=\\\"internalHeader\\\"> Brachytherapy</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\n" +
                "\t<TD WIDTH=\\\"150\\\" > GE Healthcare/Theragenics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > N.A.</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"3\\\" CLASS=\\\"internalHeader\\\"> Treatment of bone metastases</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Amgen</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2010</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t (Xofigo)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Bayer</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2013</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD COLSPAN=\\\"3\\\" CLASS=\\\"internalHeader\\\"> Diagnostic agents</B>\n" +
                "</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Jazz Pharmaceuticals</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 1997</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > C4 Imaging</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2014</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "<TR>\n" +
                "\t<TD WIDTH=\\\"200\\\" >\n" +
                "\t\t(Androcur)</TD>\n" +
                "\t<TD WIDTH=\\\"150\\\" > Blue Earth Diagnostics</TD>\n" +
                "\t<TD WIDTH=\\\"93\\\" > 2016</TD>\n" +
                "</TR>\n" +
                "</TBODY>\n" +
                "</TABLE>");
        return paraContent;
    }



    private HtmlContent getHtmlTableContent(){
        HtmlContent tableContent = new HtmlContent();
        tableContent.setContentType("TABLE");
        tableContent.setHtmlContent(getHtmlTable());
        return tableContent;
    }

    private HtmlContent getImageContent(){
        HtmlContent imageContent = new HtmlContent();
        imageContent.setContentType("IMAGE");
        imageContent.setHtmlContent(getImageFromUrl());
        return imageContent;
    }

    private HtmlTable getHtmlTable(){
        HtmlTable htmlTable = new HtmlTable();
        //htmlTable.setTableHeaderSection(getTableHeaderSection());
        //htmlTable.setTableRowSection(getTableRowSection());
        return htmlTable;
    }


    private TableHeaderSection getTableHeaderSection(){
        TableHeaderSection tableHeaderSection = new TableHeaderSection(getTableHeaders());
        return tableHeaderSection;
    }

    private TableRowSection getTableRowSection(){
     TableRowSection tableRowSection = new TableRowSection(getTableRows());
     return tableRowSection;
    }


    private List getTableHeaders(){
        List<TableHeader> headerList = new ArrayList();

        TableHeader header;
        for(int i =0;i<2;i++){
            header = new TableHeader();
            header.setHeaderName("header "+i);
            headerList.add(header);
        }

    return headerList;
    }



    private List getTableRows(){
        List<TableRow> rows = new ArrayList();

        TableRow tableRow;
        for(int i =0; i<2; i++){
            tableRow= new TableRow();
            //tableRow.setTableColumnSection(getTableColumnSection());
            rows.add(tableRow);
        }

        return  rows;

    }

    private TableColumnSection getTableColumnSection(){
        TableColumnSection tableColumnSection = new TableColumnSection(getTableColumns());
        return tableColumnSection;
    }

    private List getTableColumns(){
        List<TableColumn> columns = new ArrayList<>();
        TableColumn tableColumn;
        for (int i =0;i<2 ; i++){
                tableColumn = new TableColumn();
                //tableColumn.setColumnValue("<a  style=\"color: blue\" href=\"https://stable.cortellis.int.clarivate.com/intelligence/#/report/si/siDiseaseBriefing/116\"><u>Tuberculosis</u></a>");
            tableColumn.setColumnValue(getImageFromUrl());
                columns.add(tableColumn);
        }
        return columns;
    }

    private List getTableRowsOld(){
        List<TableRow> rows = new ArrayList();



       TableRow tableRow;
        for(int i =0; i<10; i++){
            tableRow= new TableRow();
  /*          tableRow.setField1("field1. "+i);
            tableRow.setField2("field2. "+i);
            tableRow.setField3("field3. "+i);*/
            //tableRow.setField4(getImageFromUrl());
            rows.add(tableRow);
        }

     return  rows;

    }


    private InputStream getImageFromUrl() {
        ByteArrayOutputStream bis = new ByteArrayOutputStream();
        InputStream is = null;

        try {
            URL url = new URL("http://diylogodesigns.com/blog/wp-content/uploads/2017/07/java-logo-vector-768x768.png");
             is = url.openStream();
            is = url.openStream ();
            int n;
            byte[] bytebuff =new byte[4096];
            while ( (n = is.read(bytebuff)) > 0 ) {
                bis.write(bytebuff, 0, n);
            }
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return new ByteArrayInputStream(bis.toByteArray());
    }

}
