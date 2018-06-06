package com.cybo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="type")
@Getter @Setter @NoArgsConstructor 
public class Type extends BaseEntity {
	
	@NotNull(message="cant be null") 
	private String title;
	@NotNull(message="cant be null") 
	private String power;
	@NotNull(message="cant be null") 
	private String capacity;

	
	@OneToMany(mappedBy="type", cascade= {
			CascadeType.DETACH,
			CascadeType.MERGE,
			CascadeType.PERSIST,
			CascadeType.REFRESH})
	List<ItemModel> models = new ArrayList<>();

}
