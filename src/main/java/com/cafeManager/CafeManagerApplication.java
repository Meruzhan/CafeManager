package com.cafeManager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@EnableAutoConfiguration()
@EnableWebMvc
@EnableJpaRepositories(basePackages = "com")
public class CafeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(CafeManagerApplication.class, args);
	}
}
