package dynamicLabel.dao;


public class DrugSalesYearEstimateWithQueryDao extends DynamicLabelDao {

    public DrugSalesYearEstimateWithQueryDao(String query,String jdbcTemplate) {
        super(query,jdbcTemplate);
    }

    @Override
    public String getLabelValue() {
        /*populating value after DB execution*/
        System.out.println(query);
        int databaseValue = 2019;
        return "Total Forecast Sales " + databaseValue + " (USD M)";
    }

}
