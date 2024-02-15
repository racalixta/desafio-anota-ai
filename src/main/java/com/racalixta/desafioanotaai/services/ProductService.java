package com.racalixta.desafioanotaai.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.racalixta.desafioanotaai.domain.category.Category;
import com.racalixta.desafioanotaai.domain.category.exception.CategoryNotFoundException;
import com.racalixta.desafioanotaai.domain.product.Product;
import com.racalixta.desafioanotaai.domain.product.ProductDTO;
import com.racalixta.desafioanotaai.domain.product.exception.ProductNotFoundException;
import com.racalixta.desafioanotaai.repositories.ProductRepository;
import com.racalixta.desafioanotaai.services.aws.AwsSnsService;
import com.racalixta.desafioanotaai.services.aws.MessageDTO;

@Service
public class ProductService {

	private CategoryService categoryService;
	private ProductRepository repository;
	private AwsSnsService snsService;
	
	public ProductService(CategoryService categoryService, ProductRepository repository, AwsSnsService snsService) {
		this.categoryService = categoryService;
		this.repository = repository;
		this.snsService = snsService;
	}
	
	public Product insert(ProductDTO productData) {
		this.categoryService.getById(productData.categoryId()).orElseThrow(CategoryNotFoundException::new);
		Product newProduct = new Product(productData);
		
		this.repository.save(newProduct);
		this.snsService.publish(new MessageDTO(newProduct.getOwnerId()));
		return newProduct;
	}
	
	public Product update(String id, ProductDTO productData) {
		Product product = this.repository.findById(id).orElseThrow(ProductNotFoundException::new);
		
		if(productData.categoryId() != null) {
			this.categoryService.getById(productData.categoryId())
			.orElseThrow(CategoryNotFoundException::new);
			product.setCategory(productData.categoryId());
		}
		
		if(!productData.title().isEmpty()) product.setTitle(productData.title());
		if(!productData.description().isEmpty()) product.setDescription(productData.description());
		if(!(productData.price() == null)) product.setPrice(productData.price());
		
		this.repository.save(product);		
		this.snsService.publish(new MessageDTO(product.getOwnerId()));
		return product;
	}
	
	public void delete(String id) {
		Product product = this.repository.findById(id).orElseThrow(ProductNotFoundException::new);			
		this.repository.delete(product);
	}
	
	public List<Product> getAll() {
		return this.repository.findAll();
	}
	
}
