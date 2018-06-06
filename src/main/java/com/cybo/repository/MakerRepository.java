package com.cybo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybo.entity.ItemMake;

@Repository
public interface MakerRepository extends JpaRepository<ItemMake, Integer> {
	
	@Query("Select m from ItemMake m Where m.title = :title")
	ItemMake findMakerByName(@Param("title") String title);

}
