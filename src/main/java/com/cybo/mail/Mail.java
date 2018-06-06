package com.cybo.mail;

import lombok.Getter;
import lombok.Setter;

@Getter  @Setter
public class Mail {
	public Mail() {
		this.from="nik.m.gpg@gmail.com";
	}
	private String from;
	private String to;
	private String subject;
	private String content;

}
