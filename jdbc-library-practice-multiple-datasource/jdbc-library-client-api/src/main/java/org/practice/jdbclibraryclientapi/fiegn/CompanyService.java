package org.practice.jdbclibraryclientapi.fiegn;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "JDBC-LIBRARY-CLIENT")
public interface CompanyService {

    @RequestMapping(value = "/retrieve/companyChart", method = RequestMethod.GET)
    public ResponseEntity<List> retrieveCompanyChartData();

}
