package com.product.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.product.entity.Product;

@Repository
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
	
	public int deleteProduct(int id)
	{
		String deleteQuery="DELETE FROM PRODUCT WHERE PRODUCT_ID=?";
		return jdbcTemplate.update(deleteQuery,id);
	}
	
	public List<Product> searchProductByICategory(String category)
	{
		String searchQuery="SELECT * FROM PRODUCT WHERE CATEGORY=?";
		
		return jdbcTemplate.query(searchQuery, new RowMapper<Product>() {

		    @Override
		    public Product mapRow(ResultSet rs, int rowNum)
		            throws SQLException {

		        Product product = new Product();

		        product.setProductId(rs.getInt("product_id"));
		        product.setProductName(rs.getString("product_name"));
		        product.setCategory(rs.getString("category"));
		        product.setPrice(rs.getBigDecimal("price"));
		        product.setQuantity(rs.getInt("quantity"));
		        product.setDescription(rs.getString("description"));

		        return product;
		    }
		}, category);
	}
	
	public int addStock(int productId,int quantity)
	{
		String updateQuery="UPDATE PRODUCT SET quantity = quantity + ? WHERE product_id = ?";
		return jdbcTemplate.update(updateQuery,quantity,productId);
	}
	
	public int reduceStock(int productId,int quantity)
	{
		String updateQuery="UPDATE PRODUCT SET quantity = quantity - ? WHERE product_id = ? AND quantity >= ?";
		return jdbcTemplate.update(updateQuery,quantity,productId,quantity);
	}
	
	public List<Product> checkLowStock(int threshold)
	{
		String selectQuery="SELECT * FROM PRODUCT WHERE QUANTITY<=?";
		return jdbcTemplate.query(selectQuery, new RowMapper<Product>() {

		    @Override
		    public Product mapRow(ResultSet rs, int rowNum)
		            throws SQLException {

		        Product product = new Product();

		        product.setProductId(rs.getInt("product_id"));
		        product.setProductName(rs.getString("product_name"));
		        product.setCategory(rs.getString("category"));
		        product.setPrice(rs.getBigDecimal("price"));
		        product.setQuantity(rs.getInt("quantity"));
		        product.setDescription(rs.getString("description"));

		        return product;
		    }
		},threshold);
	}

	public List<Product> getAllProduct()
	{
		String selectQuery="SELECT * FROM PRODUCT";
		return jdbcTemplate.query(selectQuery, new RowMapper<Product>() {
			
			public Product mapRow(ResultSet rs,int rowNum) throws SQLException {
				Product product=new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
		        product.setCategory(rs.getString("category"));
		        product.setPrice(rs.getBigDecimal("price"));
		        product.setQuantity(rs.getInt("quantity"));
		        product.setDescription(rs.getString("description"));
		        
		        return product;
			}
		});
	}
	
	public Product getProductById(int id)
	{
		String selectQuery="SELECT * FROM PRODUCT WHERE PRODUCT_ID=?";
		List<Product> products =jdbcTemplate.query(selectQuery,new RowMapper<Product>() {

			@Override
			public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
				Product product=new Product();
				product.setProductId(rs.getInt("product_id"));
				product.setProductName(rs.getString("product_name"));
		        product.setCategory(rs.getString("category"));
		        product.setPrice(rs.getBigDecimal("price"));
		        product.setQuantity(rs.getInt("quantity"));
		        product.setDescription(rs.getString("description"));
		        
				return product;
			}
			},id);
		if (products.isEmpty()) {
		    return null;
		}

		return products.get(0);
	}
	
	public int updateProduct(Product product)
	{
		    String query = "UPDATE product SET product_name = ?, "
		                 + "category = ?, price = ?, description = ? "
		                 + "WHERE product_id = ?";

		    return jdbcTemplate.update(
		        query,
		        product.getProductName(),
		        product.getCategory(),
		        product.getPrice(),
		        product.getDescription(),
		        product.getProductId()
		    );
	}
}

















