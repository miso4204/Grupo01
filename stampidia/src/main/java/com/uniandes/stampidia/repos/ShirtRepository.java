package com.uniandes.stampidia.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import com.uniandes.stampidia.model.StmpShirt;

public interface ShirtRepository extends CrudRepository<StmpShirt,Integer>{

	StmpShirt findOne(Integer id);
	
	List<StmpShirt> findAll();

	@Query(value="select s from StmpShirt s where s.name = :name ",nativeQuery=true) 
	List<Object[]> findColorByName(@Param("name") String name);
	
    @Query(value="select s from StmpShirt s where s.idStamp.idCategory.id = :categoryId")
    List<StmpShirt> findShirtByCategory(@Param("categoryId") Integer categoryId);
    
    //findShirtByStampByCategory(stampId,categoryId)
    @Query(value="select s from StmpShirt s where s.idStamp.id = :stampId")
    List<StmpShirt> findShirtByStamp(@Param("stampId") Integer stampId);
    
    @Query(value="select s from StmpShirt s where s.idStamp.id = :stampId and s.idStamp.idCategory.id = :categoryId")
    List<StmpShirt> findShirtByStampByCategory(@Param("stampId") Integer stampId, @Param("categoryId") Integer categoryId);
}
