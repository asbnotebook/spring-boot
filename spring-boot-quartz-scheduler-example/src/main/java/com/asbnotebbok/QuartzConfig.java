/*
package com.asbnotebbok;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class QuartzConfig {

    @Autowired
    ApplicationContext applicationContext;

    @Bean
    public SchedulerFactoryBean schedulerFactoryBean(DataSource dataSource){
        SchedulerFactoryBean schedulerFactoryBean = new SchedulerFactoryBean();
        Properties properties = new Properties();
        properties.setProperty("org.quartz.jobStore.driverDelegateClass", "");
        schedulerFactoryBean.setQuartzProperties(properties);
        schedulerFactoryBean.setDataSource(dataSource);
        schedulerFactoryBean.setJobFactory(springBeanJobFactory());
       return schedulerFactoryBean;
    }

    @Bean
    public SpringBeanJobFactory springBeanJobFactory(){
        SpringBeanJobFactory jobFactory = new SpringBeanJobFactory();
        jobFactory.setApplicationContext(applicationContext);
        return jobFactory;
    }
}
*/
