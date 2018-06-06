package com.cybo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cybo.entity.Custom;
import com.cybo.entity.UserEntity;
import com.cybo.service.CustomService;
import com.cybo.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired private UserService userService;
	@Autowired private CustomService customServise;
	
	@GetMapping("/profile")
	@PreAuthorize("hasRole('ROLE_USER')")
	public String showUserPage(Principal priytipal, Model model) {
		UserEntity entity = userService.findUserByEmail(priytipal.getName());
		model.addAttribute("user", entity);
		
		List<Custom> userItemList = customServise.findUserCustoms(false, entity.getId());
		model.addAttribute("userItemListModel", userItemList);
		
		return"user/user_profile";
	}
	
	
	public  String customItem() {
		return"user/user_profile";
	}

}


