package com.asbnotebook.example.config;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.asbnotebook.example.User;
import com.asbnotebook.example.service.InMemoryUserDetailsService;

@Configuration
public class AuthConfig {
	
	@Bean
	public UserDetailsService userDetailsService() {
		UserDetails u = new User("arun", "12345", "READ");
		List<UserDetails> users = List.of(u);
		return new InMemoryUserDetailsService(users);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
