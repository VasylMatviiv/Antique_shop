package com.cybo.domain;

import org.hibernate.validator.constraints.NotEmpty;

import com.cybo.entity.ItemMake;
import com.cybo.entity.Type;
import com.cybo.entity.enumeration.BodyType;
import com.cybo.entity.enumeration.Material;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class EditItemRequest {
	
	private int id;
	@NotEmpty private String model;
	@NotEmpty private int price;
	@NotEmpty private String year;
	@NotEmpty private String description;
	@NotEmpty private String color;
	@NotEmpty private String image;
	@NotEmpty private Material material;
	@NotEmpty private ItemMake itemMake;
	@NotEmpty private BodyType bodyType;
	@NotEmpty private Type type;
	

}
