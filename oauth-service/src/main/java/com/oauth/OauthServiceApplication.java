package com.oauth;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableAuthorizationServer
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EntityScan(basePackages= {"com.shared.model","com.oauth.model"})
@RestController

public class OauthServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OauthServiceApplication.class, args);
	}

	@Autowired
	private TokenStore tokenStore;

	@GetMapping(value = "/oauth/revoke-token")
	@ResponseStatus(code = HttpStatus.OK)
	public void logout(HttpServletRequest request) {
		String authHeader = request.getHeader("Authorization");
		if (authHeader != null) {
			String tokenValue = authHeader.replace("bearer", "").trim();
			OAuth2AccessToken accessToken = tokenStore.readAccessToken(tokenValue);
			tokenStore.removeAccessToken(accessToken);
			
		}
	}
}
