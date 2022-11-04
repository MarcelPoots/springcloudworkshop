package com.rossie.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rossie.demo.model.Product;

public interface ProductRepo extends JpaRepository<Product, Long> {

}
