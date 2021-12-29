/*
 * Copyright 2015 Thomson Reuters Global Resources. All Rights Reserved.
 *
 * Proprietary and confidential information of TRGR. Disclosure, use,
 * or reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomson.brokerreseach.model;

public class BrokerResearchItem {

    private String name;

    private String data;

    private String value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}