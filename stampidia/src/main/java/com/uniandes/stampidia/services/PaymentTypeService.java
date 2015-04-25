package com.uniandes.stampidia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniandes.stampidia.model.StmpPaymentType;
import com.uniandes.stampidia.repos.PaymentTypeRepository;

@Service
@Transactional
public class PaymentTypeService {
	
	@Autowired
	private PaymentTypeRepository paymentTypeRepository;
	
	public List<StmpPaymentType> getAllPaymentTypes(){
		
		return paymentTypeRepository.findAll();
	}
	

}
