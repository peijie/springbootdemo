package com.mountainwind.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SbtestngApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;

	public static void main(String[] args) {
		SpringApplication.run(SbtestngApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

//		for(int i = 0; i< 10; i++) {
//			UserEntity userEntity = new UserEntity();
//			userEntity.setName("Name" + i);
//			userEntity.setAddress("Address" + i);
//			userEntity.setEmail("email" + i + "@email.com");
//
//			userRepository.save(userEntity);
//		}


	}
}
