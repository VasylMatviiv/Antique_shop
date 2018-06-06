package com.cybo.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter 
@AllArgsConstructor
public enum Material {
	
	PORCELAIN("PORCELAIN"),
	GLASS("GLASS"),
	METAL("METAL"),
	ELECTRO("ELECTRO"),
	WOOD("WOOD"),
	CLAY("CLAY");
	
	private String type;

}
