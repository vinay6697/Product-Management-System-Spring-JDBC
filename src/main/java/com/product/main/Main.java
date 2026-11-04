package com.product.main;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.product.config.MyConfig;
import com.product.entity.Product;
import com.product.service.Service;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
		Service service=context.getBean("service",Service.class);
		Scanner sc=new Scanner(System.in);
		String str="";
		
		do {
			System.out.println("Enter the choice");
			System.out.println("Enter 1 to add the product");
			System.out.println("Enter 2 to delete the product");
			System.out.println("Enter 3 to search the product");
			System.out.println("Enter 4 to update the productStock");
			System.out.println("Enter 5 to checkLowStock");
			System.out.println("Enter 6 to get all the products");
			System.out.println("Enter 7 to get the product by id");
			System.out.println("Enter 8 to update the product details");
			int choice=sc.nextInt();
			sc.nextLine();

			try
			{
				
				switch(choice)
				{
					case 1:
					{
						System.out.println("Enter the product name");
						String name=sc.nextLine();
						
						System.out.println("Enter the product category");
						String category=sc.nextLine();
						
						System.out.println("Enter the price");
						double d=sc.nextDouble();
						BigDecimal price=new BigDecimal(d);
						
						System.out.println("Enter the quantity");
						int quantity=sc.nextInt();
						sc.nextLine();
						
						System.out.println("Enter the description");
						String description=sc.nextLine();
						
						Product product=new Product(name,category,price,quantity,description);
						
						    int result = service.addProduct(product);
	
						    if (result > 0)
						        System.out.println("Product inserted successfully");
						    else
						        System.out.println("Product insertion failed");
	
						
						break;
					}
					case 2:
					{
						System.out.println("Enter the id");
						int id=sc.nextInt();
						sc.nextLine();
						int result=service.deleteProduct(id);
						if(result>0)
							System.out.println("Product deleted successfully");
						else
							System.out.println("Product not found");
						break;
	
					}
					case 3:
					{
						System.out.println("Enter the category");
						String category=sc.nextLine();
						List<Product> products=service.searchProductByCategory(category);
						if(products!=null && products.size()!=0)
						{
							for(Product product:products)
							{
								System.out.println(product);
							}
						}
						else
							System.out.println("product not found for category: "+category);
						
						break;
					}
					case 4:
					{
						int result=manageStock(service,sc);
						if(result>0)
							System.out.println("product stock update succesfully");
						else
							System.out.println("Product not found or insufficient stock");
						sc.nextLine();
						
						break;
					}
					case 5:
					{
						System.out.println("Enter the Threshold");
						int threshold=sc.nextInt();
						sc.nextLine();
						List<Product> products=service.checkLowStock(threshold);
						if(products!=null)
						{
							for(Product product:products) {
								System.out.println(product);
							}
						}
						else
						{
							System.out.println("Did not find any produc wiht the threshold "+threshold);
						}
						break;
					}
					case 6:
					{
						List<Product> products=service.getAllProduct();
						if(products!=null)
						{
							for(Product product:products) {
								System.out.println(product);
							}
						}
						else
						{
							System.out.println("no products available");
						}
						break;
					}
					case 7:
					{
						System.out.println("Enter the product id");
						int id=sc.nextInt();
						sc.nextLine();
						Product product=service.getProductById(id);
						if(product!=null)
							System.out.println(product);
						else
							System.out.println("Product not found");
						break;
					}
					case 8:
					{
						int result=updateProduct(service,sc);
						if(result>0)
							System.out.println("product details updated successfully");
						else
							System.out.println("product not found");
						break;
					}
					default:
					{
						System.out.println("invalid choice");
						break;
					}
				}//end of switch
			} catch (IllegalArgumentException e) {
			    System.out.println("Validation Error: " + e.getMessage());
			}//end of try catchBlock
			
			System.out.println("Enter Y for YES or N for no");
			str=sc.nextLine();
		}
		while(str.equalsIgnoreCase("y"));
		sc.close();
		
		context.close();
		System.out.println("application closed succesfully");
	}
	
	public static int manageStock(Service service,Scanner sc)
	{
		System.out.println("Enter the product id");
		int id=sc.nextInt();
		System.out.println("Enter 1 to update stock");
		System.out.println("Enter 2 to reduce stock");
		int productChoice=sc.nextInt();
		int result=0;
		switch(productChoice)
		{
			case 1:
			{
				System.out.println("Enter the quantity");
				int quantity=sc.nextInt();
				
				result=service.addStock(id, quantity);
				break;
			}
			case 2:
			{
				System.out.println("Enter the quantity");
				int quantity=sc.nextInt();
				result=service.reduceStock(id, quantity);
				break;
			}
			default :
			{
				System.out.println("invalid choice");
				break;
			}
		}//end of inner switch
		return result;
	}
	
	public static int updateProduct(Service service,Scanner sc)
	{
		System.out.println("Enter the product id");
		int id=sc.nextInt();
		sc.nextLine();
		
		System.out.println("Enter the Product name");
		String name=sc.nextLine();
		
		System.out.println("Enter the Product category");
		String category=sc.nextLine();
		
		System.out.println("Enter the product new Price");
		BigDecimal price=new BigDecimal(sc.nextDouble());
		sc.nextLine();
		
		System.out.println("Enter the Product Description");
		String description =sc.nextLine();
		
		Product product=new Product();
		product.setProductId(id);
		product.setProductName(name);
		product.setCategory(category);
		product.setPrice(price);
		product.setDescription(description);
		
		int result=service.updateProduct(product);
		return result;
	}
}


