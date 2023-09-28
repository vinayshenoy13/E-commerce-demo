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
import com.nimap.repositories.CategoryRepository;
import com.nimap.responsewrapper.ResponseWrapper;

@Service
public class CategoryService {

	@Autowired
	private CategoryRepository categoryRepository;

	public ResponseEntity<?> addCategory(Category category) {

		Category data = categoryRepository.save(category);
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Category added successfully");
		responseWrapper.setData(data);
		return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
	}

	public Page<Category> getAllCategories(int page, int pageSize) {
        Pageable pageable = PageRequest.of(page - 1, pageSize);
       return categoryRepository.findAll(pageable);
    }
	
	public ResponseEntity<?> getCategoryById(int id){
		Category categoryById = categoryRepository.findById(id).orElseThrow(()->{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Category with id: "+id);
		});
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Category with id: "+id);
		responseWrapper.setData(categoryById);
		return new ResponseEntity<>(responseWrapper, HttpStatus.FOUND);
	}
	
	public ResponseEntity<?> updateCategoryById(int id,Category category){
		getCategoryById(id);
		category.setId(id);
		Category data = categoryRepository.save(category);
		ResponseWrapper responseWrapper = new ResponseWrapper();
		responseWrapper.setMessage("Category added successfully");
		responseWrapper.setData(data);
		return new ResponseEntity<>(responseWrapper, HttpStatus.OK);
	}
	
	public String deleteCategoryById(int id){
		getCategoryById(id);
		categoryRepository.deleteById(id);
		return "Category with id: "+id+" removed successfully";
	}

}
