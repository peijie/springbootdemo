package com.mountainwind.sample.productservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CompanyService {
	
	@Autowired
	private CompanyRepository rep;
	
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void save(CompanyEntity company) {
		rep.save(company);
	}
	
	
	 @Transactional(readOnly = true)
	public Iterable<CompanyEntity> getAllCompanies() {
		return rep.findAll();
	}

}
