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

/**
 * Servicio utilizado para consultar la informacion de un usuario contra la base de datos
 * 
 * @author Diego Agudelo
 *
 */
@Service
public class UserDetailService implements UserDetailsService {

	/**
	 * Constante utilizada para denotar que el usuario consultado no es valido
	 */
	private static final String INVALID_USER = " is not registered!";
	
	/**
	 * Repositorio de consulta 
	 */
	@Autowired
	private UserRepository userRepository;
	
	/**
	 * Metodo que carga la informacion de un usuario dado el 'nombre de usuario'
	 */
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		StmpUser user = userRepository.findUserByName(username);
		if(user == null){
			throw new UsernameNotFoundException(username + INVALID_USER);
		}
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		if(user.getIsSeller()){
			authorities.add(new SimpleGrantedAuthority("ROLE_SELLER"));
		}else{
			authorities.add(new SimpleGrantedAuthority("ROLE_BUYER"));	
		}		 	
		
		return new User(username,user.getPassword().toString(),authorities);
	}

}
