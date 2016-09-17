package com.mountainwind.sample.productservice;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends CrudRepository<CompanyEntity, String>{

}
