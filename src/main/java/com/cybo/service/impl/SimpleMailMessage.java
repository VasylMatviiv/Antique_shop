package com.cybo.service.impl;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class SimpleMailMessage {
	
	private String from;
	private String to;
	private String subject;
	private String content;
	
}
