package com.example.Fortunemvn.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.Fortunemvn.Dao.UserDao;
import com.example.Fortunemvn.model.UserDTO;
import com.example.Fortunemvn.model.Users;

@Service
public class JwtUserDetailsService implements UserDetailsService {
	
	@Autowired
	private UserDao userDao;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Users user1 =  userDao.findByUsername(username);
		if (user1 == null) {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(user1.getUsername(), user1.getPassword(),
				new ArrayList<>());
	}
	
	public Users save(UserDTO user1) {
		Users newUser = new Users();
		newUser.setUsername(user1.getUsername());
		newUser.setPassword(bcryptEncoder.encode(user1.getPassword()));
		return userDao.save(newUser);
	}

}