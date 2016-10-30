package com.mountainwind.example.spring;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

public class SbtestngApplicationTests extends AbstractTestNGSpringContextTests {


	@Autowired
	TestRestTemplate testRestTemplate;

	@Autowired
	UserRepository userRepository;



	@Test
	public void contextLoads() {
//		for(int i = 0; i< 10; i++) {
//			UserEntity userEntity = new UserEntity();
//			userEntity.setName("Name" + i);
//			userEntity.setAddress("Address" + i);
//			userEntity.setEmail("email" + i + "@email.com");
//
//			userRepository.save(userEntity);
//		}
	}


	@BeforeClass
	void userInitialization() {
		for(int i = 0; i< 10; i++) {
			UserEntity userEntity = new UserEntity();
			userEntity.setName("Name" + i);
			userEntity.setAddress("Address" + i);
			userEntity.setEmail("email" + i + "@email.com");

			userRepository.save(userEntity);
		}
	}

	@Test
	public void retrievingAllUsersTest() {

		try {

//		ResponseEntity<Iterable<UserEntity>> entity = testRestTemplate.exchange(
//				"/",
//				HttpMethod.GET,
//				null,
//				new ParameterizedTypeReference<Iterable<UserEntity>>() {});

			ResponseEntity<String> entity = testRestTemplate.getForEntity("/user", String.class);

			assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);

			//convert the json to objects
			ObjectMapper mapper = new ObjectMapper();

//			UserEntity[] users = mapper.readValue(entity.getBody(), UserEntity[].class);

//			for(int i=0; i<users.length; i++) {
//				assertThat(users[i].getName()).isEqualTo("Name" + i);
//			}

			List<UserEntity> users = mapper.readValue(entity.getBody(), new TypeReference<List<UserEntity>>() {});

			assertThat(users.size()).isEqualTo(10);

			for(int i=0; i<users.size(); i++) {
				assertThat(users.get(i).getName()).isEqualTo("Name" + i);
			}


		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Test
	void retrieveOneUserTest() {
		try {
			ResponseEntity<UserEntity> entity = testRestTemplate.getForEntity("/user/Name1", UserEntity.class);

			assertThat(entity.getStatusCode()).isEqualTo(HttpStatus.OK);
			assertThat(entity.getBody()).isNotNull();

			assertThat(entity.getBody().getName()).isEqualTo("Name1");

		} catch(Exception e) {
			e.printStackTrace();
		}


	}

}
