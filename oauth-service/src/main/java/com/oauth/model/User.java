package com.oauth.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {


	public User() {
	}
 
	public User(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.email = user.getEmail();
        this.enabled = user.getEnabled();
        this.accountNonExpired = user.getAccountNonExpired();
        this.credentialsNonExpired = user.getCredentialsNonExpired();
        this.accountNonLocked = user.getAccountNonLocked();
        this.roles = user.getRoles();
    }


	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	@Column(name="id")
	private Integer id;
	
	@Column(name="username")
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name ="email")
	private String email;
	
	@Column(name ="enabled")
	private Boolean enabled;
	
	@Column(name="accountNonExpired")
	private Boolean accountNonExpired;
	
	@Column(name="credentialsNonExpired")
	private Boolean credentialsNonExpired;
	
	@Column(name ="accountNonLocked")
	private Boolean accountNonLocked;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "role_user", joinColumns = {@JoinColumn(name = "user_id",referencedColumnName = "id")},
				inverseJoinColumns = {@JoinColumn(name="role_id",referencedColumnName = "role_id")})
	private List<Role> roles;

	public Integer getId() {
		return id;
	}


	public void setUserId(Integer id) {
		this.id = id;
	}


	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Boolean getEnabled() {
		return enabled;
	}


	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}


	public Boolean getAccountNonExpired() {
		return accountNonExpired;
	}


	public void setAccountNonExpired(Boolean accountNonExpired) {
		this.accountNonExpired = accountNonExpired;
	}


	public Boolean getCredentialsNonExpired() {
		return credentialsNonExpired;
	}


	public void setCredentialsNonExpired(Boolean credentialsNonExpired) {
		this.credentialsNonExpired = credentialsNonExpired;
	}


	public Boolean getAccountNonLocked() {
		return accountNonLocked;
	}


	public void setAccountNonLocked(Boolean accountNonLocked) {
		this.accountNonLocked = accountNonLocked;
	}


	public List<Role> getRoles() {
		return roles;
	}


	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	

}
