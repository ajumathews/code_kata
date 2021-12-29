package org.practice;

import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

public class DBExecutor {

    private JdbcTemplate jdbcTemplate;
    private String sql;

    public DBExecutor(DataSource dataSource, String sql) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.sql =sql;
    }

    public String executeQuery() {
        return jdbcTemplate.queryForObject(sql, String.class);
    }


}
