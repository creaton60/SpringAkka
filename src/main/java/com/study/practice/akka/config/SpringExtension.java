package com.study.practice.akka.config;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import akka.actor.Actor;
import akka.actor.Extension;
import akka.actor.Props;

/**
 * 
 * <h1> </h1>
 * <p>
 * <b>Note:</b> 
 * @author dklee
 */
@Component
public class SpringExtension implements Extension{

    private ApplicationContext applicationContext;
    
    /**
     * 
     * 
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
     * 
     * 
     *
     * @param
     * @return
     * @exception
     * @see
     */
    public Props props(String actorBeanName){
        return Props.create(SpringActorProducer.class, applicationContext, actorBeanName);
    }
}
