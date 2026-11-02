package com.product.dao;

import java.sql.PreparedStatement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.product.entity.Product;

@Component(value = "productDAO")
public class ProductDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public int addProduct(Product product)
	{
		String insertQuery="INSERT INTO PRODUCT (product_name, category, price, quantity, description)"
				+ " VALUES (?, ?, ?, ?, ?)";
		
		return jdbcTemplate.update(connection -> {

            PreparedStatement ps = connection.prepareStatement(insertQuery);

            ps.setString(1, product.getProductName());
            ps.setString(2, product.getCategory());
            ps.setBigDecimal(3, product.getPrice());
            ps.setInt(4, product.getQuantity());
            ps.setString(5, product.getDescription());

            return ps;
        });
	}

}
