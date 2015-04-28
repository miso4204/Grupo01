package com.uniandes.stampidia.repos;

import com.uniandes.stampidia.model.StmpOrderDetail;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by SEBASTIAN on 02/04/2015.
 */
public interface OrderDetailRepository extends CrudRepository<StmpOrderDetail,Integer> {
    StmpOrderDetail save(StmpOrderDetail detail);

    @Override
    void delete(StmpOrderDetail detail);

    @Query(value="select s from StmpOrderDetail s where s.idOrder.id = :idOrder ")
    List<StmpOrderDetail> getOrderDetailsByOrderId(@Param("idOrder") Integer idOrder);
}
