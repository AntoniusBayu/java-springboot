package com.example.authorization.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class MyUserPrincipal implements UserDetails{
	private static final long serialVersionUID = 1L;
	final private vwuser _user;
	
	
	public MyUserPrincipal(vwuser user)
	{
		this._user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getAuth(this._user.getRoleid());
	}
	
	private Collection<? extends GrantedAuthority> getAuth(String role)
	{
		List<GrantedAuthority> auth = new ArrayList<>();
		auth.add(new SimpleGrantedAuthority(role));
		return auth;
	}

	@Override
	public String getPassword() {
		return this._user.getPassword();
	}

	@Override
	public String getUsername() {
		return this._user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
}
