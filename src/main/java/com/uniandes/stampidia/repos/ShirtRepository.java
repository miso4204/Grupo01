package com.uniandes.stampidia.repos;

import com.uniandes.stampidia.model.StmpShirt;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by SEBASTIAN on 03/04/2015.
 */
public interface ShirtRepository extends CrudRepository<StmpShirt,Integer> {
    @Override
    StmpShirt findOne(Integer integer);
}
