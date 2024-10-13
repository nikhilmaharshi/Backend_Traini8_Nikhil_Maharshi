package com.traini8.trainingcenterregistry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Training Center Registry Application.
 *
 * This application serves as Training Center Registry service,
 * which manages the registration and database of
 * Government-funded Training Centers.
 */
@SpringBootApplication
public class TrainingCenterRegistryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrainingCenterRegistryApplication.class, args);
	}

}
