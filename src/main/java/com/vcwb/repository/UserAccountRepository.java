package com.vcwb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.vcwb.entity.UserAccount;
@EnableJpaRepositories
	public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
		UserAccount findByUserName(String name);
	 
	}

