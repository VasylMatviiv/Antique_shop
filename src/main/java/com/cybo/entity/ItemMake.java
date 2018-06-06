package com.cybo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cybo.validator.IfExistItemMaker;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="item_make")
@Getter @Setter 
@NoArgsConstructor
//@NotEmpty 
public class ItemMake extends BaseEntity {
	
	@IfExistItemMaker (message ="This maker already exists")
	private String title;
		
		@OneToMany(mappedBy="itemMake", cascade= {
				CascadeType.DETACH,
				CascadeType.MERGE,
				CascadeType.PERSIST,
				CascadeType.REFRESH})
		List<ItemModel> items = new ArrayList<ItemModel>();

}
