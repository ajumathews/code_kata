package com.grace.springbootquartz.job;

import com.grace.springbootquartz.service.SimpleService;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SimpleJob implements Job {

    @Autowired
    private  SimpleService  service;
//
//    @Autowired
//    public SimpleJob(SimpleService service) {
//        this.service = service;
//    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        service.process();
    }
}
