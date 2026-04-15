package com.ahmedhassan.speakly;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class SpeaklyApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpeaklyApplication.class, args);
	}

}