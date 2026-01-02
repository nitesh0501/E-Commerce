package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class UserService {

    @Autowired
    private UserRepository repo;

    public String saveUserDetails(User user){
         return repo.saveUserDetails(user);
    }
    public Map<String,Object> checkLogin(String email,String password){
        return repo.checkLogin(email,password);
    }
}
