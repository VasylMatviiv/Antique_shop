package com.cybo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cybo.entity.Type;

@Repository
public interface TypeRepository extends JpaRepository<Type, Integer> {
	
	@Query("Select e from Type e where title = :title")
	Type findTypeByTitle( @Param("title")String title);

}
