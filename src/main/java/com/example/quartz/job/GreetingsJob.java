package com.example.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.quartz.service.GreetingsService;

public class GreetingsJob implements Job {
    Logger logger = LoggerFactory.getLogger(GreetingsJob.class);

    @Autowired
    GreetingsService greetingsService;

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        logger.info("Executing Greetings Job");
        greetingsService.greetings();
    }

}
