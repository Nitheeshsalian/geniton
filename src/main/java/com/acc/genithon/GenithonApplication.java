package com.acc.genithon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class GenithonApplication {

	public static void main(String[] args) {
		SpringApplication.run(GenithonApplication.class, args);
	}

}
