package com.study.practice.akka.server;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.study.practice.akka.config.SpringExtension;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;

/**
 * 
 * <h1>Akka Runner</h1>
 * <p>
 * <b>Note:</b> This class is spring component to use test spring with akka
 * @author dklee
 */
@Component
public class AkkaRunner implements CommandLineRunner{

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private ActorSystem actorSystem;
    
    @Autowired
    private SpringExtension springExtension;
    
    @Override
    public void run(String... args) throws Exception {
        ActorRef workerActor = actorSystem.actorOf(springExtension.props("workerActor"), "worker-actor");
        
        workerActor.tell("start", ActorRef.noSender());
        
//        FiniteDuration duration = FiniteDuration.create(1, TimeUnit.SECONDS);
//        Future<Object> awaitable = Patterns.ask(workerActor, new WorkerActor.Response(), Timeout.durationToTimeout(duration));
//        
//        try{
//            logger.info("Response : " + Await.result(awaitable, duration));
//        }finally{
//            actorSystem.terminate();
//            Await.result(actorSystem.whenTerminated(), Duration.Inf());
//        }
        
    }

}
