package com.racalixta.desafioanotaai.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.racalixta.desafioanotaai.domain.product.Product;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
}
