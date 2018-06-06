package com.cybo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybo.entity.ItemMake;
import com.cybo.repository.MakerRepository;
import com.cybo.service.MakeService;

@Service
public class MakeServiceImpl implements MakeService {
	
	@Autowired
	private MakerRepository  makerRepository;
	
	@Override
	public void saveMaker(ItemMake make) {
		makerRepository.save(make);
		
	}
	@Override
	public ItemMake findMakeByName(String name) {
		// TODO Auto-generated method stub
		return makerRepository.findMakerByName(name);
	}
	@Override
	public List<ItemMake> findAllItemMake() {
		
		return makerRepository.findAll();
	}
	

}
