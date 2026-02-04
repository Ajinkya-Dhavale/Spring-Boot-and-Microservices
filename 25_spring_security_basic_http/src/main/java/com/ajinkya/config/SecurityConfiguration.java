package com.ajinkya.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {
	
	@Bean
	public InMemoryUserDetailsManager configure() {
		UserDetails adminUser = User.withDefaultPasswordEncoder()
									.username("ajinkya1")
									.password("123")
									.authorities("ADMIN")
									.build();
		
		UserDetails normalUser = User.withDefaultPasswordEncoder()
									.username("ajinkya2")
									.password("123")
									.authorities("USER")
									.build();

		return new InMemoryUserDetailsManager(adminUser, normalUser);
	}

	@Bean
	public SecurityFilterChain securityFilter(HttpSecurity http) throws Exception{
		
		
		http.authorizeHttpRequests((request) -> request
				.requestMatchers("/","/login","/contact", "/swagger-ui.html").permitAll()
				.anyRequest().authenticated()
		).formLogin();
		
		return http.build();
	}
}