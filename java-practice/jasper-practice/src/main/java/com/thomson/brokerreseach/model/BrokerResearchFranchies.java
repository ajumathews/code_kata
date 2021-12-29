package com.thomson.brokerreseach.model;

import java.util.ArrayList;
import java.util.List;

public class BrokerResearchFranchies {
    private String franchise;

    private String mean;

    private List<BrokerResearchItem> items;

    public BrokerResearchFranchies() {
        this.items = new ArrayList<BrokerResearchItem>();
    }

    public BrokerResearchFranchies(String franchise, String mean, List<BrokerResearchItem> items) {
        this.franchise = franchise;
        this.mean = mean;
        this.items = items;
    }

    public String getFranchise() {
        return franchise;
    }

    public void setFranchise(String franchise) {
        this.franchise = franchise;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public List<BrokerResearchItem> getItems() {
        return items;
    }

    public void setItems(List<BrokerResearchItem> items) {
        this.items = items;
    }
}
