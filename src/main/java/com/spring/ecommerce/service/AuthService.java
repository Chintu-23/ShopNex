package com.spring.ecommerce.service;

import java.util.Map;

import com.spring.ecommerce.dto.LoginDto;

public interface AuthService {

	Map<String, Object> login(LoginDto loginDto);

}
