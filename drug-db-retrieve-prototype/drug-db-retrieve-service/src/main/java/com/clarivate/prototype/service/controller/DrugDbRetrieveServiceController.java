package com.clarivate.prototype.service.controller;


import com.clarivate.prototype.DBExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/service")
public class DrugDbRetrieveServiceController {

    private DBExecutor companyDbExecutor;
    private DBExecutor regionDbExecutor;
    private String companyChartQuery;
    private String regionChartQuery;

    @Autowired
    public DrugDbRetrieveServiceController(
            DBExecutor companyDbExecutor,
            DBExecutor regionDbExecutor,
            @Value("${companyChart.query}") String companyChartQuery,
            @Value("${regionChart.query}") String regionChartQuery) {
        this.companyDbExecutor = companyDbExecutor;
        this.regionDbExecutor = regionDbExecutor;
        this.companyChartQuery = companyChartQuery;
        this.regionChartQuery = regionChartQuery;
    }


    @RequestMapping(value = "/companyChart", method = RequestMethod.GET)
    public ResponseEntity<List> retrieveCompanyChartData() {
        return new ResponseEntity<>(companyDbExecutor.executeQuery(companyChartQuery), HttpStatus.OK);
    }


    @RequestMapping(value = "/regionChart", method = RequestMethod.GET)
    public ResponseEntity<List> retrieveRegionChartData() {
        return new ResponseEntity<>(regionDbExecutor.executeQuery(regionChartQuery), HttpStatus.OK);
    }


}
