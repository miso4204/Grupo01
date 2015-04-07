package com.uniandes.stampidia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import com.uniandes.stampidia.model.StmpStamp;

public interface StampRepository extends CrudRepository<StmpStamp,Integer>{

	StmpStamp findOne(Integer id);
	
	List<StmpStamp> findAll();
	
	@Query(value="select s from StmpStamp s where s.name = :name ",nativeQuery=true) 
	List<Object[]> findStampByName(@Param("name") String name);
	
    @Query(value="select s from StmpStamp s where s.idCategory.id = :categoryId")
    List<StmpStamp> findStampsByCategory(@Param("categoryId") Integer categoryId);
    //
}
