package com.uniandes.stampidia.repos;

import com.uniandes.stampidia.model.StmpOfert;
import com.uniandes.stampidia.model.StmpOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by SEBASTIAN on 02/04/2015.
 */
public interface OfferRepository extends CrudRepository<StmpOfert,Integer> {

    @Query(value="select s from StmpOfert s where s.status = true ")
    List<Object[]> listAllActive();
}
