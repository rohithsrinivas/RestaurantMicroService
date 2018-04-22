package com.restaurant.config;

import javax.sql.DataSource;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.restaurant.service.RestaurantService;
import com.restaurant.service.RestaurantServiceImpl;

@Configuration
@EntityScan(basePackages="com.restaurant.model")
@ComponentScan(basePackages="com.restaurant.*")
@EnableJpaRepositories(basePackages="com.restaurant.repo")
@EnableTransactionManagement
public class RestaurantConfig {

	public RestaurantService restaurantService() {
		return new RestaurantServiceImpl();
	}
	

    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

}
