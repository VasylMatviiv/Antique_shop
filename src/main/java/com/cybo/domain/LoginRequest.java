package com.cybo.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class LoginRequest {
	
	private String mail;
	private String password;

}
