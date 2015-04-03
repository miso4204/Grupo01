package com.uniandes.stampidia.services;

import com.uniandes.stampidia.model.StmpOrder;
import com.uniandes.stampidia.model.StmpOrderDetail;
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

    public StmpOrder updateOrder(StmpOrder order){
        StmpOrder answer = null;
        if(order != null){
            answer = orderRepository.save(order);
        }
        // TODO :: implementar cuando order es null
        return answer;
    }

    public void addItemToCart(StmpShirt shirt, StmpOrder order){
        if(order != null && shirt != null &&
                order.getId() != null && shirt.getId() != null){

            boolean contained = false;

            if(order.getStmpOrderDetailList() != null && !order.getStmpOrderDetailList().isEmpty()){
                for(StmpOrderDetail detail : order.getStmpOrderDetailList()){
                    if(detail.getIdShirt().equals(shirt.getId())){
                        contained = true;
                        detail.setQuantity(detail.getQuantity() + 1);
                        break;
                    }
                }
            }
            // Si la Orden no contiene la camiseta
            if(!contained){
                StmpOrderDetail newDetail = new StmpOrderDetail();
                newDetail.setQuantity(1);
                // TODO :: harold :: que valor deberia asignar aca?
//                newDetail.setUnitValue(shirt.get);
                newDetail.setIdOrder(order);
                newDetail.setIdShirt(shirt);

                order.getStmpOrderDetailList().add(newDetail);
            }
        }

        orderRepository.save(order);
    }
}
