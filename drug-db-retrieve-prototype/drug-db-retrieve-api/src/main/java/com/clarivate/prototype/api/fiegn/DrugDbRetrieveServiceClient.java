package com.clarivate.prototype.api.fiegn;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(value = "DRUG-DB-RETRIEVE-SERVICE")
public interface DrugDbRetrieveServiceClient {

    @RequestMapping(value = "/service/companyChart", method = RequestMethod.GET)
    public ResponseEntity<List> retrieveCompanyChartData();

}
