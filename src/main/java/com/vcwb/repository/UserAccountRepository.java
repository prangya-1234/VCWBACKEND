package com.vcwb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcwb.entity.UserAccount;

	public interface UserAccountRepository extends JpaRepository<UserAccount, Long>{
		UserAccount findByEmail(String email);
	 
	}

