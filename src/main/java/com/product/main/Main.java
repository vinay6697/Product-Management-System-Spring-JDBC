package com.product.main;

import java.math.BigDecimal;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.product.config.MyConfig;
import com.product.dao.ProductDAO;
import com.product.entity.Product;

public class Main {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
		ProductDAO dao = context.getBean("productDAO", ProductDAO.class);
		
		Scanner sc=new Scanner(System.in);
		String str="";
		
		
		do {
			System.out.println("Enter the choice");
			System.out.println("Enter 1 to add the product");
			System.out.println("Enter 2 to update the product");
			System.out.println("Enter 3 to delete the product");
			System.out.println("Enter 4 to find the product");
			int choice=sc.nextInt();
			sc.nextLine();
			
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
					
					int result=dao.addProduct(product);
					if(result>0)
						System.out.println("Product inserted successfully");
					else
						System.out.println("product failed to insert");
					
					break;
				}
				case 2:
				{
					break;
				}
				case 3:
				{
					break;
				}
				default:
				{
					System.out.println("invalid choice");
					break;
				}
			}//end of switch
			System.out.println("Enter Y for YES or N for no");
			str=sc.nextLine();
		}
		while(str.equalsIgnoreCase("y"));
		sc.close();
		
		context.close();
	}
}
