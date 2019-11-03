package edu.mum.ServiceA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import static org.springframework.boot.SpringApplication.*;

@SpringBootApplication
@EnableDiscoveryClient
public class ServiceAApplication {

	public static void main(String[] args) {

		run(ServiceAApplication.class, args);
	}

}
