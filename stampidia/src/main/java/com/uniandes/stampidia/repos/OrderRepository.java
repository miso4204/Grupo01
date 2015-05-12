package com.uniandes.stampidia.repos;

import com.uniandes.stampidia.model.StmpOrder;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by SEBASTIAN on 02/04/2015.
 */
public interface OrderRepository extends CrudRepository<StmpOrder,Integer> {

    @Override
    StmpOrder findOne(Integer integer);

//    StmpOrder save(StmpOrder order);

    void delete(StmpOrder order);

    @Query(value="select s from StmpOrder s where s.idUser.id = :userId and s.orderStatus = true")
    Object findStmpOrderByUserId(@Param("userId") Integer userId);
    
    @Query(value="select s from StmpOrder s where s.idUser.id = :userId and s.orderStatus = false")
    List<StmpOrder> findStmpOrderClosedByUserId(@Param("userId") Integer userId);
}
