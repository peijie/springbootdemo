package com.mountainwind.example.spring;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by peijie on 10/30/2016.
 */
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    UserEntity findByName(String name);
}
