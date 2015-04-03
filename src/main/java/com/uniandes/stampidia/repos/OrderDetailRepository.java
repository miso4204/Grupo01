package com.uniandes.stampidia.repos;

import com.uniandes.stampidia.model.StmpOrderDetail;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by SEBASTIAN on 02/04/2015.
 */
public interface OrderDetailRepository extends CrudRepository<StmpOrderDetail,Integer> {
}
