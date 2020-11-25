package com.audit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.audit.service.UserAuditService;
import com.shared.model.LoggedInUserInfo;

@RestController
@RequestMapping("/aud")
public class UserAuditController {

	@Autowired
	private UserAuditService userAuditService;
	
	@GetMapping(value = "/loggedinUser")
	public List<LoggedInUserInfo> getAllLoggedinUser(){
			System.out.println("@@@@@@@@@@@@@@@  "+userAuditService.getList());
		return userAuditService.getList();
	}
}
