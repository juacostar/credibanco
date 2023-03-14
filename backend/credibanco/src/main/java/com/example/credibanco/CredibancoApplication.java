package com.example.credibanco;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ComponentScan({"com.example", "credibanco.assessment.card"})
@EntityScan("credibanco.assessment.card.model")
@EnableJpaRepositories("credibanco.assessment.card.repository")
@SpringBootApplication
public class CredibancoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CredibancoApplication.class, args);
	}

}
