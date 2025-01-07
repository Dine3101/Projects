package com.pjadm.project.profilemanager.configurations;



import jakarta.persistence.EntityManagerFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "EventBuddyEntityManagerFactory"
)
public class EventBuddyDataSourceConfiguration {


    @Primary
    @Bean(name="EventBuddyDataSourceProperties")
    @ConfigurationProperties(prefix="spring.datasource.eventbuddy")
    public DataSourceProperties eventBuddyDataSourceProperties(){
        return new DataSourceProperties();
    }
    @Primary
    @Bean(name="EventBuddyDataSource")
    public DataSource eventBuddyDataSource(@Qualifier("EventBuddyDataSourceProperties")DataSourceProperties dataSourceProperties){
        DriverManagerDataSource dataSource=new DriverManagerDataSource();
        dataSource.setUrl(dataSourceProperties.getUrl());
        dataSource.setUsername(dataSourceProperties.getUsername());
        dataSource.setPassword(dataSourceProperties.getPassword());
        dataSource.setDriverClassName(dataSourceProperties.getDriverClassName());
        return dataSource;
    }


    @Primary
    @Bean(name="EventBuddyEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean eventBuddyEntityManagerFactory(EntityManagerFactoryBuilder builder, @Qualifier("EventBuddyDataSource") DataSource dataSource){

        return builder
                .dataSource(dataSource)
                .packages("com.pjadm.project.profilemanager.eventbuddy.entities")
                .persistenceUnit("EventBuddy")
                .build();
    }

    @Primary
    @Bean(name="EventBuddyTransactionManager")
    public PlatformTransactionManager eventBuddyTransactionManager(@Qualifier("EventBuddyEntityManagerFactory")EntityManagerFactory entityManagerFactory){
        return new JpaTransactionManager(entityManagerFactory);
    }
}
