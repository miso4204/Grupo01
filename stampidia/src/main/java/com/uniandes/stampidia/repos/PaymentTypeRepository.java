package com.uniandes.stampidia.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.uniandes.stampidia.model.StmpPaymentType;

public interface PaymentTypeRepository extends CrudRepository<StmpPaymentType,Integer>{

	StmpPaymentType findOne(Integer id);
	
	List<StmpPaymentType> findAll();

}
