package com.product.service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.product.dao.ProductDAO;
import com.product.entity.Product;

@Component
public class Service {
	
	 private final ProductDAO dao;

	    public Service(ProductDAO dao) {
	        this.dao = dao;
	    }
	
	public int addProduct(Product product)
	{
		int result=0;
		
		if(product==null)
			 System.out.println("Product cannot be null");
	    else if(product.getProductName().isBlank())
			System.out.println("Product name cannot be empty");
		else if(product.getCategory().isBlank())
			System.out.println("product category cannot be empty");
		else if(product.getPrice()==null)
			System.out.println("Price must be greater than zero");
		else if(product.getPrice().compareTo(BigDecimal.ZERO)<=0)
			System.out.println("price cannot be less the 0");
		else if(product.getQuantity()<=0)
			System.out.println("Quantity must be greater than zero");
		else if(product.getDescription().isBlank())
			System.out.println("product description cannot be empty");
		else
			result = dao.addProduct(product);
		
		return result;
	}
	
	public int deleteProduct(int id)
	{
		if(id<=0)
		{
			System.out.println("Id's cannot be negative or less than 0");
			return 0;
		}
		else
			return dao.deleteProduct(id);
	}
	
	public List<Product> searchProductByCategory(String category)
	{
		List<Product> products=new ArrayList<>();
		
		if(category.isBlank())
			System.out.println("please enter the product category it cannot be empty");
		else
		products= dao.searchProductByICategory(category);
		
		return products;
	}
	
	public int addStock(int id,int quantity)
	{
		int result=0;
		if(id<=0 || quantity<=0)
			System.out.println("Product ID and quantity must be greater than zero");
		else
			result=dao.addStock(id,quantity);
		return result;
	}
	
	public int reduceStock(int id,int quantity)
	{
		int result=0;
		if(id<=0 || quantity<=0)
			System.out.println("Product ID and quantity must be greater than zero");
		else
			result=dao.reduceStock(id,quantity);
		return result;
	}
	
	public List<Product> checkLowStock(int threshold)
	{
		List<Product> products=new ArrayList<>();
		if(threshold<=0)
			System.out.println("Threshold must be greater than zero");
		else
			products=dao.checkLowStock(threshold);
		return products;
	}
	
	public List<Product> getAllProduct()
	{
		return dao.getAllProduct();
	}
	
	public Product getProductById(int id)
	{
		Product product=null;
		
		if(id<=0)
			throw  new IllegalArgumentException("Product ID must be greater than zero");
		else
			product=dao.getProductById(id);
		return product;
	}
	
	public int updateProduct(Product product)
	{
		int result=0;
		
		if(product.getProductId()<=0)
			System.out.println("Product id cannot be 0 or negative");
		else if(product.getProductName().isBlank())
			System.out.println("Product name cannot be empty");
		else if(product.getCategory().isBlank())
			System.out.println("product category cannot be empty");
		else if(product.getPrice().compareTo(BigDecimal.ZERO)<=0)
			System.out.println("Price must be greater than zero");
		else
			result = dao.updateProduct(product);
		
		return result;
	}
}
