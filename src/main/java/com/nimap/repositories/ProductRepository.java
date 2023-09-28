package com.nimap.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.nimap.models.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{
	Page<Product> findAll(Pageable pageable);
}
