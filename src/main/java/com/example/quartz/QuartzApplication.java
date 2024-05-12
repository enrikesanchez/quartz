package com.example.quartz;

import org.quartz.SchedulerException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.quartz.scheduler.GreetingsJobScheduler;

@SpringBootApplication
public class QuartzApplication {
	static Logger logger = LoggerFactory.getLogger(QuartzApplication.class); 

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(QuartzApplication.class, args);
    	GreetingsJobScheduler greetingsJobScheduler = context.getBean(GreetingsJobScheduler.class);

        try {
			greetingsJobScheduler.scheduleJob();
			logger.info("GreetingsJob scheduled successfully");
		} catch (SchedulerException se) {
			logger.error("GreetingsJob was not scheduled", se);
		}
	}
}
