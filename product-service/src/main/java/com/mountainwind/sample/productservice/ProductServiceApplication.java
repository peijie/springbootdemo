package com.mountainwind.sample.productservice;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
	
	@Autowired
	ProductDetailRepository repository;
	
	@Autowired
	CompanyRepository companyRepository;

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
		

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		CompanyEntity company = new CompanyEntity();
//		company.setCompanyId(UUID.randomUUID().toString());
		company.setCompanyId("company1");
		company.setCompanyName("test company");
		company.setCompanyPhoneNumber("123456");
		company.setCompanyEmail("emal@testCompany.com");
		
		CompanyEntity company2 = new CompanyEntity();
//		company2.setCompanyId(UUID.randomUUID().toString());
		company2.setCompanyId("company2");
		company2.setCompanyName("test company2");
		company2.setCompanyPhoneNumber("123456");
		company2.setCompanyEmail("emal@testCompany.com");

		
		companyRepository.save(company);
		companyRepository.save(company2);
		
		ProductDetail detail = new ProductDetail();
		detail.setProductId("product1");
		detail.setProductName("Dan's Book of Writing");
		detail.setShortDescription("A book about writing books.");
		detail.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
		detail.setInventoryId("009178461");
		detail.setCompany(company);
		
		
		ProductDetail product2 = new ProductDetail();
		product2.setProductId("product2");
		product2.setProductName("Dan's Book of Writing");
		product2.setShortDescription("A book about writing books.");
		product2.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
		product2.setInventoryId("009178461");
		product2.setCompany(company);


		ProductDetail product3 = new ProductDetail();
		product3.setProductId("product3");
		product3.setProductName("Dan's Book of Writing");
		product3.setShortDescription("A book about writing books.");
		product3.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
		product3.setInventoryId("009178461");
		product3.setCompany(company2);

		ProductDetail product4 = new ProductDetail();
		product4.setProductId("product4");
		product4.setProductName("Dan's Book of Writing");
		product4.setShortDescription("A book about writing books.");
		product4.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
		product4.setInventoryId("009178461");
		product4.setCompany(company2);
		
		ProductDetail product5 = new ProductDetail();
		product5.setProductId("product5");
		product5.setProductName("Dan's Book of Writing");
		product5.setShortDescription("A book about writing books.");
		product5.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
		product5.setInventoryId("009178461");
		product5.setCompany(company2);
		
		ProductDetail product6 = new ProductDetail();
		product6.setProductId("product6");
		product6.setProductName("Dan's Book of Writing");
		product6.setShortDescription("A book about writing books.");
		product6.setLongDescription("In this book about writing books, Dan will show you how to write a book.");
		product6.setInventoryId("009178461");
		product6.setCompany(company2);
		

		
	        
//	        ProductDetailRepository repository = ctx.getBean(ProductDetailRepository.class);
		repository.save(detail);
		repository.save(product2);
		repository.save(product3);
		repository.save(product4);
		repository.save(product5);
		repository.save(product6);
		
		
		
		System.out.println("All products");
		for (ProductDetail productDetail : repository.findAll()) {
			ModelMapper mapper = new ModelMapper();
			ProductInfo pi = mapper.map(productDetail, ProductInfo.class);
			System.out.println(pi.getProductName());
			System.out.println("-->" + pi.getCompany().getCompanyName());
//			System.out.println(productDetail.getProductId());
		}
		
		
		System.out.println("Products from company 1: ");
		for(ProductDetail prod: repository.findByCompany_CompanyId("company1")) {
			System.out.println(prod.getProductId());
		}

	}
}
