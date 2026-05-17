package com.postulante.postulante;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PostulanteApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostulanteApplication.class, args);
	}

}
