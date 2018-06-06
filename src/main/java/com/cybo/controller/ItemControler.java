package com.cybo.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cybo.entity.Custom;
import com.cybo.entity.ItemModel;
import com.cybo.entity.UserEntity;
import com.cybo.service.CustomService;
import com.cybo.service.ItemService;
import com.cybo.service.UserService;

@Controller
@RequestMapping("/items")
public class ItemControler {
	
	@Autowired private ItemService itemService;
	@Autowired private  UserService userServise;
	@Autowired private CustomService customServise;
	
	@GetMapping("/itemlist")
	private String showItemListAdmin(Model model, Principal principal ) {
		
		UserEntity userEntity = userServise.findUserByEmail(principal.getName());
		List<ItemModel> itemModelList = itemService.findAllItem();
		model.addAttribute("UserEntytiModel", userEntity);
		model.addAttribute("itemList", itemModelList);		
		return"item_list";
	}
	@GetMapping("/user/{userid}/info/{itemid}")
	public String showInfoByItem(@PathVariable("itemid") int itemId, @PathVariable("userid") int userId,  Model model, Principal principal) {
		ItemModel itemModel = itemService.getItemById(itemId);
		UserEntity userEntity = userServise.findUserById(userId);
		
		if(itemId!=itemModel.getId()){
			return"redirect:/cars/carlist";
		}
		model.addAttribute("userModel", userEntity);
		model.addAttribute("itemModelInfo", itemModel);
		return "car-info";
	}

	@PostMapping("/user/{userid}/info/{itemid}")
	public String addCustom(@PathVariable("userid") int uderId,@PathVariable("itemid") int itemId ) {
		UserEntity userEntity = userServise.findUserById(uderId);
		ItemModel itemModel = itemService.getItemById(itemId);
		Custom custom = new Custom();
		custom.setModel(itemModel);
		custom.setUser(userEntity);
		custom.setStatus(false);
		customServise.saveCustom(custom);
		
		return"redirect:/user/profile";
	}
	@GetMapping("/user/{userid}/buy/{itemid}")
	public String buyItem(@PathVariable("userid") int userId, @PathVariable("itemid") int itemId, Principal principal, Model model ) {
		
		 
		UserEntity userEntity = userServise.findUserByEmail(principal.getName());
		model.addAttribute("userModel", userEntity);
		ItemModel itemModel = itemService.getItemById(itemId);
		Custom custom  = new Custom();
		custom.setModel(itemModel);
		custom.setUser(userEntity);
		custom.setStatus(false);
		customServise.saveCustom(custom);
		return "redirect/user/profile";
	}
	
	

}
