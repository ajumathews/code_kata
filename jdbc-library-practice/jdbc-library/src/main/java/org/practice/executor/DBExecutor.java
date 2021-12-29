package org.practice.executor;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DBExecutor {

    private JdbcTemplate jdbcTemplate;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    //1 p cache.

    public DBExecutor(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);

    }

    public List<Map<String,Object>> executeQuery(String sql) {
        return jdbcTemplate.queryForList(sql);
    }


    public List<Map<String,Object>> executeQueryWithParams(String sql) {
        Map<String, String> map = new HashMap();
        map.put("drugId","12135");
        return namedParameterJdbcTemplate.queryForList(sql,map);
    }

}
