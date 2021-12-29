package com.clarivate.prototype.api.controller;

import com.clarivate.prototype.api.fiegn.DrugDbRetrieveServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DrugDbRetrieveApiController {

    @Autowired
    private DrugDbRetrieveServiceClient drugDbRetrieveServiceClient;

    @RequestMapping(path = "/companyChartJson", method = RequestMethod.GET)
    public ResponseEntity<List> retrieveCompany(){
       return drugDbRetrieveServiceClient.retrieveCompanyChartData();
    }
}
