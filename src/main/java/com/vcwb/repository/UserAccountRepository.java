package com.vcwb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vcwb.entity.UserAccount;

public class UserAccountRepository {
	public interface UserRepository extends JpaRepository<UserAccount, Long>{
		UserAccount findByEmail(String email);
	 
	}
}
