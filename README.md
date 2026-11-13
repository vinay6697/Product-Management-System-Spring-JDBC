PRODUCT MANAGEMENT SYSTEM
=========================

A console-based Product Management System developed using Java, Spring Core,
Spring JDBC and PostgreSQL. This application allows users to manage product
information and inventory through CRUD operations and stock management features.


TECHNOLOGIES USED
=================

- Java 21
- Spring Framework 6.2.8
- Spring Core
- Spring JDBC
- PostgreSQL
- JdbcTemplate
- Maven
- Eclipse IDE


FEATURES
========

The application provides the following functionalities:

1. Add Product
   Add new products with name, category, price, quantity and description.

2. Delete Product
   Delete a product using its product ID.

3. Search Product by Category
   Retrieve products belonging to a specific category.

4. Manage Product Stock
   Add stock or reduce available stock.

5. Check Low Stock
   Identify products whose stock is below a specified threshold.

6. View All Products
   Display all available products.

7. Find Product by ID
   Retrieve individual product details using its product ID.

8. Update Product Details
   Modify existing product information.


PROJECT ARCHITECTURE
====================

The application follows a layered architecture.

Main
 |
 v
Service Layer
 |
 v
DAO Layer
 |
 v
Spring JDBC (JdbcTemplate)
 |
 v
PostgreSQL Database


PACKAGE STRUCTURE
=================

com.product
    |
    |--- config
    |       |--- MyConfig.java
    |
    |--- entity
    |       |--- Product.java
    |
    |--- dao
    |       |--- ProductDAO.java
    |
    |--- service
    |       |--- ServiceDAO.java
    |
    |--- main
    |       |--- Main.java
    |
    |--- resources
            |--- database.properties


DATABASE CONFIGURATION
======================

1. Install PostgreSQL.

2. Create a database for the application.

3. Create the products table.

SQL TABLE STRUCTURE:

CREATE TABLE products (
    product_id SERIAL PRIMARY KEY,
    product_name VARCHAR(100) NOT NULL,
    category VARCHAR(100) NOT NULL,
    price NUMERIC(10,2) NOT NULL,
    quantity INTEGER NOT NULL CHECK (quantity >= 0),
    description TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

4. Configure your database credentials in database.properties.

EXAMPLE CONFIGURATION:

db.url=jdbc:postgresql://localhost:5432/your_database
db.username=your_username
db.password=your_password

NOTE:
Replace the placeholder values with your PostgreSQL credentials.
Do not commit your actual database credentials to GitHub.


EXCEPTION HANDLING AND VALIDATION
=================================

- Handles invalid numeric input using NumberFormatException.
- Validates product details in the Service layer using IllegalArgumentException.
- Handles database access errors using Spring's DataAccessException.
- Prevents invalid stock operations through business validation.
- Prevents negative stock quantities at the database level.


HOW TO RUN THE PROJECT
======================

1. Clone the repository:

   git clone https://github.com/YOUR_USERNAME/Product-Management-System-Spring-JDBC.git

2. Import the project into Eclipse as an existing Maven project.

3. Configure PostgreSQL database credentials in database.properties.

4. Ensure PostgreSQL is running and the required table is created.

5. Update Maven dependencies if required.

6. Run Main.java to start the application.


CONCEPTS PRACTICED
==================

- Spring IoC Container
- Dependency Injection
- Annotation-Based Configuration
- @Configuration and @ComponentScan
- @Component and @Autowired
- @Bean and @Value
- Spring JDBC
- JdbcTemplate
- DAO and Service Layer Architecture
- PreparedStatement-based database operations
- Exception Handling
- Input Validation
- PostgreSQL Integration


AUTHOR
======
Vinay Kumar R expertise Java Developer with experience of 3+years 
