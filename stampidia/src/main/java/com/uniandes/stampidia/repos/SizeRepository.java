package com.uniandes.stampidia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.uniandes.stampidia.model.StmpSize;

public interface SizeRepository extends CrudRepository<StmpSize,Integer>{

	StmpSize findOne(Integer id);
	
	List<StmpSize> findAll();

	@Query(value="select s from StmpSize s where s.name = :name ")
	List<Object[]> findSizeByName(@Param("name") String name);
}
