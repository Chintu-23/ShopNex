package com.spring.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.ecommerce.entity.Merchant;

public interface MerchantRepository extends JpaRepository<Merchant, Long> {

}
