package com.asbnotebook.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GreetingService {
    public String getGreeting(String name){
        log.info("Returning greeting message from service..");
        return "Hello " + name;
    }
}
