package com.study.practice.akka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class BusinessServiceImpl implements BusinessService{

    private final Logger logger = LoggerFactory.getLogger(this.getClass()); 
    
    @Override
    public void perform(Object obj) {
        if(obj instanceof String){
            logger.info("Perform {}", (String)obj);
        }
    }

}
