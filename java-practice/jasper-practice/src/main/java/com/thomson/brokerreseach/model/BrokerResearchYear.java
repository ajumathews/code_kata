/*
 * Copyright 2015 Thomson Reuters Global Resources. All Rights Reserved.
 *
 * Proprietary and confidential information of TRGR. Disclosure, use,
 * or reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomson.brokerreseach.model;

import java.util.ArrayList;
import java.util.List;

public class BrokerResearchYear {

    private String year;

    private String total;

    private List<BrokerResearchCompany> companies;

    public BrokerResearchYear() {
    }

    public BrokerResearchYear(String year) {
        this.companies = new ArrayList<BrokerResearchCompany>();
        this.year = year;
    }

    public BrokerResearchYear(String year, String total) {
        this.companies = new ArrayList<BrokerResearchCompany>();
        this.year = year;
        this.total = total;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public List<BrokerResearchCompany> getCompanies() {
        return companies;
    }

    public void setCompanies(List<BrokerResearchCompany> companies) {
        this.companies = companies;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}