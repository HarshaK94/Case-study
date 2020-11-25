package com.oauth.config;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationEventPublisher;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import com.oauth.service.LoggedInUserInfoService;
import com.shared.model.LoggedInUserInfo;

@Component("authenticationEventPublisher")
public class AuthenticationEventListener implements AuthenticationEventPublisher{

	
	@Autowired
	private HttpServletRequest request;
	
	@Autowired
	private LoggedInUserInfoService loggedInUserInfoService;
	
	@Override
	public void publishAuthenticationSuccess(Authentication authentication) {
		//here mobile is client id from oauth_client table
		if(authentication.getName()!=null&&!authentication.getName().equals("mobile")) {
		LoggedInUserInfo info = new LoggedInUserInfo();
		info.setUsername(authentication.getName());
		info.setLogin("yes");
		info.setLoginDateTime(LocalDateTime.now());
		info.setDescription("Login success!");
		info.setIpAddress(request.getRemoteAddr());
		loggedInUserInfoService.saveLoggedInUserInfo(info);
		}
	}

	@Override
	public void publishAuthenticationFailure(AuthenticationException exception, Authentication authentication) {
		if(!authentication.getName().equals("mobile")) {
		LoggedInUserInfo info = new LoggedInUserInfo();
		info.setUsername(authentication.getName());
		info.setLogin("no");
		info.setLoginDateTime(LocalDateTime.now());
		info.setDescription(exception.getMessage());
		info.setIpAddress(request.getRemoteAddr());
		loggedInUserInfoService.saveLoggedInUserInfo(info);
		}
	}

}
