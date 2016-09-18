package com.mountainwind.sample.productservice;

public class ChartData {
	
	private String year;
	private double sales;
	private double expenses;
	
	public ChartData(String year, double sales, double expenses) {
		this.year = year;
		this.sales = sales;
		this.expenses = expenses;
	}
	
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public double getSales() {
		return sales;
	}
	public void setSales(double sales) {
		this.sales = sales;
	}
	public double getExpenses() {
		return expenses;
	}
	public void setExpenses(double expenses) {
		this.expenses = expenses;
	}


}
