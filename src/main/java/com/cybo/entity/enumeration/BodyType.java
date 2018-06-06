package com.cybo.entity.enumeration;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter @AllArgsConstructor
public enum BodyType {
	
	CUBE("CUBE"), ROUND("ROUND"), OVAL("OVAL"), LINER("LINER"),
	BIG("BIG"), SMALL("SMALL"), PERPENDICULAR("PERPENDICULAR"), PARALELLEPIPED("PARALELLEPIPED");
	private String title;

}
