package com.mountainwind.demo.orc.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class OcrEurekaApplication {

	public static void main(String[] args) {
		SpringApplication.run(OcrEurekaApplication.class, args);
	}
}
