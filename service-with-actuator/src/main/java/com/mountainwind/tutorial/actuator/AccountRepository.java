package com.mountainwind.tutorial.actuator;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface AccountRepository extends MongoRepository<Account, String> {
  
  public Account findByUsername(String username);

}
