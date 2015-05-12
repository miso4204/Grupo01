package com.uniandes.stampidia.services;

import com.uniandes.stampidia.model.StmpOrderDetail;
import com.uniandes.stampidia.repos.OrderDetailRepository;
import com.uniandes.stampidia.repos.OrderRepository;
import com.uniandes.stampidia.repos.ShirtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SEBASTIAN on 09/05/2015.
 */
@Service
@Transactional
public class OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ShirtRepository shirtRepository;

    public List<StmpOrderDetail> saveItems(List<StmpOrderDetail> items){
        if(items != null && !items.isEmpty()) {
            List<StmpOrderDetail> persistedItems = new ArrayList<StmpOrderDetail>();
            try {
                for(StmpOrderDetail detail : items){
                    detail.setIdShirt(shirtRepository.findOne(detail.getIdShirt().getId()));
                    detail.setIdOrder(orderRepository.findOne(detail.getIdOrder().getId()));
                    persistedItems.add(orderDetailRepository.save(detail));
                }
                return persistedItems;
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
