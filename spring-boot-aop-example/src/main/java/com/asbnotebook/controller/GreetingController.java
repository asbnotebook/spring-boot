package com.asbnotebook.controller;

import com.asbnotebook.aspect.LogIt;
import com.asbnotebook.service.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    private GreetingService greetingService;

    @LogIt
    @GetMapping("/")
    public String getGreeting(@RequestParam("name") String name){
        return greetingService.getGreeting(name);
    }
}
