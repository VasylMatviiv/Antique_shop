package com.cybo.mapper;

import javax.persistence.MappedSuperclass;


import com.cybo.domain.CreateItemRequest;
import com.cybo.domain.EditItemRequest;
import com.cybo.entity.ItemModel;

@MappedSuperclass
public interface ItemModelMapper {
	
public static ItemModel addRequestToItemModel(CreateItemRequest request) {
		
		ItemModel item = new ItemModel();
		item.setModel(request.getModel());
		item.setPrice(request.getPrice());
		item.setYear(request.getYear());
		item.setDescriptions(request.getDescriptions());
		item.setColor(request.getColor());
		item.setType(request.getType());
		item.setBodyType(request.getBodyType());
		item.setItemMake(request.getItemMake());
		item.setMaterial(request.getMaterial());
		//item.setImage(request.getItemImage().getOriginalFilename());
		return item;
	}
	
	public  static CreateItemRequest entityToItemCreateRequest(ItemModel itemModel) {
		
		CreateItemRequest request = new CreateItemRequest();
		
		request.setModel(itemModel.getModel());
		request.setPrice(itemModel.getPrice());
		request.setYear(itemModel.getYear());
		request.setDescriptions(request.getDescriptions());
		request.setColor(itemModel.getColor());
		request.setType(itemModel.getType());
		request.setBodyType(itemModel.getBodyType());
		request.setItemMake(itemModel.getItemMake());
		request.setMaterial(itemModel.getMaterial());
		//request.setItemImage(itemModel.getImage());
		//request.setImage(carModel.getImage());
		return request;
		
		
	}
	
	
	 public static ItemModel editItemToEntity(EditItemRequest request) {
		 ItemModel model = new ItemModel();
		model.setId(request.getId());
		model.setModel(request.getModel());
		model.setYear(request.getYear());
		model.setDescriptions(request.getDescription());
		model.setPrice(request.getPrice());
		model.setColor(request.getColor());
		model.setType(request.getType());
		model.setBodyType(request.getBodyType());
		model.setItemMake(request.getItemMake());
		//model.setId(request.getId());
		return model;
	}
	 public static EditItemRequest itemToRequest(ItemModel model) {
		 
		 EditItemRequest request = new EditItemRequest();
		 request.setId(model.getId());
		 request.setModel(model.getModel());;
		 request.setYear(request.getYear());
		 request.setDescription(model.getDescriptions());
		 request.setPrice(model.getPrice());
		 request.setColor(model.getColor());
		 request.setType(model.getType());
		 request.setBodyType(model.getBodyType());
		 request.setItemMake(model.getItemMake());
		 
		 return request;
	 }

}
