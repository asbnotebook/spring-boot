package com.asbnotebook.example.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;

@Configuration
public class AuthConfig {

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Bean
	public UserDetailsService userDetailsService(DataSource dataSource) {
		String userByUserNameQuery = "SELECT username, password, enabled from USERS where username =?";
		String authoritiesByUserQuery = "SELECT username, authority from AUTHORITIES where username =?";

		var userDetailsManager = new JdbcUserDetailsManager(dataSource);
		userDetailsManager.setUsersByUsernameQuery(userByUserNameQuery);
		userDetailsManager.setAuthoritiesByUsernameQuery(authoritiesByUserQuery);
		return userDetailsManager;
	}
}
