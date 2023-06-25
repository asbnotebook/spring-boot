package com.asbnotebook.resource;

import jakarta.annotation.security.RolesAllowed;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestResource {

    @GetMapping("/common")
    public String getEveryoneText() {
        return "Both ADMIN and USER can access this!!";
    }

    @GetMapping("/user")
    @RolesAllowed("USER")
    public String getUserText() {
        return "hello USER";
    }

    @GetMapping("/admin")
    @RolesAllowed("ADMIN")
    public String getAdminText() {
        return "hello ADMIN";
    }
}
