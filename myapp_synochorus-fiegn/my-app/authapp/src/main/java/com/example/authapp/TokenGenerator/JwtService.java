package com.example.authapp.TokenGenerator;

import com.example.authapp.model.User;

import java.util.Map;

public interface JwtService {
    public abstract Map<String,String>Generate(User user);
}
