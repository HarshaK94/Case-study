package com.oauth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.oauth.repository.LoggedInUserInfoRepository;
import com.shared.model.LoggedInUserInfo;

@Service("loggedInUserInfoService")
public class LoggedInUserInfoServiceImpl implements LoggedInUserInfoService{

	@Autowired
	private LoggedInUserInfoRepository repository;
	
	@Override
	public void saveLoggedInUserInfo(LoggedInUserInfo entity) {
		repository.saveAndFlush(entity);
		
	}

	@Override
	public List<LoggedInUserInfo> getList() {
		return repository.findAll();
	}

	@Override
	public List<LoggedInUserInfo> getListByUsername(String username) {
		return repository.getListByUsername(username);
	}

	@Override
	public void logout(LoggedInUserInfo entity) {
		entity.setDescription("Logout successfully !");
		repository.saveAndFlush(entity);
		
	}
	
	

	
	
	
}
