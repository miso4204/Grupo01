package com.uniandes.stampidia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uniandes.stampidia.model.StmpCategory;
import com.uniandes.stampidia.model.StmpColor;


public interface ColorRepository extends CrudRepository<StmpColor,Integer>{

	StmpColor findOne(Integer id);
	
	List<StmpColor> findAll();

	@Query(value="select s from StmpColor s where s.name = :name ",nativeQuery=true) 
	List<Object[]> findColorByName(@Param("name") String name);
}
