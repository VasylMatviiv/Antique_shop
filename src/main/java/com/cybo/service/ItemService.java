package com.cybo.service;

import java.util.List;

import com.cybo.entity.ItemModel;

public interface ItemService {
void saveItem(ItemModel itemModel);
	
	void updateItem(ItemModel itemModel);
	
	 ItemModel getItemById(int id);
		
		
	
	
	List<ItemModel> findAllItem();

}
