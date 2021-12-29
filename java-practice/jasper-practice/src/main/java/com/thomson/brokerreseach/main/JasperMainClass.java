package com.thomson.brokerreseach.main;

import com.thomson.brokerreseach.model.*;
import net.sf.jasperreports.engine.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by U6018134 on 6/5/2018.
 * Copyright 2018 to Aju Mathews. All Rights Reserved.
 */
public class JasperMainClass {


    public static void main(String[] args) throws Exception {
        JasperMainClass jasperMainClass = new JasperMainClass();
        jasperMainClass.generateBrokerReport();
    }


    private void generateBrokerReport() throws Exception {

        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/nextgen_drug.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_all.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_all.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_region.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_region.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_company_region.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_company_region.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_companyRegions.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_companyRegions.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_franchies.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_franchies.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_broker_region.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_broker_region.jasper");



        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_all.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_all.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_company_all.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_company_all.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_item_all.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_item_all.jasper");
        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_subsidiary_all.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug_section_drugSalesAndForecasts_year_subsidiary_all.jasper");

        JasperCompileManager.compileReportToFile("C:/Aju/Learning/code_kata/java-practice/jasper-practice/src/main/resources/brokerResearch/report_footer.jrxml",
                "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/report_footer.jasper");


        String masterReportLocation = "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/resources/brokerResearch/nextgen_drug.jasper";

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("EXPORT_REPORT", getReportDrugDocument());


        JasperPrint jasperPrint = JasperFillManager.fillReport(masterReportLocation, parameters, new JREmptyDataSource());
        JasperExportManager.exportReportToPdfFile(jasperPrint, "C:/Aju/Learning/code_kata/java-practice/jasper-practice/target/brokerResearch/brokerResearch_region_report.pdf");
    }


    private ReportDrugDocument getReportDrugDocument() {
        ReportDrugDocument reportDrugDocument = new ReportDrugDocument();
        reportDrugDocument.setDrugSalesAndForecasts(getDrugSalesForecast());
        return reportDrugDocument;
    }

    private SalesAndForecastsSection getDrugSalesForecast() {
        SalesAndForecastsSection salesAndForecastsSection = new SalesAndForecastsSection();
        salesAndForecastsSection.setYears(getBrokerResearchByCompanyAllYears());
/*
        salesAndForecastsSection.setYearForRegions(getBrokerResearchRegionsForAllYears());
*/
        return salesAndForecastsSection;
    }

    /*company*/
    private List<BrokerResearchYear> getBrokerResearchByCompanyAllYears() {
        List<BrokerResearchYear> brokerResearchYears = new ArrayList<>();
        brokerResearchYears.add(getBrokerResearchYear1());
        brokerResearchYears.add(getBrokerResearchYear2());
        brokerResearchYears.add(getBrokerResearchYear3());
        brokerResearchYears.add(getBrokerResearchYear4());
        brokerResearchYears.add(getBrokerResearchYear5());
        brokerResearchYears.add(getBrokerResearchYear6());
        brokerResearchYears.add(getBrokerResearchYear7());
        brokerResearchYears.add(getBrokerResearchYear8());
        return brokerResearchYears;
    }

    private BrokerResearchYear getBrokerResearchYear1() {
        BrokerResearchYear brokerResearchYear = new BrokerResearchYear();
        brokerResearchYear.setYear("2019");
        brokerResearchYear.setTotal("1235");
        brokerResearchYear.setCompanies(getBrokerResearchByCompanies());
        return brokerResearchYear;
    }

    private BrokerResearchYear getBrokerResearchYear2() {
        BrokerResearchYear brokerResearchYear = new BrokerResearchYear();
        brokerResearchYear.setYear("2020");
        brokerResearchYear.setTotal("1235");
        brokerResearchYear.setCompanies(getBrokerResearchByCompanies());
        return brokerResearchYear;
    }

    private BrokerResearchYear getBrokerResearchYear3() {
        BrokerResearchYear brokerResearchYear = new BrokerResearchYear();
        brokerResearchYear.setYear("2021");
        brokerResearchYear.setTotal("1235");
        brokerResearchYear.setCompanies(getBrokerResearchByCompanies());
        return brokerResearchYear;
    }
    private BrokerResearchYear getBrokerResearchYear4() {
        BrokerResearchYear brokerResearchYear = new BrokerResearchYear();
        brokerResearchYear.setYear("2022");
        brokerResearchYear.setTotal("1235");
        brokerResearchYear.setCompanies(getBrokerResearchByCompanies());
        return brokerResearchYear;
    }
    private BrokerResearchYear getBrokerResearchYear5() {
        BrokerResearchYear brokerResearchYear = new BrokerResearchYear();
        brokerResearchYear.setYear("2024");
        brokerResearchYear.setTotal("1235");
        brokerResearchYear.setCompanies(getBrokerResearchByCompanies());
        return brokerResearchYear;
    }
    private BrokerResearchYear getBrokerResearchYear6() {
        BrokerResearchYear brokerResearchYear = new BrokerResearchYear();
        brokerResearchYear.setYear("2025");
        brokerResearchYear.setTotal("1235");
        brokerResearchYear.setCompanies(getBrokerResearchByCompanies());
        return brokerResearchYear;
    }
    private BrokerResearchYear getBrokerResearchYear7() {
        BrokerResearchYear brokerResearchYear = new BrokerResearchYear();
        brokerResearchYear.setYear("2026");
        brokerResearchYear.setTotal("1235");
        brokerResearchYear.setCompanies(getBrokerResearchByCompanies());
        return brokerResearchYear;
    }
    private BrokerResearchYear getBrokerResearchYear8() {
        BrokerResearchYear brokerResearchYear = new BrokerResearchYear();
        brokerResearchYear.setYear("2027");
        brokerResearchYear.setTotal("1235");
        brokerResearchYear.setCompanies(getBrokerResearchByCompanies());
        return brokerResearchYear;
    }

    private List<BrokerResearchCompany> getBrokerResearchByCompanies() {
        List<BrokerResearchCompany> brokerResearchCompanies= new ArrayList<>();
        brokerResearchCompanies.add(getBrokerResearchByCompany1());
        brokerResearchCompanies.add(getBrokerResearchByCompany2());
        brokerResearchCompanies.add(getBrokerResearchByCompany2());
        brokerResearchCompanies.add(getBrokerResearchByCompany2());
        brokerResearchCompanies.add(getBrokerResearchByCompany2());
        return brokerResearchCompanies;
    }

    private BrokerResearchCompany getBrokerResearchByCompany1() {
        BrokerResearchCompany brokerResearchCompany = new BrokerResearchCompany();
        brokerResearchCompany.setName("Proceedings of the National Academy of Sciences of the United States of America  -- no problem since outer elements wrap");
        brokerResearchCompany.setTotal("456");
        brokerResearchCompany.setSubsidiaries(getSubsidaries());
        return brokerResearchCompany;
    }

    private BrokerResearchCompany getBrokerResearchByCompany2() {
        BrokerResearchCompany brokerResearchCompany = new BrokerResearchCompany();
        brokerResearchCompany.setName("Fondazione Salvatore Maugeri Clinica del Lavoro e della Riabilitazione IRCCS");
        brokerResearchCompany.setTotal("456");
        brokerResearchCompany.setSubsidiaries(getSubsidaries());
        return brokerResearchCompany;
    }

    private List<BrokerResearchSubsidiary> getSubsidaries() {
        List<BrokerResearchSubsidiary> brokerResearchSubsidiaries = new ArrayList<>();
        brokerResearchSubsidiaries.add(getSubsadary1());
        brokerResearchSubsidiaries.add(getSubsadary2());
        return  brokerResearchSubsidiaries;
    }

    private BrokerResearchSubsidiary getSubsadary1() {
        BrokerResearchSubsidiary brokerResearchSubsidiary = new BrokerResearchSubsidiary();
        brokerResearchSubsidiary.setFranchise("Hypertension, angiotensin II antagonists + calcium antagonists");
        brokerResearchSubsidiary.setMean("987");
        brokerResearchSubsidiary.setRegions("US");
        brokerResearchSubsidiary.setItems(getBrokerResearchItems());
        return brokerResearchSubsidiary;
    }


    private BrokerResearchSubsidiary getSubsadary2() {
        BrokerResearchSubsidiary brokerResearchSubsidiary = new BrokerResearchSubsidiary();
        brokerResearchSubsidiary.setFranchise("Hypertension, angiotensin II antagonists + calcium antagonists");
        brokerResearchSubsidiary.setMean("987");
        brokerResearchSubsidiary.setRegions("US");
        brokerResearchSubsidiary.setItems(getBrokerResearchItems());
        return brokerResearchSubsidiary;
    }



    /*Region*/
    private List<BrokerResearchYearForRegions> getBrokerResearchRegionsForAllYears() {
        List<BrokerResearchYearForRegions> brokerResearchYearForRegionsForYears = new ArrayList<>();
        brokerResearchYearForRegionsForYears.add(getBrokerResearchRegionYear1());
        brokerResearchYearForRegionsForYears.add(getBrokerResearchRegionYear2());
        brokerResearchYearForRegionsForYears.add(getBrokerResearchRegionYear3());
        brokerResearchYearForRegionsForYears.add(getBrokerResearchRegionYear4());
        brokerResearchYearForRegionsForYears.add(getBrokerResearchRegionYear5());
        brokerResearchYearForRegionsForYears.add(getBrokerResearchRegionYear6());
        brokerResearchYearForRegionsForYears.add(getBrokerResearchRegionYear7());
        brokerResearchYearForRegionsForYears.add(getBrokerResearchRegionYear8());

        return brokerResearchYearForRegionsForYears;
    }

    private BrokerResearchYearForRegions getBrokerResearchRegionYear1() {
        BrokerResearchYearForRegions brokerResearchYearForRegions = new BrokerResearchYearForRegions();
        brokerResearchYearForRegions.setYear("2020");
        brokerResearchYearForRegions.setResearchCompany(getBrokerResearchCompanies());
        return brokerResearchYearForRegions;
    }


    private BrokerResearchYearForRegions getBrokerResearchRegionYear2() {
        BrokerResearchYearForRegions brokerResearchYearForRegions = new BrokerResearchYearForRegions();
        brokerResearchYearForRegions.setYear("2021");
        brokerResearchYearForRegions.setResearchCompany(getBrokerResearchCompanies());
        return brokerResearchYearForRegions;
    }

    private BrokerResearchYearForRegions getBrokerResearchRegionYear3() {
        BrokerResearchYearForRegions brokerResearchYearForRegions = new BrokerResearchYearForRegions();
        brokerResearchYearForRegions.setYear("2022");
        brokerResearchYearForRegions.setResearchCompany(getBrokerResearchCompanies());
        return brokerResearchYearForRegions;
    }

    private BrokerResearchYearForRegions getBrokerResearchRegionYear4() {
        BrokerResearchYearForRegions brokerResearchYearForRegions = new BrokerResearchYearForRegions();
        brokerResearchYearForRegions.setYear("2023");
        brokerResearchYearForRegions.setResearchCompany(getBrokerResearchCompanies());
        return brokerResearchYearForRegions;
    }

    private BrokerResearchYearForRegions getBrokerResearchRegionYear5() {
        BrokerResearchYearForRegions brokerResearchYearForRegions = new BrokerResearchYearForRegions();
        brokerResearchYearForRegions.setYear("2024");
        brokerResearchYearForRegions.setResearchCompany(getBrokerResearchCompanies());
        return brokerResearchYearForRegions;
    }

    private BrokerResearchYearForRegions getBrokerResearchRegionYear6() {
        BrokerResearchYearForRegions brokerResearchYearForRegions = new BrokerResearchYearForRegions();
        brokerResearchYearForRegions.setYear("2025");
        brokerResearchYearForRegions.setResearchCompany(getBrokerResearchCompanies());
        return brokerResearchYearForRegions;
    }

    private BrokerResearchYearForRegions getBrokerResearchRegionYear7() {
        BrokerResearchYearForRegions brokerResearchYearForRegions = new BrokerResearchYearForRegions();
        brokerResearchYearForRegions.setYear("2026");
        brokerResearchYearForRegions.setResearchCompany(getBrokerResearchCompanies());
        return brokerResearchYearForRegions;
    }

    private BrokerResearchYearForRegions getBrokerResearchRegionYear8() {
        BrokerResearchYearForRegions brokerResearchYearForRegions = new BrokerResearchYearForRegions();
        brokerResearchYearForRegions.setYear("2027");
        brokerResearchYearForRegions.setResearchCompany(getBrokerResearchCompanies());
        return brokerResearchYearForRegions;
    }


    private List<BrokerResearchCompanyForRegions> getBrokerResearchCompanies() {
        List<BrokerResearchCompanyForRegions> brokerResearchCompanyForRegions = new ArrayList<>();
        brokerResearchCompanyForRegions.add(getBrokerResearchCompany1());
        brokerResearchCompanyForRegions.add(getBrokerResearchCompany2());
        brokerResearchCompanyForRegions.add(getBrokerResearchCompany2());
        brokerResearchCompanyForRegions.add(getBrokerResearchCompany2());
        brokerResearchCompanyForRegions.add(getBrokerResearchCompany2());
        brokerResearchCompanyForRegions.add(getBrokerResearchCompany2());
        return brokerResearchCompanyForRegions;
    }

    private BrokerResearchCompanyForRegions getBrokerResearchCompany1() {
        BrokerResearchCompanyForRegions brokerResearchCompanyForRegions = new BrokerResearchCompanyForRegions();
        brokerResearchCompanyForRegions.setName("Company1");
        brokerResearchCompanyForRegions.setResearchRegions(getResearchRegions());
        return brokerResearchCompanyForRegions;
    }


    private BrokerResearchCompanyForRegions getBrokerResearchCompany2() {
        BrokerResearchCompanyForRegions brokerResearchCompanyForRegions = new BrokerResearchCompanyForRegions();
        brokerResearchCompanyForRegions.setName("Fondazione Salvatore Maugeri Clinica del Lavoro e della Riabilitazione IRCCS");
        brokerResearchCompanyForRegions.setResearchRegions(getResearchRegions());
        return brokerResearchCompanyForRegions;
    }

    private List<BrokerResearchRegions> getResearchRegions() {
        List<BrokerResearchRegions> brokerResearchRegions= new ArrayList<>();
        brokerResearchRegions.add(getBrokerResearchRegion1());
        brokerResearchRegions.add(getBrokerResearchRegion2());
        return brokerResearchRegions;
    }

    private BrokerResearchRegions getBrokerResearchRegion1() {
        BrokerResearchRegions brokerResearchRegions = new BrokerResearchRegions();
        brokerResearchRegions.setRegions("OTHER");
        brokerResearchRegions.setFranchise(getFranchises());
        return brokerResearchRegions;
    }

    private BrokerResearchRegions getBrokerResearchRegion2() {
        BrokerResearchRegions brokerResearchRegions = new BrokerResearchRegions();
        brokerResearchRegions.setRegions("EU");
        brokerResearchRegions.setFranchise(getFranchises());
        return brokerResearchRegions;
    }

    private List<BrokerResearchFranchies> getFranchises() {
        List<BrokerResearchFranchies> franchises = new ArrayList<>();
        franchises.add(getFranchise1());
        franchises.add(getFranchise2());
        return franchises;
    }

    private BrokerResearchFranchies getFranchise1() {
        BrokerResearchFranchies brokerResearchFranchise = new BrokerResearchFranchies();
        brokerResearchFranchise.setFranchise("Hypertensi");

/*
        brokerResearchFranchise.setFranchise("Hypertension, angiotensin II antagonists + calcium antagonists");
*/
        brokerResearchFranchise.setMean("123");
        brokerResearchFranchise.setItems(getBrokerResearchItems());
        return brokerResearchFranchise;
    }

    private BrokerResearchFranchies getFranchise2() {
        BrokerResearchFranchies brokerResearchFranchise = new BrokerResearchFranchies();
        brokerResearchFranchise.setFranchise("Hypertension, angiotensin II antagonists + calcium antagonists");
        brokerResearchFranchise.setMean("123");
        brokerResearchFranchise.setItems(getBrokerResearchItems());
        return brokerResearchFranchise;
    }


    private List<BrokerResearchItem> getBrokerResearchItems() {
        List<BrokerResearchItem> brokerResearchItems= new ArrayList<>();
        brokerResearchItems.add(getBrokerResearchItem1());
        brokerResearchItems.add(getBrokerResearchItem2());
        return brokerResearchItems;

    }

    private BrokerResearchItem getBrokerResearchItem1() {
        BrokerResearchItem brokerResearchItem = new BrokerResearchItem();
        brokerResearchItem.setData("26-Aug-2019");
        brokerResearchItem.setName("Proceedings ");
        brokerResearchItem.setValue("345");
        return brokerResearchItem;
    }

    private BrokerResearchItem getBrokerResearchItem2() {
        BrokerResearchItem brokerResearchItem = new BrokerResearchItem();
        brokerResearchItem.setData("26-Feb-2019");
        brokerResearchItem.setName("BrokerName2");
        brokerResearchItem.setValue("345");
        return brokerResearchItem;
    }


}
