package com.spring.ecommerce.util;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.spring.ecommerce.entity.User;
import com.spring.ecommerce.enums.UserRole;
import com.spring.ecommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j //used for log(works like printing statement)
@RequiredArgsConstructor //for constructor
public class AdminAccountCreator implements CommandLineRunner { // using commandLine server 
	                                                            //automatically runs as admin

	private final UserRepository userRepository;
	private final PasswordEncoder passwordEncoder; //converts password into unique code or words(secure)
	
	@Value("${admin.email}") //value injection(application properties)
	private String adminEmail;
	@Value("${admin.password}")
	private String adminPassword;
	@Value("${admin.mobile}")
	private Long adminMobile;
	@Value("${admin.username}")
	private String adminUserName;
	
	@Override
	public void run(String... args) throws Exception { //it will be automatically called
		log.info(adminEmail);
		log.info("Admin Account Creation Started");
		System.out.println(passwordEncoder.matches(adminPassword, "$2a$10$qNN1neYfBJ4KPHsr1dJK3.qUo0/M.9NTjq7IhQjAsL.W1Y9dlLe1."));
		if(userRepository.existsByEmail(adminEmail)){
			log.info("Admin Account Already Exists");
		}else {
			User user=new User(null,adminUserName,adminEmail,adminMobile,passwordEncoder.encode(adminPassword),UserRole.ADMIN,true);
			userRepository.save(user);
			log.info("Admin Account Creation Success- "+adminUserName);
		}
		
	}

}
