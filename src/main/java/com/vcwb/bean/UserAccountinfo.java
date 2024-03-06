package com.vcwb.bean;

import com.vcwb.entity.UserAccount;

import lombok.Data;
@Data
public class UserAccountinfo {
	private String id;
	private String userName;
	private String emailId;
	private String password;
	
	
	public UserAccount convertToEntity() {
		
		UserAccount user = new UserAccount();
			if(id!=null  && id!="0")			
		    user.setId(Long.valueOf(id));
			user.setUserName(userName);
			user.setEmailId(emailId);
			user.setPassword(password);
			
			return user;
			
			
	}
}
