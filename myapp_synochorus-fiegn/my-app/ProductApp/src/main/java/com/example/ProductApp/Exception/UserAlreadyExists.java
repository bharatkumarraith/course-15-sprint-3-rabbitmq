package com.example.ProductApp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.CONFLICT,reason = "UserAlreadyExists")
public class UserAlreadyExists extends Exception{
}
