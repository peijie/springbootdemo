package com.mountainwind.example.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by peijie on 10/30/2016.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @RequestMapping(method = RequestMethod.GET)
    public Iterable<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public UserEntity findUserByName(@PathVariable String name) {

        return userRepository.findByName(name);
    }
}
