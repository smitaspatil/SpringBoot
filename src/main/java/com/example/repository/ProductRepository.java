package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Product;



public interface ProductRepository extends JpaRepository<Product,Integer>{

	Optional<Product> findByName(String name);

}
