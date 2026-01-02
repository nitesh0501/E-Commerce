package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping("/save-all")
    public ResponseEntity<?> saveUserDetails(@RequestBody User user){
          String response=service.saveUserDetails(user);
          Map<String,String> res=new HashMap<>();
          res.put("fname",user.getFName());
          res.put("lname",user.getLName());
          res.put("email",user.getEmail());
          res.put("password",user.getPassword());

          return ResponseEntity.ok(res);

    }

    @PostMapping("/login")
    public ResponseEntity<?> checkLogin(@RequestBody User user) {
        String email=user.getEmail();
        String password=user.getPassword();

        Map<String,Object> dbUser=service.checkLogin(email,password);

        if (dbUser == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body("Invalid username or password");
        }

        Map<String, Object> response = new HashMap<>();
        response.put("message", "Login successful");
        response.put("user", dbUser);

        return ResponseEntity.ok(response);
    }




}
