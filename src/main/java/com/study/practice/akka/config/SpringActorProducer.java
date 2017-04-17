package com.study.practice.akka.config;

import org.springframework.context.ApplicationContext;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;

/**
 * 
 * <h1> </h1>
 * <p>
 * <b>Note:</b> 
 * @author dklee
 */
public class SpringActorProducer implements IndirectActorProducer{

    final private ApplicationContext applicationContext;
    final private String actorBeanName;
    
    /**
     * 
     * @param applicationContext
     * @param actorBeanName
     */
    public SpringActorProducer(ApplicationContext applicationContext, String actorBeanName) {
        this.applicationContext = applicationContext;
        this.actorBeanName = actorBeanName;
    }
    
    
    @SuppressWarnings("unchecked")
    @Override
    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
    }

    @Override
    public Actor produce() {
        return (Actor) applicationContext.getBean(actorBeanName);
    }

}
