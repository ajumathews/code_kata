package com.grace.springbootquartzv2.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import com.grace.springbootquartzv2.jobs.HelloWorldJob;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SchedulerService {

    private static final Logger LOG = LoggerFactory.getLogger(HelloWorldJob.class);

    private final Scheduler scheduler;

    @Autowired
    public SchedulerService(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    @PostConstruct
    public void init(){
        try{
            scheduler.start();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }

    @PreDestroy
    public void preDestroy(){
        try{
            scheduler.shutdown();
        } catch (SchedulerException e) {
            throw new RuntimeException(e);
        }
    }
}

