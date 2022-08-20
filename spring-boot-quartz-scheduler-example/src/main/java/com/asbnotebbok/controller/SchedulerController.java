package com.asbnotebbok.controller;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Slf4j
@RestController
public class SchedulerController {

    @Autowired
    private Scheduler scheduler;

    @GetMapping("/schedule-job")
    public String scheduleJob(@RequestParam("msg") String message) throws SchedulerException {

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.put("message", message);

        JobKey jobKey = new JobKey("MessagePrintingJob");

        JobDetail jobDetail = JobBuilder.newJob()
                .withIdentity(UUID.randomUUID().toString())
                .setJobData(jobDataMap)
                .withDescription("Simple message printing Job.")
                .ofType(MyMessagePrinter.class)
                .storeDurably()
                .build();
        Trigger trigger = TriggerBuilder.newTrigger()
                .forJob(jobDetail)
                .startAt(Date.from(Instant.now().plus(30, ChronoUnit.SECONDS)))
                .withDescription("Simple message printing Job trigger.")
                .build();

        log.info("Scheduling printing message Job with message :{}", message);
        scheduler.scheduleJob(jobDetail, trigger);
        return "Job scheduled!!";
    }
}
