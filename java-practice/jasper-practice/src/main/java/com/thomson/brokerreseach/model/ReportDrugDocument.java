/*
 * Copyright 2015 Thomson Reuters Global Resources. All Rights Reserved.
 *
 * Proprietary and confidential information of TRGR. Disclosure, use,
 * or reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomson.brokerreseach.model;

public class ReportDrugDocument {


    private SalesAndForecastsSection drugSalesAndForecasts;

    public SalesAndForecastsSection getDrugSalesAndForecasts() {
        return drugSalesAndForecasts;
    }

    public void setDrugSalesAndForecasts(SalesAndForecastsSection drugSalesAndForecasts) {
        this.drugSalesAndForecasts = drugSalesAndForecasts;
    }
}
