package com.mountainwind.lab.clientloadbalancing;

import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name="lserver", configuration = ServerConfiguration.class)
public class ClientLoadBalancingApplication implements CommandLineRunner {
	
//	private static final Logger logger = LoggerFactory.getLogger(ClientLoadBalancingApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ClientLoadBalancingApplication.class, args);
	}
	
	
	  @LoadBalanced
	  @Bean
	  RestTemplate restTemplate(){
	    return new RestTemplate();
	  }
	  
	  
	  @Autowired
	  RestTemplate restTemplate;
	
	
	@Override
	public void run(String ... args) throws Exception {
//		RestTemplate restTemplate = new RestTemplate();
		
		System.out.println("Enter running &&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		String plainCreds = "user:password";
		byte[] plainCredsBytes = plainCreds.getBytes();
		byte[] base64CredsBytes = Base64.encode(plainCredsBytes);
		String base64Creds = new String(base64CredsBytes);

		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Basic " + base64Creds);
		
		HttpEntity<String> request = new HttpEntity<String>(headers);
		
		while(true) {
			try {
				
				ResponseEntity<Contact> contact = restTemplate.exchange("http://lserver/contacts/57b027ecaf12f62ba434c2d7",HttpMethod.GET, request, Contact.class);
				
				System.out.println(contact.getBody().toString());
				
				Thread.sleep(1000);
			
			} catch(Exception e) {
				System.out.println("Exception Captured: ");
				System.out.println(e.getMessage());
			}
		}
		

		
	}
	
	

}
