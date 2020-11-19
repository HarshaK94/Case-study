package com.shared.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="logged_in_user_info")
public class LoggedInUserInfo {


	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="info_id")
	private Integer id;
	@Column(name="username")
	private String username;
	@Column(name="login_date_time")
	private LocalDateTime loginDateTime;
	@Column(name="is_login")
	private String login;
	
	@Column(name="description")
	private String description;
	@Column(name="ip_address")
	private String ipAddress;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public LocalDateTime getLoginDateTime() {
		return loginDateTime;
	}
	public void setLoginDateTime(LocalDateTime loginDateTime) {
		this.loginDateTime = loginDateTime;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	
	

}
