package com.microservicios.productService.repository;

import com.microservicios.productService.entity.Category;
import com.microservicios.productService.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository  extends JpaRepository<Product, Long> {
    public List<Product> findByCategory(Category category);
}