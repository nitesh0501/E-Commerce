package com.example.demo.repository;

import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    @Autowired
    private JdbcTemplate obj;

    public String saveUserDetails(User user){
         String sql="insert into user (fName,lName,email,password) values(?,?,?,?)";
         int rows=obj.update(sql,user.getFName(),user.getLName(),user.getEmail(),user.getPassword());
         return rows>=1?"Details added successful":"Failed to add";
    }
    public Map<String,Object> checkLogin(String email,String password){
        String sql="select * from user where email=?";
        try{
            Map<String,Object> res=obj.queryForMap(sql,email);
            String dbPassword=(String)res.get("password");
            if(!dbPassword.equals(password)){
                return null;
            }
            else{
                res.remove("password");
                return res;
            }
        } catch (Exception e) {
            return null;
        }

    }
}
