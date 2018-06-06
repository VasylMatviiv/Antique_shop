package com.cybo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cybo.domain.RegisterRequest;
import com.cybo.entity.UserEntity;
import com.cybo.mail.Mail;
import com.cybo.mapper.UserMapper;
import com.cybo.service.EmailService;
import com.cybo.service.UserService;
import com.cybo.service.impl.RandomToken;



@Controller
public class BaseController  {
	
	@Autowired private UserService userService;
	@Autowired private EmailService emailService;
	
	@GetMapping({"/", "/home"})
	public String shoHome() {
		return "home";
	}
	
	@GetMapping("/login")
	public String showLogin() {
		
		return "login";
	}
	@GetMapping("/register")
	public String showRegister(Model model) {
		model.addAttribute("userModel", new RegisterRequest());
		return"register";
	}
	@PostMapping("/register")
	public String saveUser(@ModelAttribute("userModel") RegisterRequest request) {
		
		UserEntity user = UserMapper.registerToUser(request);
		String token = RandomToken.gemerateRandom();
		user.setToken(token);
		user.setActivated(false);
		userService.saveUser(user);
		Mail mail = new Mail();
		mail.setTo(request.getEmail());
		mail.setSubject("You are seccsesfully registered");
		mail.setContent("Please verify your email adress by follow thes link: " 
				+ "http://localhost:8070/verify?token=" + token + "&userid=" + user.getId()
				);
		
		emailService.sendMessage(mail);
		return"redirect:/stop/to/verifi";
	}
	@GetMapping("/verify")
	public String verify(@RequestParam("token") String token, @RequestParam("userid") String UserIdStr ) {
		int userIdInt = Integer.valueOf(UserIdStr);
		UserEntity user = userService.findUserById(userIdInt);
		if(user.getToken().equals(token)) {
			user.setToken("");
			user.setActivated(true);
			userService.updateUser(user);
		}
		return"login";
	}
	@GetMapping("/stop/to/verifi")
	public String showStopPage() {
		return"stop";
	}
		
	@GetMapping("/info")
	public String showInfo() {
		return"info";
	}

}
