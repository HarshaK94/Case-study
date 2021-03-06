package com.oauth.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AuthUserDetail extends User implements UserDetails {



	private static final long serialVersionUID = 1L;
	
	public AuthUserDetail(User user) {
		super(user);
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> authorities = new ArrayList<>();
		 getRoles().forEach(role -> {
			authorities.add(new SimpleGrantedAuthority(role.getName()));
			role.getPermissions().forEach(permission -> {
				authorities.add(new SimpleGrantedAuthority(permission.getName()));
			});
		});
		 return authorities;
	}

	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		return super.getAccountNonExpired();
	}

	@Override
	public boolean isAccountNonLocked() {
		return super.getAccountNonLocked();
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return super.getCredentialsNonExpired();
	}

	@Override
	public boolean isEnabled() {
		return super.getEnabled();
	}

	

}
