package com.vcwb.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@Entity
@Getter
@NoArgsConstructor
@ToString
@AllArgsConstructor
@Table(name =  "user", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class UserAccount {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "username")
	private String userName;
	
	
	private String emailId;
	
	private String password;

	
		
		
	}
	


