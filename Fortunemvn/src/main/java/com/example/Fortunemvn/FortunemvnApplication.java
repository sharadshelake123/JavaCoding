package com.example.Fortunemvn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableScheduling
public class FortunemvnApplication {

	public static void main(String[] args) {
		SpringApplication.run(FortunemvnApplication.class, args);
	}

}

