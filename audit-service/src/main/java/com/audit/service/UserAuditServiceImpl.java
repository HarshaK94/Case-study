package com.audit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.audit.repository.UserAuditRepository;
import com.shared.model.LoggedInUserInfo;

@Service("userAuditService")
public class UserAuditServiceImpl implements UserAuditService {

	@Autowired
	private UserAuditRepository repository;
	
	
	@Override
	public List<LoggedInUserInfo> getList() {
		return repository.findAll();
	}
	
	 

}
