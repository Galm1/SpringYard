package com.example.SpringYard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.SpringYard"})
@EntityScan("com.SpringYard.model")
@EnableJpaRepositories("com.SpringYard.repository")
public class SpringYardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringYardApplication.class, args);
	}
}
