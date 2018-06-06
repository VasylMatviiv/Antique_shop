package com.cybo.domain;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.cybo.entity.ItemMake;
import com.cybo.entity.Type;
import com.cybo.entity.enumeration.BodyType;
import com.cybo.entity.enumeration.Material;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter @Setter
public class CreateItemRequest  {
	
	@NotEmpty private String model;
	@NotEmpty private int price;
	@NotEmpty private String year;
	@NotEmpty private String descriptions;
	@NotEmpty private String color;
	@NotEmpty private Type type;
	@NotEmpty private ItemMake itemMake;
	@NotEmpty private BodyType bodyType;
	@NotEmpty private Material material;
	@NotEmpty private MultipartFile itemImage;
	@Override
	public String toString() {
		return "CreateItemRequest [model="+ model +", price=" + price + ", year=" + year +   
				", descriptions=" + descriptions + ", color=" + color + ", type=" + type + ", itemMake=" + itemMake + 
				" , bodyType=" + bodyType + ", itemImage=" + itemImage.getOriginalFilename() + "]";
		
	}

}
