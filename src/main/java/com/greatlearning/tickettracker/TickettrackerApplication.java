package com.greatlearning.tickettracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class TickettrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TickettrackerApplication.class, args);
	}

}
