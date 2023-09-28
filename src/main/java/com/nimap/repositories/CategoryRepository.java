package com.nimap.repositories;


import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nimap.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Page<Category> findAll(Pageable pageable);
	Optional<Category> findByName(String name);
    
    
}
