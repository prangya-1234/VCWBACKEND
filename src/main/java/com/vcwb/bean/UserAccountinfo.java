package com.vcwb.bean;

import com.vcwb.entity.UserAccount;

import lombok.Data;
@Data
public class UserAccountinfo {
	private String id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String dob;
	private String mobileNo;
	private String emailId;
	private String password;
	
	
	public UserAccount convertToEntity() {
		
		UserAccount user = new UserAccount();
			if(id!=null  && id!="0")			
		    user.setId(Long.valueOf(id));
			user.setFirstName(firstName);
			user.setMiddleName(middleName);
			user.setLastName(lastName);
			user.setDob(dob);
			user.setMobileNo(mobileNo);
			user.setEmailId(emailId);
			user.setPassword(password);
			
			return user;
			
			
	}
}
