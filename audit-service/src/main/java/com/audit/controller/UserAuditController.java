package com.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.service.UserAuditService;
import com.shared.model.LoggedInUserInfo;

@RestController
public class UserAuditController {

	@Autowired
	private UserAuditService userAuditService;
	
	@RequestMapping(value = "/loggedinUser")
	public List<LoggedInUserInfo> getAllLoggedinUser(){
		return userAuditService.getList();
	}
}
