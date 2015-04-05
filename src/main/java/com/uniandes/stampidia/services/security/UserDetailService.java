package com.uniandes.stampidia.services.security;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.uniandes.stampidia.model.StmpUser;
import com.uniandes.stampidia.repos.UserRepository;

@Service
public class UserDetailService implements UserDetailsService {

	private static final String INVALID_USER = " is not registered!";
	@Autowired
	private UserRepository userRepository;
	
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		StmpUser user = userRepository.findUserByName(username);
		if(user == null){
			throw new UsernameNotFoundException(username + INVALID_USER);
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_BUYER")); 	
		
		return new User(username,"password",authorities);
	}

}
