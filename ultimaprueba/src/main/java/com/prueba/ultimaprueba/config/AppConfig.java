package com.prueba.ultimaprueba.config;


import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class AppConfig {

    @Bean
    public DataSource dataSource() {
        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
        dataSourceBuilder.url("jdbc:sqlserver://192.168.10.136;databaseName=gifato;trustServerCertificate=true");
        dataSourceBuilder.username("sa");
        dataSourceBuilder.password("sqlserver");


        return dataSourceBuilder.build();

    }
}
