package com.example.postulacionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PostulacionServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(PostulacionServiceApplication.class, args);
    }
}
