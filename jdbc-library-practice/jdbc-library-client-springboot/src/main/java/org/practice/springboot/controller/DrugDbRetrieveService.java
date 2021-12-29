package org.practice.springboot.controller;

import org.practice.executor.DBExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/retrieve")
@PropertySource("classpath:/application.properties")
public class DrugDbRetrieveService {

    @Autowired
    private DBExecutor dbExecutor;


    @Value("${companyChart.query}")
    private String companyChartQuery;

    @Value("${regionChart.query}")
    private String regionChartQuery;


    @RequestMapping(value = "/companyChart", method = RequestMethod.GET)
    public List<Map<String,Object>> retrieveCompanyChartData() {
        return dbExecutor.executeQuery(companyChartQuery);
    }


    @RequestMapping(value = "/regionChart", method = RequestMethod.GET)
    public List<Map<String,Object>>  retrieveRegionChartData() {
        return dbExecutor.executeQueryWithParams(regionChartQuery);
    }


}
