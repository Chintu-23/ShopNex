package com.spring.ecommerce.dao;

import org.springframework.stereotype.Repository;

import com.spring.ecommerce.entity.User;
import com.spring.ecommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserDao {

	private final UserRepository userRepository;

	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow();
	}

	public void save(User user) {
		userRepository.save(user);
	}
}
