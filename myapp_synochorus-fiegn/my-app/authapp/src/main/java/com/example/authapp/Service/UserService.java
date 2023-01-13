package com.example.authapp.Service;

import com.example.authapp.Exceptions.UserAlreadyExistsException;
import com.example.authapp.clientfeign.SignUpData;
import com.example.authapp.model.User;

public interface UserService {
  public abstract   User RegisterUser(User user) throws UserAlreadyExistsException;
  User CheckLogin(String emailId, String password);
  public abstract User register1(SignUpData signUpData)throws UserAlreadyExistsException;
}
