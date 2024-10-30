package com.civilo.roller;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling // Habilita la programación de tareas
public class RollerApplication {

	public static void main(String[] args) {
		SpringApplication.run(RollerApplication.class, args);
	}

}
