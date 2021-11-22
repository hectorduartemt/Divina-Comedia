package com.sergioarboleda.divinacomedia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sergioarboleda.divinacomedia"})
public class DivinacomediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivinacomediaApplication.class, args);
	}

}
