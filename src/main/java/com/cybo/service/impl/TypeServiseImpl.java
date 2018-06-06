package com.cybo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybo.entity.Type;
import com.cybo.repository.TypeRepository;
import com.cybo.service.TypeService;

@Service
public class TypeServiseImpl implements TypeService {

	@Autowired TypeRepository typeRepository;
	@Override
	public void saveType(Type type) {
		typeRepository.save(type);
		
	}

	@Override
	public List<Type> findAllType() {
		// TODO Auto-generated method stub
		return typeRepository.findAll();
	}
}
