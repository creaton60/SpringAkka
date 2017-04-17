package com.study.practice.akka.server;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.study.practice.akka.service.BusinessService;

import akka.actor.AbstractActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

@Component
@Scope("prototype")
public class WorkerActor extends AbstractActor{

    private final LoggingAdapter log = Logging.getLogger(getContext().getSystem(), this);
    
    @Autowired
    private BusinessService businessService;
    
    @Override
    public Receive createReceive() {
        return receiveBuilder()
                .match(String.class, s ->{
                    log.info("Received String message : {}", s);
                    
                    businessService.perform(s);
                })
                .matchAny(o -> log.info("received unknown message"))
                .build();
    }
}
