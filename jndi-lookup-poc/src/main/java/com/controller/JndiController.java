package com.controller;


import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

public class JndiController {

    private JdbcTemplate jdbcTemplate;

    public JndiController(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate(dataSource);
    }


    @Path("/hello/")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public String sayHello() {
        return "hello";
    }

    @Path("/executeQuery/")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public String executeQuery() {
        String output =jdbcTemplate.queryForObject("select * from dual", null, String.class);
        return output;
    }



    @Path("/executeSalesForecastQuery/")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public String executeSalesForecastQuery() {
        String output =jdbcTemplate.queryForObject("select count(*) from sales_dy_ww_mean", null, String.class);
        return output;
    }


}
