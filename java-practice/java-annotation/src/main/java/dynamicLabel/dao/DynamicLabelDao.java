package dynamicLabel.dao;


public abstract class DynamicLabelDao {

    protected String query;
    protected String jdbcTemplate;

    public DynamicLabelDao(String query, String jdbcTemplate) {
        this.query = query;
        this.jdbcTemplate = jdbcTemplate;
    }

    public abstract String getLabelValue();


}
