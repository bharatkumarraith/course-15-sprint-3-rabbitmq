package com.example.authapp.Repository;

import com.example.authapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
    public abstract User findByEmailIdAndPassword(String emailId, String password);
}
