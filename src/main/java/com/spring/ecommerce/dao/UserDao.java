package com.spring.ecommerce.dao;

import org.springframework.stereotype.Repository;

import com.spring.ecommerce.entity.Merchant;
import com.spring.ecommerce.entity.User;
import com.spring.ecommerce.repository.MerchantRepository;
import com.spring.ecommerce.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class UserDao {

	private final UserRepository userRepository;
	private final MerchantRepository merchantRepository;

	public boolean checkEmailAndMobieDuplicate(String email, Long mobile) {
		return userRepository.existsByEmailOrMobile(email, mobile);
	}
	
	public User findByEmail(String email) {
		return userRepository.findByEmail(email).orElseThrow();
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public void save(Merchant merchant) {
		merchantRepository.save(merchant);
		
	}
}
