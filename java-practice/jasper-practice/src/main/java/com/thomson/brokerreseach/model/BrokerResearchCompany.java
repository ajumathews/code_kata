/*
 * Copyright 2015 Thomson Reuters Global Resources. All Rights Reserved.
 *
 * Proprietary and confidential information of TRGR. Disclosure, use,
 * or reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomson.brokerreseach.model;

import java.util.List;

public class BrokerResearchCompany {

    private String name;

    private List<BrokerResearchSubsidiary> subsidiaries;

    private String total;


    public BrokerResearchCompany() {
    }

    public BrokerResearchCompany(String name, String total, List<BrokerResearchSubsidiary> subsidiaries) {
        this.name = name;
        this.subsidiaries = subsidiaries;
        this.total = total;
    }

    public List<BrokerResearchSubsidiary> getSubsidiaries() {
        return subsidiaries;
    }

    public void setSubsidiaries(List<BrokerResearchSubsidiary> subsidiaries) {
        this.subsidiaries = subsidiaries;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
