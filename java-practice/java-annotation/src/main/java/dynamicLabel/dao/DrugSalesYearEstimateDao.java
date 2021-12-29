package dynamicLabel.dao;


public class DrugSalesYearEstimateDao extends DynamicLabelDao{


	private String query = "select VALUE from JPA_PRODUCT_SETTINGS where key = 'SALES_GRAPH_YEAR_END'";

	public DrugSalesYearEstimateDao(String query,String jdbcTemplate){
		super(query,jdbcTemplate);
	}


	@Override
	public String getLabelValue() {
		/*populating value after DB execution*/
		System.out.println(query);
		int databaseValue =2019;
		return "Total Forecast Sales "+ databaseValue +" (USD M)";
	}

}
