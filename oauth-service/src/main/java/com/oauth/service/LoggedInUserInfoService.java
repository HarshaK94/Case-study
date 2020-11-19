package com.oauth.service;

import java.util.List;

import com.shared.model.LoggedInUserInfo;

public interface LoggedInUserInfoService {

	public void saveLoggedInUserInfo(LoggedInUserInfo entity);
	
	public List<LoggedInUserInfo> getList();
	
	public List<LoggedInUserInfo> getListByUsername(String username);
	
	public void logout(LoggedInUserInfo entity);
	
}
