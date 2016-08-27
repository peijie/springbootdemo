package com.mountainwind.tutorial.actuator;

import org.springframework.data.mongodb.repository.*;

public interface ContactRepository extends MongoRepository<Contact, String> {

}
