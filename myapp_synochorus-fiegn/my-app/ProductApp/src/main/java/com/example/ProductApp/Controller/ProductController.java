package com.example.ProductApp.Controller;

import com.example.ProductApp.Exception.UserAlreadyExists;
import com.example.ProductApp.Service.ProductService;
import com.example.ProductApp.model.Product;
import com.example.ProductApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product-app")
public class ProductController {
    @Autowired
    private ProductService productService;


    //http://localhost:9999/adduser

    @PostMapping("/adduser")
    public ResponseEntity<?>AddUser(@RequestBody User user)throws UserAlreadyExists
    {
        try {
            user.setProducts(new ArrayList<Product>());
            return new ResponseEntity<>(productService.AddUser(user), HttpStatus.OK);
        }
        catch (UserAlreadyExists ex)
        {
            throw new UserAlreadyExists();
        }
    }

    //http://localhost:9999/get-all-userdetails

//    @GetMapping("/get-all-userdetails")
//    public ResponseEntity<?>GetAllUsers()
//    {
//        return new ResponseEntity<>(productService.getAllUsers(),HttpStatus.OK);
//    }
    //http://localhost:9999/get-User-Details
    @GetMapping("/get-User-Details")
    public ResponseEntity<?>getUserDetails(HttpServletRequest httpServletRequest)
    {
        String currentEmail=(String)httpServletRequest.getAttribute("currentEmail");
        System.out.println(currentEmail);
        return new ResponseEntity<>(productService.GetUserDetails(currentEmail),HttpStatus.OK);
    }

    //http://localhost:9999/ADD-PRODUCT
    @PostMapping("/ADD-PRODUCT")
    public ResponseEntity<?>addProduct(@RequestBody Product product, HttpServletRequest httpServletRequest)
    {
        String currentEmail=(String)httpServletRequest.getAttribute("currentEmail");
        System.out.println(currentEmail);

        return new ResponseEntity<>(productService.AddProducts(product,currentEmail),HttpStatus.OK);
    }
}
