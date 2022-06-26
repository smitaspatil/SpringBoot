package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.entity.Product;
import com.example.repository.ProductRepository;



@Service
public class ProductService {
	@Autowired
	private ProductRepository repo;
    public Product saveProduct(Product product) {
		return repo.save(product);
    	
    }
    public List<Product> saveProduct(List<Product> products) {
		return repo.saveAll(products);
    	
    }
    public List<Product> getProducts(){
    return repo.findAll();
    }
    
    public Product getProductById(int id){
        return repo.findById(id).orElse(null);
        }
        
    public Product getProductByName(String name){
        return repo.findByName(name).orElse(null);
        }
    public String deleteProduct(int id)
    {
    	repo.deleteById(id);
    	return "product removed";
    }
    public Product updateProduct(Product product) {
    	Product existingProduct=repo.findById(product.getId()).orElse(product);
    	existingProduct.setName(product.getName());
    	existingProduct.setQuantity(product.getQuantity());
    	existingProduct.setPrice(product.getPrice());
    	return repo.save(existingProduct);
    }
}
