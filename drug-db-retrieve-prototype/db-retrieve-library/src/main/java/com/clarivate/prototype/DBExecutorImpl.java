package com.clarivate.prototype;


import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class DBExecutorImpl implements DBExecutor {

    private JdbcTemplate jdbcTemplate;

    public DBExecutorImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String,Object>> executeQuery(String sql) {
        return jdbcTemplate.queryForList(sql);
    }


}
