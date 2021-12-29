/*
 * Copyright 2015 Thomson Reuters Global Resources. All Rights Reserved.
 *
 * Proprietary and confidential information of TRGR. Disclosure, use,
 * or reproduction without the written authorization of TRGR is prohibited.
 */
package com.thomson.brokerreseach.model;

import com.thomson.ls.soa.stack.soaservices.service.export.domain.annotation.DataSource;
import com.thomson.ls.soa.stack.soaservices.service.export.domain.annotation.ExportDomain;
import com.thomson.ls.soa.stack.soaservices.service.export.domain.annotation.ExportServiceField;
import org.apache.commons.collections.CollectionUtils;

import java.io.InputStream;
import java.util.List;

@ExportDomain
public class SalesAndForecastsSection {


    @ExportServiceField(dataSource = DataSource.CHARTS)
    private List<BrokerResearchYear> years;

    @ExportServiceField(dataSource = DataSource.CHARTS)
    private List<BrokerResearchYearForRegions> yearForRegions;

    public List<BrokerResearchYearForRegions> getYearForRegions() {
        return yearForRegions;
    }

    public void setYearForRegions(List<BrokerResearchYearForRegions> yearForRegions) {
        this.yearForRegions = yearForRegions;
    }

    public List<BrokerResearchYear> getYears() {
        return years;
    }

    public void setYears(List<BrokerResearchYear> years) {
        this.years = years;
    }
}