package com.cybo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybo.entity.ItemMake;
import com.cybo.repository.ItemMakerRepository;
import com.cybo.service.ItemMakerService;

@Service
public class ItemModelServiceImpl implements ItemMakerService {
	
	@Autowired
	 ItemMakerRepository makerRepository;

		@Override
		public List<ItemMake> findAll() {
			
			return makerRepository.findAll();
		
	
		}

}
