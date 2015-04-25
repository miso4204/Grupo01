package com.uniandes.stampidia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uniandes.stampidia.model.StmpCategory;


public interface CategoryRepository extends CrudRepository<StmpCategory,Integer>{

	StmpCategory findOne(Integer id);
	
	List<StmpCategory> findAll();

	@Query(value="select s from StmpCategory s where s.name = :name ",nativeQuery=true) 
	List<Object[]> findSizeByName(@Param("name") String name);
}
