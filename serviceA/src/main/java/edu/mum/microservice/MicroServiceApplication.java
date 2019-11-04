package edu.mum.microservice;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroServiceApplication {

	public static void main(String[] args) {

		run(MicroServiceApplication.class, args);
	}

}
