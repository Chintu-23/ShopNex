package com.spring.ecommerce.config;

import com.spring.ecommerce.security.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtFilter jwtFilter;

    SecurityConfig(JwtFilter jwtFilter) {
        this.jwtFilter = jwtFilter;
    }

	@Bean
	PasswordEncoder encoder() {
		return new BCryptPasswordEncoder(); //standard version to encode 
	}
	
	@Bean
	SecurityFilterChain chain(HttpSecurity httpSecurity) {
		return httpSecurity.httpBasic(Customizer.withDefaults())
				.authorizeHttpRequests(x->x.requestMatchers("/auth/**").permitAll().anyRequest().authenticated())
				.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class)
				.sessionManagement(x->x.sessionCreationPolicy(SessionCreationPolicy.STATELESS)).build();
		
	}
}
