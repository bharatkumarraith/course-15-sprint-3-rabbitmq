package com.example.ProductApp.Service;


import com.example.ProductApp.Exception.UserAlreadyExists;
import com.example.ProductApp.Repository.ProductRepository;
import com.example.ProductApp.model.Product;
import com.example.ProductApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService{
    @Autowired
    private ProductRepository productRepository;


    @Override
    public User AddUser(User user) throws UserAlreadyExists {
    if (productRepository.findById(user.getEmailId()).isEmpty())
    {
       return productRepository.save(user);
    }
    else {
        throw new UserAlreadyExists();
    }
    }

    @Override
    public User GetUserDetails(String emailId) {
        return productRepository.findById(emailId).get();
    }

    @Override
    public User AddProducts(Product product, String emid) {
        User u1=productRepository.findById(emid).get();
        u1.getProducts().add(product);
        return productRepository.save(u1);
    }


//    @Override
//    public List<User> getAllUsers() {
//        return productRepository.findAll();
//    }
}
