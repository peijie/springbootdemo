package com.mountainwind.sample.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/companies")
public class CompanyController {
	
	@Autowired
	CompanyRepository repository;
	
	@RequestMapping(method=RequestMethod.GET)
	public Iterable<CompanyEntity> findAll() {
		return repository.findAll();
	}

}
