package com.example.ProductApp.Service;


import com.example.ProductApp.Exception.UserAlreadyExists;

import com.example.ProductApp.model.Product;
import com.example.ProductApp.model.User;

import java.util.List;

public interface ProductService {
    User AddUser(User user)throws UserAlreadyExists;
//    List<User>getAllUsers();
    public abstract User GetUserDetails(String emailId);
    public abstract User AddProducts(Product product,String emid);
}
