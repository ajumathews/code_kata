package com.clarivate.prototype.service.controller;


import com.clarivate.prototype.executor.DBQueryExecutor;
import com.clarivate.prototype.model.DBInput;
import com.clarivate.prototype.operation.SimpleSelectQueryOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/service")
public class DrugDbRetrieveServiceController {

    private DBQueryExecutor companyDbExecutor;
    private DBQueryExecutor regionDbExecutor;
    private String companyChartQuery;
    private String regionChartQuery;

    @Autowired
    public DrugDbRetrieveServiceController(
            DBQueryExecutor companyDbExecutor,
            DBQueryExecutor regionDbExecutor,
            @Value("${companyChart.query}") String companyChartQuery,
            @Value("${regionChart.query}") String regionChartQuery) {
        this.companyDbExecutor = companyDbExecutor;
        this.regionDbExecutor = regionDbExecutor;
        this.companyChartQuery = companyChartQuery;
        this.regionChartQuery = regionChartQuery;
    }


    @RequestMapping(value = "/companyChart", method = RequestMethod.GET)
    public ResponseEntity<Object> retrieveCompanyChartData() {
        Map<String, String> params = new HashMap<>();
        params.put("drugId", "12135");
        return new ResponseEntity<>(companyDbExecutor.execute(new SimpleSelectQueryOperation(), new DBInput(companyChartQuery, params)), HttpStatus.OK);
    }


    @RequestMapping(value = "/regionChart", method = RequestMethod.GET)
    public ResponseEntity<Object> retrieveRegionChartData() {
        Map<String, String> params = new HashMap<>();
        params.put("drugId", "12135");
        return new ResponseEntity<>(regionDbExecutor.execute(new SimpleSelectQueryOperation(), new DBInput(regionChartQuery, params)), HttpStatus.OK);
    }


}
