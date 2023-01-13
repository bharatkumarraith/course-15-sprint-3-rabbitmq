package com.example.ProductApp.Repository;

import com.example.ProductApp.model.Product;
import com.example.ProductApp.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<User,String> {
}
