package com.audit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true)
@EntityScan(basePackages = "com.shared.model")
//@EnableEurekaClient
public class AuditServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuditServiceApplication.class, args);
	}

}
