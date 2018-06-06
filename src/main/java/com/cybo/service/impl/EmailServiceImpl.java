package com.cybo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cybo.mail.Mail;
import com.cybo.service.EmailService;

	
	@Service
	public class EmailServiceImpl  implements EmailService{

		@Autowired private JavaMailSender mailSender;
		
		@Override
		public void sendMessage(Mail mail) {
			SimpleMailMessage message = new SimpleMailMessage();
			message.setFrom(mail.getFrom());
			message.setTo(mail.getTo());
			message.setSubject(mail.getSubject());
			message.setContent(mail.getContent());
			mailSender.send(message);
			
		}

	}
