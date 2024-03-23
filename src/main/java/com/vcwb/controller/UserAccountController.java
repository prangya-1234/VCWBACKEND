package com.vcwb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import com.vcwb.bean.UserAccountinfo;
import com.vcwb.entity.UserAccount;
import com.vcwb.exception.UserNotFoundException;
import com.vcwb.repository.UserAccountRepository;
import com.vcwb.service.UserAccountService;
@RestController
@RequestMapping("/api/v1/user")
public class UserAccountController {
	@Autowired
	UserAccountService userAccountService ;
	@Autowired
	UserAccountRepository userAccountRepository;      
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	UserAccount register(@RequestBody UserAccountinfo userAccountinfo) {
		return userAccountService .register(userAccountinfo);		
	}
	 @PutMapping("/edit/{id}")
	 UserAccount  update(@RequestBody UserAccount newUser, @PathVariable Long id) {
	        return userAccountRepository.findById(id)
	                .map(user -> {
	                    user.setFirstName(newUser.getFirstName());
	                    user.setMiddleName(newUser.getMiddleName());
	                    user.setLastName(newUser.getLastName());
	                    user.setDob(newUser.getDob());
	                    user.setMobileNo(newUser.getMobileNo());
	                    user.setEmailId(newUser.getEmailId());
	                    user.setPassword(newUser.getPassword());
	                    return userAccountRepository.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<UserAccount> getAll(){
		
		return userAccountRepository.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    UserAccount getUserById(@PathVariable Long id) {
        return userAccountRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!userAccountRepository.existsById(id)){
            throw new UserNotFoundException(id);
        }
        userAccountRepository .deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

}
