package com.cybo.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.cybo.entity.enumeration.BodyType;
import com.cybo.entity.enumeration.Material;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="item_model")
@Getter @Setter 
@NoArgsConstructor
public class ItemModel extends BaseEntity {
	
	private String model;
	private int price;
	private String year;
	private String descriptions;
	private String color;
	private String image;

	
	@ManyToOne(cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name="type_id")
	private Type type;
	
	@ManyToOne(cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	@JoinColumn(name="make_id")
	private ItemMake itemMake;
	
	@Enumerated(EnumType.STRING)
	private BodyType bodyType;
	@Enumerated(EnumType.STRING)
	private Material material;

	@OneToMany(mappedBy="model", cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	private List<Custom> custom;

	@Override
	public String toString() {
		return "ItemModel [model=" + model + ", price=" + price + ",  year="+ year +", descriptions=" + descriptions + ", color=" + color + ", image=" + image + ", type=" + type + ", itemMake=" + itemMake + ", bodyType=" + bodyType + ", custom=" + custom + ", material=" + material +"]";
	}

}
