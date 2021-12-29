package com.clarivate.prototype.service.config;

import com.clarivate.prototype.executor.DBQueryExecutor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfig {

    @Bean
    @ConfigurationProperties("company.datasource")
    public DataSource companyDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    @ConfigurationProperties("region.datasource")
    public DataSource regionDataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean
    public DBQueryExecutor companyDbExecutor() {
        return new DBQueryExecutor(companyDataSource());
    }


    @Bean
    public DBQueryExecutor regionDbExecutor() {
        return new DBQueryExecutor(regionDataSource());
    }

}
