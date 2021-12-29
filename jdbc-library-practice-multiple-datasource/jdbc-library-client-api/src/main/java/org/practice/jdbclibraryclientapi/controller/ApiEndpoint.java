package org.practice.jdbclibraryclientapi.controller;

import org.practice.jdbclibraryclientapi.fiegn.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiEndpoint {

    @Autowired
    private  CompanyService companyService;

    @RequestMapping(path = "/companyApi", method = RequestMethod.GET)
    public ResponseEntity<List> retrieveCompany(){
       return companyService.retrieveCompanyChartData();
    }
}
