package com.uniandes.stampidia.services;

import com.uniandes.stampidia.model.StmpOrder;
import com.uniandes.stampidia.model.StmpShirt;
import com.uniandes.stampidia.repos.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SEBASTIAN on 02/04/2015.
 */
@Service
@Transactional
public class CartService {

    @Autowired
    private OrderRepository orderRepository;

    public void addItemToCart(StmpShirt shirt, StmpOrder order){

        if(order != null && shirt != null){

        }
    }
}
