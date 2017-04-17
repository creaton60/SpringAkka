package com.study.practice.akka.config;

import org.springframework.context.ApplicationContext;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;

/**
 * 
 * <h1>SpringActorProducer</h1>
 * <p>
 * <b>Note:</b> IndirectActorProducer is defines a class of actor creation strategies 
 * deviating from the usual default of just reflectively instantiating the Actor subclass. 
 * It can be used to allow a dependency injection framework to determine the actual actor class 
 * and how it shall be instantiated.
 * 
 * This class is used by Spring to import actors.
 * 
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
