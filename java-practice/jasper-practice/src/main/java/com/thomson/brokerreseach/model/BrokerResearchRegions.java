package com.thomson.brokerreseach.model;

import java.util.ArrayList;
import java.util.List;

public class BrokerResearchRegions {
    private String regions;
    private List<BrokerResearchFranchies> franchise;

    public BrokerResearchRegions() {
        this.franchise = new ArrayList<BrokerResearchFranchies>();
    }

    public BrokerResearchRegions(String regions, List<BrokerResearchFranchies> franchise) {
        this.regions = regions;
        this.franchise = franchise;
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions;
    }

    public List<BrokerResearchFranchies> getFranchise() {
        return franchise;
    }

    public void setFranchise(List<BrokerResearchFranchies> franchise) {
        this.franchise = franchise;
    }
}
