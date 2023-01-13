package com.example.authapp.TokenGenerator;

import com.example.authapp.model.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class JwtTokenGeneratorImpl implements JwtService{
    @Override
    public Map<String, String> Generate(User user) {
        Map<String,String> result= new HashMap<String,String>();
        Map<String,Object> userdata=new HashMap<>();
        userdata.put("emailId",user.getEmailId());
        userdata.put("role",user.getRole());
        String jwt= Jwts.builder()
                .setClaims(userdata)
                .setIssuedAt(new Date())
                .setIssuer("mycompany")
                .signWith(SignatureAlgorithm.HS512,"idontsay")
                .compact();
        result.put("token",jwt);
        result.put("message","loginsuccessfull,Token Generated");
        return result;
    }
}
