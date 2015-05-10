package com.uniandes.stampidia.services;

import com.uniandes.stampidia.model.StmpOrderDetail;
import com.uniandes.stampidia.repos.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SEBASTIAN on 09/05/2015.
 */
@Service
@Transactional
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    public List<StmpOrderDetail> saveItems(List<StmpOrderDetail> items){

        return null;
    }
}
