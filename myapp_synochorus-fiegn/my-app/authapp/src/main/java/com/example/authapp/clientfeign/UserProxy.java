package com.example.authapp.clientfeign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@FeignClient(name ="ProductApp",url ="localhost:9999")
public interface UserProxy {
    @PostMapping("/product-app/adduser")
    public abstract ResponseEntity<?> SendDataToProductApp(@RequestBody UserDto userDto);
}
