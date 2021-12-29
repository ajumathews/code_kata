package dynamicLabel.document;

import dynamicLabel.annotation.DocumentColumn;
import dynamicLabel.annotation.DynamicLabelWithQuery;
import dynamicLabel.dao.DrugSalesYearEstimateDao;
import dynamicLabel.annotation.DynamicLabel;
import dynamicLabel.dao.DrugSalesYearEstimateWithQueryDao;

public class DrugDocument {

    @DocumentColumn(label="Drug Name")
    public String drugNameDisplay;

    @DynamicLabel(dataSource = DrugSalesYearEstimateDao.class)
    @DocumentColumn(label="Total Forecast Sales {year} (USD M)")
    public String drugSalesYearEstimate;


    @DynamicLabelWithQuery(dataSource = DrugSalesYearEstimateWithQueryDao.class,query = "select * from dual")
    @DocumentColumn(label="Total Forecast Sales {year} (USD M)")
    public String drugSalesYearMeanOne;


}
