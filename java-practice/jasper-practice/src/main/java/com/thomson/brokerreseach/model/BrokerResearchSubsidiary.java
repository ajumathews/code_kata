/*
 * Copyright 2015 Thomson Reuters Global Resources. All Rights Reserved.
 *
 * Proprietary and confidential information of TRGR. Disclosure, use,
 * or reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomson.brokerreseach.model;

import java.util.ArrayList;
import java.util.List;

public class BrokerResearchSubsidiary {

    private String regions;

    private String franchise;

    private String mean;

    private List<BrokerResearchItem> items;

    public BrokerResearchSubsidiary(){
        this.items= new ArrayList<BrokerResearchItem>();
    }

    public String getRegions() {
        return regions;
    }

    public void setRegions(String regions) {
        this.regions = regions;
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
