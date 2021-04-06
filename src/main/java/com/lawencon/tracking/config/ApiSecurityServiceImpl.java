package com.lawencon.tracking.config;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.lawencon.tracking.model.Users;
import com.lawencon.tracking.service.UserService;

/**
 *
 * @author Galih Dika
 *
 */
@Service
public class ApiSecurityServiceImpl implements UserDetailsService {

	@Autowired
    private UserService userServices;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		try {
          Users userDb = userServices.getUserByUsername(username);
			if (userDb != null) {
            return new User(userDb.getUsername(), userDb.getPassword(), new ArrayList<>());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
