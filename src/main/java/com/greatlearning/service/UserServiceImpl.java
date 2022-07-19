package com.greatlearning.service;

import com.greatlearning.entity.User;
import com.greatlearning.repository.UserRepository;
import com.greatlearning.security.MyUserDetails;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.getUserByUserName(username);

		if (user == null) {
			throw new UsernameNotFoundException("Username not present");
		}
		return new MyUserDetails(user);
	}

}
