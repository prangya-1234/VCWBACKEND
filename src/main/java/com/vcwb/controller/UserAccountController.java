package com.vcwb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;

import com.vcwb.bean.UserAccountinfo;
import com.vcwb.repository.UserAccountRepository;
import com.vcwb.service.UserAccountService;

public class UserAccountController {
	@Autowired
	UserAccountService userAccountService ;
	@Autowired
	UserAccountRepository userAccountRepository;      
	
	
	@RequestMapping(value="/register" , method=RequestMethod.POST) 
	UserAccount register(@RequestBody UserAccountinfo userAccountinfo) {
		return .register(UserAccountinfo);		
	}
	 @PutMapping("/edit/{id}")
	 UserAccount  update(@RequestBody UserAccount newUser, @PathVariable Long id) {
	        return passengerRegRepo.findById(id)
	                .map(user -> {
	                    user.setUserName(newUser.getUserName());
	                    user.setAge(newUser.getAge());
	                    user.setDob(newUser.getDob());
	                    user.setPhoneNo(newUser.getPhoneNo());
	                    user.setNationality(newUser.getNationality());
	                    user.setEmailId(newUser.getEmailId());
	                    user.setGender(newUser.getGender());
	                    user.setPassportNo(newUser.getPassportNo());
	                    user.setVaccineId(newUser.getVaccineId());
	                    user.setAddress(newUser.getAddress());
	                    return passengerRegRepo.save(user);
	                }).orElseThrow(() -> new UserNotFoundException(id));
	    }
	@GetMapping("/getAll")
	
	public List<PassengerRegistration> getAll(){
		
		return passengerRegRepo.findAll();
	}
	 
    @GetMapping("/getAll/{id}")
    PassengerRegistration getUserById(@PathVariable Long id) {
        return passengerRegRepo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
    }

    @DeleteMapping("/delete/{id}")
    String deleteUser(@PathVariable Long id){
        if(!passengerRegRepo.existsById(id)){
            throw new UserNotFoundException(id);
        }
        passengerRegRepo.deleteById(id);
        return  "User with id "+id+" has been deleted success.";
    }

}
