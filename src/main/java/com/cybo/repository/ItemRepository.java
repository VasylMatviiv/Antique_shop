package com.cybo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybo.entity.ItemModel;

@Repository
public interface ItemRepository extends JpaRepository<ItemModel, Integer> {
	
	@Query("SELECT c From ItemModel c Where c.model = :model")
	ItemModel findByModel(@Param("model") String model);

}
