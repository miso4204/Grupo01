package com.uniandes.stampidia.repos;

import java.util.List;
import org.springframework.data.repository.CrudRepository;
import com.uniandes.stampidia.model.StmpShirtStyle;


public interface ShirtStyleRepository extends CrudRepository<StmpShirtStyle,Integer>{

	StmpShirtStyle findOne(Integer id);
	
	List<StmpShirtStyle> findAll();

}
