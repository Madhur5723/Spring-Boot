package com.demo.UserService.JWT;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import lombok.AllArgsConstructor;

@Configuration
@AllArgsConstructor
public class SecurityFilterConfig {	
	private JwtAuthenticationEntryPoint point;
	private JWTAuthenticationFilter filter;

	/*
	 * It configures Cross-Site Request Forgery (CSRF) protection. In this case CSRF
	 * protection is disabled (csrf.disable()). 
	 * It configures Cross-Origin Resource
	 * Sharing (CORS) support. Here, CORS is disabled (cors.disable()). this code
	 * sets up a security configuration for a Spring application. It disables CSRF
	 * and CORS protection
	 */
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity security) throws Exception {
		return security.csrf(csrf -> csrf.disable()).cors(cors -> cors.disable())
				.authorizeHttpRequests(
						auth -> auth.requestMatchers("/authenticate").permitAll().anyRequest().authenticated())
				.exceptionHandling(ex -> ex.authenticationEntryPoint(point))
				.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class).build();
	}
}