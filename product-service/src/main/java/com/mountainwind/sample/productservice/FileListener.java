package com.mountainwind.sample.productservice;


import org.apache.commons.io.input.TailerListenerAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class FileListener extends TailerListenerAdapter  {
	
	public void setCompanyService(CompanyService service) {
		this.companyService = service;
	}
	
	@Autowired
	private CompanyService companyService;
	
	@Transactional(propagation=Propagation.REQUIRES_NEW)
	public void handle(String line) {
        System.out.println(line);
        
        String[] fields = line.split(",");
        CompanyEntity company = new CompanyEntity();
        company.setCompanyId(fields[0]);
        company.setCompanyName(fields[1]);
        company.setCompanyPhoneNumber(fields[2]);
        company.setCompanyEmail(fields[3]);
        
        try {
          companyService.save(company);
            
//            companyService.getAllCompanies();
        	
        }
        catch(Exception e) {
        	e.printStackTrace();
        	System.out.println(e.getMessage());
        }
        
//        System.out.println(company.getCompanyId());
    }

}
