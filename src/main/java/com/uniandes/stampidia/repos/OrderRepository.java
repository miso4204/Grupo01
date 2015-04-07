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

    StmpOrder save(StmpOrder order);

    void delete(StmpOrder order);

    @Query(value="select s from stmp_order s where s.id_user = :userId ",nativeQuery=true)
    StmpOrder findStmpOrderByUserId(@Param("userId") Integer userId);
}
