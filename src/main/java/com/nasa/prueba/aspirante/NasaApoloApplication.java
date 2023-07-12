package com.nasa.prueba.aspirante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class NasaApoloApplication {

	public static void main(String[] args) {
		SpringApplication.run(NasaApoloApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate() {

		RestTemplate restTemplate
				= new RestTemplate();

		return restTemplate;
	}
}
