# Category and Product Management REST API

This is a Spring Boot project that implements a REST API for managing categories and products. The project allows you to perform CRUD operations on categories and products, establish a one-to-many relationship between them, and implement server-side pagination.

Author: Vinay Shenoy

## Endpoints

### Category CRUD Operations

1. **GET all categories with pagination**

   - URL: `http://localhost:8080/api/categories?page={page}`
   - Method: GET

2. **Create a new category**

   - URL: `http://localhost:8080/api/categories`
   - Method: POST

3. **Get category by ID**

   - URL: `http://localhost:8080/api/categories/{id}`
   - Method: GET

4. **Update category by ID**

   - URL: `http://localhost:8080/api/categories/{id}`
   - Method: PUT

5. **Delete category by ID**

   - URL: `http://localhost:8080/api/categories/{id}`
   - Method: DELETE

### Product CRUD Operations

1. **GET all products with pagination**

   - URL: `http://localhost:8080/api/products?page={page}`
   - Method: GET

2. **Create a new product**

   - URL: `http://localhost:8080/api/products`
   - Method: POST

3. **Get product by ID**

   - URL: `http://localhost:8080/api/products/{id}`
   - Method: GET

4. **Update product by ID**

   - URL: `http://localhost:8080/api/products/{id}`
   - Method: PUT

5. **Delete product by ID**

   - URL: `http://localhost:8080/api/products/{id}`
   - Method: DELETE

## One-to-Many Relationship

Categories and Products have a one-to-many relationship. This means that one category can have multiple products associated with it.

## Server-Side Pagination

For endpoints that return lists of categories or products, server-side pagination is implemented to improve performance. You can specify the `page` parameter in the URL to retrieve specific pages of data.

## Fetching Single Product Details

When fetching details of a single product, the response includes the respective category details, providing a comprehensive view of the product.

## Setup and Running the Project

1. Clone the repository to your local machine.

2. Open the project in your preferred IDE (e.g.,SpringToolSuite, Eclipse).

3. Configure your database settings in `application.properties`.

4. Run the Spring Boot application.

## Dependencies

- Spring Boot DevTools
- Spring Data JPA
- Spring Web
- Lombok
- MYSQL (or any database of your choice)

## Author

- Vinay Shenoy

Feel free to modify this `README.md` to suit your project's specific needs and provide additional information or instructions as required.
