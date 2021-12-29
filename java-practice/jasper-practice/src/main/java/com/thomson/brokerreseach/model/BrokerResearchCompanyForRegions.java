package com.thomson.brokerreseach.model;

import java.util.ArrayList;
import java.util.List;

public class BrokerResearchCompanyForRegions {
    private String name;
    private List<BrokerResearchRegions> researchRegions;

    public BrokerResearchCompanyForRegions() {
        this.researchRegions = new ArrayList<BrokerResearchRegions>();
    }

    public BrokerResearchCompanyForRegions(String name, List<BrokerResearchRegions> researchRegions) {
        this.name = name;
        this.researchRegions = researchRegions;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BrokerResearchRegions> getResearchRegions() {
        return researchRegions;
    }

    public void setResearchRegions(List<BrokerResearchRegions> researchRegions) {
        this.researchRegions = researchRegions;
    }
}
