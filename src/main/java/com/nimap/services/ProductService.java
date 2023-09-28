package com.nimap.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.nimap.models.Category;
import com.nimap.models.Product;
import com.nimap.repositories.CategoryRepository;
import com.nimap.repositories.ProductRepository;
import com.nimap.responsewrapper.ResponseWrapper;

@Service
public class ProductService {
	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	public ResponseEntity<?> addProduct(Product product) {

		String category = product.getCategory().getName();
		Category cat = categoryRepository.findByName(category).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "given category " + category + " does not exist");
		});
		
		product.setCategory(cat);
		Product data = productRepository.save(product);
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Product added successfully");
		responseWrapper.setData(data);
		return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
	}
	
	public Page<Product> getAllProducts(int page, int pageSize) {
		Pageable pageable = PageRequest.of(page - 1, pageSize);
		return productRepository.findAll(pageable);
	}

	public ResponseEntity<?> getProductById(int id) {
		Product productById = productRepository.findById(id).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product with id: " + id);
		});
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Product with id: " + id);
		responseWrapper.setData(productById);
		return new ResponseEntity<>(responseWrapper, HttpStatus.FOUND);
	}

	public ResponseEntity<?> updateProductById(int id, Product product) {
		getProductById(id);
		product.setId(id);
		String category = product.getCategory().getName();
		Category cat = categoryRepository.findByName(category).orElseThrow(() -> {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "given category " + category + " does not exist");
		});
		product.setCategory(cat);
		Product data = productRepository.save(product);
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Product edited successfully");
		responseWrapper.setData(data);
		return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
	}

	public String deleteProductById(int id) {
		getProductById(id);
		productRepository.deleteById(id);
		return "Product with id: " + id + " removed successfully";
	}
}
