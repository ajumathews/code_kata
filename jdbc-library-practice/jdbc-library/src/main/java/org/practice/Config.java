package org.practice;

import org.practice.executor.DBExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
public class Config {

    @Value("${dataSource.url}")
    private String dataSourceUrl;
    @Value("${dataSource.username}")
    private String dataSourceUserName;
    @Value("${dataSource.password}")
    private String dataSourcePassword;

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setUrl(dataSourceUrl);
        dataSource.setUsername(dataSourceUserName);
        dataSource.setPassword(dataSourcePassword);
        return dataSource;
    }


    @Bean
    public DBExecutor dbExecutor() {
        return new DBExecutor(dataSource());
    }


}
