package com.creditcard.springtest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableConfigurationProperties
public class CreditcardprocessorApplication{

	public static void main(String[] args) {
		SpringApplication.run(CreditcardprocessorApplication.class, args);
	}
	
}
