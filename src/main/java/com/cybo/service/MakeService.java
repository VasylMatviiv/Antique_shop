package com.cybo.service;

import java.util.List;

import com.cybo.entity.ItemMake;

public interface MakeService {
	
void saveMaker(ItemMake make);
	
	ItemMake findMakeByName(String name);
	
	List<ItemMake> findAllItemMake();

}
