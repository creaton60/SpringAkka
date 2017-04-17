package com.study.practice.akka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import akka.actor.ActorSystem;

@Configuration
@ComponentScan(basePackages={"com.study.practice.akka"})
public class SpringAkkaConfig {
    
    @Autowired
    private ApplicationContext applicationContext;
    
    @Autowired
    private SpringExtension springExtension;

    /**
     * 
     * 
     *
     * @param
     * @return
     * @exception
     * @see
     */
    @Bean
    public ActorSystem actorSystem(){
        ActorSystem system = ActorSystem.create("Spring-Boot-Akka", akkaConfiguration());
        springExtension.initialize(applicationContext);
        
        return system;
    }
    
    /**
     * 
     * 
     *
     * @param
     * @return
     * @exception
     * @see
     */
    @Bean
    public Config akkaConfiguration(){
        return ConfigFactory.load();
    }
}
