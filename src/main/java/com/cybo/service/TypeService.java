package com.cybo.service;

import java.util.List;

import com.cybo.entity.Type;

public interface TypeService {

	void saveType(Type type);
	
	List<Type> findAllType();

}
