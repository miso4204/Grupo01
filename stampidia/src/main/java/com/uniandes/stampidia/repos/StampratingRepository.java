package com.uniandes.stampidia.repos;

import com.uniandes.stampidia.model.StmpStamp;
import com.uniandes.stampidia.model.StmpStampRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface StampratingRepository extends CrudRepository<StmpStampRating,Integer>{
}
