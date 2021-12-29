package com.thomson.brokerreseach.model;

import java.util.ArrayList;
import java.util.List;

public class BrokerResearchYearForRegions {
    private String year;


    private List<BrokerResearchCompanyForRegions> researchCompany;

    public BrokerResearchYearForRegions() {
        this.researchCompany = new ArrayList<BrokerResearchCompanyForRegions>();
    }

    public BrokerResearchYearForRegions(String year, List<BrokerResearchCompanyForRegions> researchCompany) {
        this.year = year;
        this.researchCompany = researchCompany;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<BrokerResearchCompanyForRegions> getResearchCompany() {
        return researchCompany;
    }

    public void setResearchCompany(List<BrokerResearchCompanyForRegions> researchCompany) {
        this.researchCompany = researchCompany;
    }
}
