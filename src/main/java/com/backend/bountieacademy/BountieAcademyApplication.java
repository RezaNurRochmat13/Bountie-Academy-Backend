package com.backend.bountieacademy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BountieAcademyApplication {

	public static void main(String[] args) {
		SpringApplication.run(BountieAcademyApplication.class, args);
	}

}
