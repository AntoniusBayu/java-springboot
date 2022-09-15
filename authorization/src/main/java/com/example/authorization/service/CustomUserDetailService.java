package com.example.authorization.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.authorization.model.MyUserPrincipal;
import com.example.authorization.model.vwuser;
import com.example.authorization.repo.userrepository;

@Service
public class CustomUserDetailService implements UserDetailsService {

	@Autowired
	private userrepository _repo;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		System.out.print(username);
		vwuser u = _repo.findByUsername(username);
		PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
		u.setPassword(encoder.encode(u.getPassword()));
		var x = new MyUserPrincipal(u);
		
		return x;
	}

}
