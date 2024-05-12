package com.example.quartz.scheduler;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.TriggerBuilder;
import org.quartz.Trigger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.example.quartz.job.GreetingsJob;

@Component
public class GreetingsJobScheduler {
    @Autowired
    private Scheduler scheduler;

    @Value(value = "${job.greetingsJobs.cronExpression}")
    private String cronExpression;

    public void scheduleJob() throws SchedulerException {
        JobDetail job = JobBuilder.newJob(GreetingsJob.class)
            .withIdentity("greetingsJob", "greetingsGroup")
            .build();

        Trigger trigger = TriggerBuilder.newTrigger()
            .withIdentity("greetingsJobTrigger", "greetingsGroup")
            .withSchedule(CronScheduleBuilder.cronSchedule(cronExpression))
            .startNow()
            .build();

        scheduler.scheduleJob(job, trigger);
    }    
}
