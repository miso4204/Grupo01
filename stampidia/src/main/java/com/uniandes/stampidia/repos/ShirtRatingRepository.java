package com.uniandes.stampidia.repos;

import com.uniandes.stampidia.model.StmpShirt;
import com.uniandes.stampidia.model.StmpShirtRating;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ShirtRatingRepository extends CrudRepository<StmpShirtRating,Integer>{


}
