package com.login.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EntityScan(basePackages ="com.login.system.Entity")
@ComponentScan(basePackages = "com.login.system")
@EnableJpaRepositories(basePackages = "com.login.system.Repository")
public class LoginSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoginSystemApplication.class, args);
	}

}
