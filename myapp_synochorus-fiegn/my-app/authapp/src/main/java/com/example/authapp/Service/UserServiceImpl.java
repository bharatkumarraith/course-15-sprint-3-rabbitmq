package com.example.authapp.Service;

import com.example.authapp.Exceptions.UserAlreadyExistsException;
import com.example.authapp.Repository.UserRepository;
import com.example.authapp.clientfeign.SignUpData;
import com.example.authapp.clientfeign.UserDto;
import com.example.authapp.clientfeign.UserProxy;
import com.example.authapp.model.User;
import com.example.authapp.rabbitmq.EmailDTO;
import com.example.authapp.rabbitmq.MailProducer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserProxy userProxy;
    @Autowired
    private MailProducer mailProducer;
    @Override
    public User RegisterUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getEmailId()).isEmpty()) {
            return userRepository.save(user);
        }
        else {
            throw new UserAlreadyExistsException();
        }
    }

    @Override
    public User CheckLogin(String emailId, String password) {
        return userRepository.findByEmailIdAndPassword(emailId,password);
    }

    @Override
    public User register1(SignUpData signUpData)throws UserAlreadyExistsException {
        UserDto userDto= new UserDto(signUpData.getEmailId(),signUpData.getName(),signUpData.getAddress());
        ResponseEntity responseEntity= userProxy.SendDataToProductApp(userDto);
        System.out.println(responseEntity);
        User user= new User(signUpData.getEmailId(),signUpData.getPassword(),"Role_User");
        User user1= userRepository.save(user);
        EmailDTO emailDTO=new EmailDTO(user1.getEmailId(),"hii","iam bharat","no");
        //this line shows what exact data send to receiver
        mailProducer.SendingEmailDTOtoQueue(emailDTO);
        //and this line shows sending data to queue to sending receiver

        return user1;
    }
}
