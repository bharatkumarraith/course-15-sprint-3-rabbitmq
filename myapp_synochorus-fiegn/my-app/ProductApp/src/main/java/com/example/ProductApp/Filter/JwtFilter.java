package com.example.ProductApp.Filter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtFilter extends GenericFilterBean {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpServletRequest=(HttpServletRequest)servletRequest;
        HttpServletResponse httpServletResponse=(HttpServletResponse)servletResponse;
        String authHeader= httpServletRequest.getHeader("authorization");
        if(authHeader==null || !authHeader.startsWith("Bearer"))
        {
            throw new ServletException("Token is missing");
        }
        else{
            String token= authHeader.substring(7);
            System.out.println(token);
           Claims claims= Jwts.parser().setSigningKey("idontsay").parseClaimsJws(token).getBody();
            System.out.println(claims);
            httpServletRequest.setAttribute("currentEmail",claims.get("emailId"));
            filterChain.doFilter(httpServletRequest,httpServletResponse);

        }
    }
}
