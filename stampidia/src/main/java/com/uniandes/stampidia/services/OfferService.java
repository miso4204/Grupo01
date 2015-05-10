package com.uniandes.stampidia.services;

import com.uniandes.stampidia.model.StmpOfert;
import com.uniandes.stampidia.model.StmpOrder;
import com.uniandes.stampidia.model.StmpOrderDetail;
import com.uniandes.stampidia.model.StmpShirt;
import com.uniandes.stampidia.repos.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.NoResultException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by SEBASTIAN on 02/04/2015.
 */
@Service
@Transactional
public class OfferService {

    @Autowired
    private OfferRepository offerRepository;

    public StmpOfert saveSpecialOffer(StmpOfert offer){
        return offerRepository.save(offer);
    }

    public Object getActiveSpecialOffer() {
        List<Object> activeOffers = offerRepository.listAllActive();
        return activeOffers.get(0);
    }
}
