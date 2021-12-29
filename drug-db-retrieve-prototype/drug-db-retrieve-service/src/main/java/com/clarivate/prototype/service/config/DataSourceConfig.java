package com.clarivate.prototype.service.config;

import com.clarivate.prototype.DBExecutor;
import com.clarivate.prototype.DBExecutorImpl;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

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
    public DBExecutor companyDbExecutor() {
        return new DBExecutorImpl(new JdbcTemplate(companyDataSource()));
    }


    @Bean
    public DBExecutor regionDbExecutor() {
        return new DBExecutorImpl(new JdbcTemplate(regionDataSource()));
    }

}
