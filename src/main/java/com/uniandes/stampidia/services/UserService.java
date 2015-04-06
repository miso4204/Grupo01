package com.uniandes.stampidia.services;

import com.uniandes.stampidia.model.StmpUser;
import com.uniandes.stampidia.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by SEBASTIAN on 04/04/2015.
 */
@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public StmpUser updateBuyerProfile(StmpUser user){
        // TODO :: implementar la actualizacion propia del seller
        StmpUser storedUser = userRepository.findOne(user.getId());
        if(storedUser != null){
            storedUser.setUsername(user.getUsername());

            return userRepository.save(storedUser);
        }
        // TODO :: implementar el camino alterno
        return null;
    }

    public StmpUser updateSellerProfile(StmpUser user){
        // TODO :: implementar la actualizacion propia del seller
        StmpUser storedUser = userRepository.findOne(user.getId());
        if(storedUser != null){
            storedUser.setUsername(user.getUsername());

            return userRepository.save(storedUser);
        }
        // TODO :: implementar el camino alterno
        return null;
    }
}
