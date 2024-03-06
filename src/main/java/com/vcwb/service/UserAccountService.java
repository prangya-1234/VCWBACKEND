package com.vcwb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vcwb.bean.UserAccountinfo;
import com.vcwb.entity.UserAccount;
import com.vcwb.repository.*;
@Service
public class UserAccountService { 
	  
		@Autowired
		UserAccountRepository userAccountRepository;
		
		public UserAccount register(UserAccountinfo userAccountinfo) {
			return userAccountRepository.save(userAccountinfo.convertToEntity());
		}
		
		public UserAccount update(UserAccount UserAccount) {
			return userAccountRepository.save(UserAccount);
		}
		
		public List<UserAccount> getAll() {
			return userAccountRepository.findAll();
		}
		
		public Optional<UserAccount> getById(Long id) {
			return userAccountRepository.findById(id);
		}
		
		public void delete(Long id) {
			userAccountRepository.deleteById(id);
		}
		
}
