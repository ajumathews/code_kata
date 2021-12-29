package com.test;

import com.springboot.demo.SpringbootDemoAppApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = {SpringbootDemoAppApplication.class},
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles(value = "test")
public class TestHelloWorld {

    @LocalServerPort
    protected int randomServerPort;

    @Autowired
    protected TestRestTemplate restTemplate;


    @Test
    public void test1() {
        String response = restTemplate.getForObject("http://localhost:" + randomServerPort + "/hello", String.class);
        System.out.println(response);
        Assert.assertEquals("hello test", response);
    }

}
