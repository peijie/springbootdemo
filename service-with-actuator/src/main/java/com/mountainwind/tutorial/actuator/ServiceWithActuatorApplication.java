package com.mountainwind.tutorial.actuator;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableDiscoveryClient
@SpringBootApplication
@Configuration
@ComponentScan
@EnableAutoConfiguration
@RestController
@EnableCaching
public class ServiceWithActuatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceWithActuatorApplication.class, args);
	}
	
	
	  @RequestMapping(value = "/")
	  public String home() {

	    return "Hi!";
	  }
	
	
	@Bean
    CommandLineRunner init(final AccountRepository accountRepository) {
      
      return new CommandLineRunner() {

        @Override
        public void run(String... arg0) throws Exception {
          accountRepository.save(new Account("user", "password"));
          
        }
        
      };

    }
}


//
//@RestController
//class ServiceInstanceRestController {
//
//    @Autowired
//    private DiscoveryClient discoveryClient;
//
//    @RequestMapping("/service-instances/{applicationName}")
//    public List<ServiceInstance> serviceInstancesByApplicationName(
//            @PathVariable String applicationName) {
//        return this.discoveryClient.getInstances(applicationName);
//    }
//}
