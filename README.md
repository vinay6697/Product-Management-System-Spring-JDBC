# \# Product Management System

# 

# A console-based Product Management System developed using \*\*Java, Spring Core, Spring JDBC and PostgreSQL\*\*. This application allows users to manage product information and inventory through CRUD operations and stock management features.

# 

# 🚀 Technologies Used

# 

# \- Java 21

# \- Spring Framework 6.2.8

# \- Spring Core

# \- Spring JDBC

# \- PostgreSQL

# \- JDBC Template

# \- Maven

# \- Eclipse IDE

# 

# 📌 Features

# 

# The application provides the following functionalities:

# 

# 1\. Add Product – Add new products with name, category, price, quantity and description.

# 2\. Delete Product – Delete a product using its product ID.

# 3\. Search Product by Category – Retrieve products belonging to a specific category.

# 4\. Manage Product Stock – Add stock or reduce available stock.

# 5\. Check Low Stock – Identify products whose stock is below a specified threshold.

# 6\. View All Products – Display all available products.

# 7\. Find Product by ID – Retrieve individual product details using its ID.

# 8\. Update Product Details – Modify existing product information.

# 

# 🏗️ Project Architecture

# 

# The application follows a layered architecture:

# 

# 

# Main

# &#x20; |

# &#x20; v

# Service Layer

# &#x20; |

# &#x20; v

# DAO Layer

# &#x20; |

# &#x20; v

# Spring JDBC (JdbcTemplate)

# &#x20; |

# &#x20; v

# PostgreSQL Database

# 

# 

# Package Structure

# 

# com.product

# │

# ├── config

# │   └── MyConfig.java

# │

# ├── entity

# │   └── Product.java

# │

# ├── dao

# │   └── ProductDAO.java

# │

# ├── service

# │   └── ServiceDAO.java

# │

# ├── main

# │   └── Main.java

# │

# └── resources

# &#x20;   └── database.properties

# 

# 

# 🗄️ Database Configuration

# 

# 1\. Install PostgreSQL.

# 2\. Create a database for the application.

# 3\. Create the `products` table.

# 

# Example table structure:

# 

# sql

# CREATE TABLE products (

# &#x20;   product\_id SERIAL PRIMARY KEY,

# &#x20;   product\_name VARCHAR(100) NOT NULL,

# &#x20;   category VARCHAR(100) NOT NULL,

# &#x20;   price NUMERIC(10,2) NOT NULL,

# &#x20;   quantity INTEGER NOT NULL CHECK (quantity >= 0),

# &#x20;   description TEXT,

# &#x20;   created\_at TIMESTAMP DEFAULT CURRENT\_TIMESTAMP

# );

# 

# 

# 4\. Configure your database credentials in `database.properties`.

# 

# Example configuration:

# 

# properties

# db.url=jdbc:postgresql://localhost:5432/your\_database

# db.username=your\_username

# db.password=your\_password

# ```

# 

# Note: Replace the placeholder values with your PostgreSQL credentials. Do not commit your actual database credentials to GitHub.

# 

# ⚙️ Exception Handling and Validation

# 

# \- Handles invalid numeric input using `NumberFormatException`.

# \- Validates product details in the Service layer using `IllegalArgumentException`.

# \- Handles database access errors using Spring's `DataAccessException`.

# \- Prevents invalid stock operations through business validation.

# \- Prevents negative stock quantities at the database level.

# 

# ▶️ How to Run the Project

# 

# 1\. Clone the repository:

# 

# bash

# git clone https://github.com/YOUR\_USERNAME/Product-Management-System-Spring-JDBC.git

# 

# 

# 2\. Import the project into Eclipse as an existing Maven project.

# 

# 3\. Configure PostgreSQL database credentials in `database.properties`.

# 

# 4\. Ensure PostgreSQL is running and the required table is created.

# 

# 5\. Update Maven dependencies if required.

# 

# 6\. Run `Main.java` to start the application.

# 

# 📚 Concepts Practiced

# 

# \- Spring IoC Container

# \- Dependency Injection

# \- Annotation-Based Configuration

# \- `@Configuration` and `@ComponentScan`

# \- `@Component` and `@Autowired`

# \- `@Bean` and `@Value`

# \- Spring JDBC

# \- JdbcTemplate

# \- DAO and Service Layer Architecture

# \- PreparedStatement-based database operations

# \- Exception Handling

# \- Input Validation

# \- PostgreSQL Integration

# 

# 👨‍💻 Author

# 

# Developed as a hands-on Java backend learning project to gain practical experience with Spring Core, Spring JDBC and PostgreSQL.



