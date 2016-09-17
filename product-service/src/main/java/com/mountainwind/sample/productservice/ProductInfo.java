package com.mountainwind.sample.productservice;

public class ProductInfo {

    private String productId;
    private String productName;
    
    private CompanyInfo company;
    
    
    public CompanyInfo getCompany() {
		return company;
	}
	public void setCompany(CompanyInfo company) {
		this.company = company;
	}
	public String getProductId() {
        return productId;
    }
    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
}
