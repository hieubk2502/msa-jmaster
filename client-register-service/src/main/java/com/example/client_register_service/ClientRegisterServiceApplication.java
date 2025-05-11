package com.example.client_register_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ClientRegisterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientRegisterServiceApplication.class, args);
	}

}
