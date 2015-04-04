package com.uniandes.stampidia.repos;

import com.uniandes.stampidia.model.StmpUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by SEBASTIAN on 04/04/2015.
 */
public interface UserRepository extends CrudRepository<StmpUser,Integer> {
    @Override
    public StmpUser save(StmpUser s);

    @Override
    StmpUser findOne(Integer integer);
}
