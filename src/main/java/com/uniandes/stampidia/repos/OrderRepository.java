package com.uniandes.stampidia.repos;

import com.uniandes.stampidia.model.StmpOrder;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by SEBASTIAN on 02/04/2015.
 */
public interface OrderRepository extends CrudRepository<StmpOrder,Integer> {

    StmpOrder save(StmpOrder order);

    void delete(StmpOrder order);
}
