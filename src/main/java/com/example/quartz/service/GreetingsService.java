package com.example.quartz.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.example.quartz.job.GreetingsJob;

@Service
public class GreetingsService {
    Logger logger = LoggerFactory.getLogger(GreetingsJob.class); 

    public void greetings() {
        logger.info("Hello World!");
    }
}
