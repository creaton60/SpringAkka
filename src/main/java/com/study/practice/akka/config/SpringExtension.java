package com.study.practice.akka.config;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import akka.actor.Extension;
import akka.actor.Props;

/**
 * 
 * <h1>Spring Extension</h1>
 * <p>
 * <b>Note:</b> Extends akka actor system to use akka with spring-boot
 * 
 * @author dklee
 */
@Component
public class SpringExtension implements Extension{

    private ApplicationContext applicationContext;
    
    /**
     * 
     * This method initailizes the spring applicationcontext
     *
     * @param
     * @return
     * @exception
     * @see
     */
    public void initialize(ApplicationContext applicationContext){
        this.applicationContext = applicationContext;
    }
    
    /**
     * Props is a configuration object using in creating an Actor; it is immutable, 
     * so it is thread-safe and fully shareable.
     *
     * This method uses actorBeanName to create an actor in spring-boot
     *
     * @param
     * @return {@link Props}
     * @exception
     * @see
     */
    public Props props(String actorBeanName){
        return Props.create(SpringActorProducer.class, applicationContext, actorBeanName);
    }
}
