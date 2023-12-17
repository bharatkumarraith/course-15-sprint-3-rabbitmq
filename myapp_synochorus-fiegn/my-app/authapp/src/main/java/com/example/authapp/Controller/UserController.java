package com.example.authapp.Controller;

import com.example.authapp.Exceptions.UserAlreadyExistsException;
import com.example.authapp.Service.UserService;
import com.example.authapp.TokenGenerator.JwtService;
import com.example.authapp.clientfeign.SignUpData;
import com.example.authapp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin
@RestController
@RequestMapping("/auth-app")
public class UserController {
    @Autowired
    private UserService userService;
@Autowired
private JwtService jwtService;

    //http://localhost:3456/auth-app/addUser
    @PostMapping("/addUser")
    public ResponseEntity<?>AddUser(@RequestBody User user)throws UserAlreadyExistsException
    {
        try {
            user.setRole("Role-user");
            return new ResponseEntity<>(userService.RegisterUser(user), HttpStatus.OK);
        }
        catch (UserAlreadyExistsException ex)
        {
            throw new UserAlreadyExistsException();
        }
    }
    //http://localhost:3456/auth-app/register-user1
    @PostMapping("/register-user1")
      public ResponseEntity<?> registerUser1(@RequestBody SignUpData signUpData) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.register1(signUpData),HttpStatus.OK);
    }

    //http://localhost:3456/auth-app/check-Login/{emailId}/{password}
    @GetMapping("/check-Login/{emailId}/{password}")
    public ResponseEntity<?> checkLogin(@PathVariable String emailId, @PathVariable String password )
    {
        User result=userService.CheckLogin(emailId,password);
        System.out.println(result);
        if (result!=null)
        {
//            return new ResponseEntity<>(result,HttpStatus.OK);
            return new ResponseEntity<>(jwtService.Generate(result),HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>("LoginFailed",HttpStatus.OK);
        }
    }

}

