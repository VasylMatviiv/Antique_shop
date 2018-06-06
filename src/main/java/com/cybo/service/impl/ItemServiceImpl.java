package com.cybo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybo.entity.ItemModel;

import com.cybo.repository.ItemRepository;
import com.cybo.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {
	
@Autowired ItemRepository itemRepository;
	
	@Override
	public void saveItem(ItemModel itemModel) {
		itemRepository.save(itemModel);
		
	}

	@Override
	public void updateItem(ItemModel itemModel) {
		itemRepository.save(itemModel);
		
	}

	@Override
	public ItemModel getItemById(int id) {
		
		return itemRepository.findOne(id);
	}

	@Override
	public List<ItemModel> findAllItem() {
		
		return itemRepository.findAll();
	}

	
	

}
