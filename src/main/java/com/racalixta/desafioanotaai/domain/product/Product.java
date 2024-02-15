package com.racalixta.desafioanotaai.domain.product;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.racalixta.desafioanotaai.domain.category.Category;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "products")
@Getter
@Setter
@NoArgsConstructor
public class Product {
	
	@Id
	private String id;
	private String title;
	private String description;
	private String ownerId;
	private Integer price;
	private String category;
	
	public Product(ProductDTO data) {
		this.title = data.title();
		this.description = data.description();
		this.ownerId = data.ownerId();
		this.price = data.price();
		this.category = data.categoryId();
	}
}
