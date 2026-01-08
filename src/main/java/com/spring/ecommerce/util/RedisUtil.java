package com.spring.ecommerce.util;

import java.time.Duration;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import com.spring.ecommerce.dto.MerchantDto;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RedisUtil {

	private final RedisTemplate<String, Object> redisTemplate;

	public void saveOtp(Integer otp, String email) {
		redisTemplate.opsForValue().set(email+"_otp", otp,Duration.ofMinutes(5));
	}

	public void saveTempData(MerchantDto merchantDto, String email) {
		redisTemplate.opsForValue().set(email+"_merchant", merchantDto,Duration.ofMinutes(30));
	}

}
