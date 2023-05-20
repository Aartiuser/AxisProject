package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Users;
import com.example.eventmanagement.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImp implements UserService{
    @Autowired
    UserRepository userRepository;
    @Override
    public List<Users> getall(){
        return userRepository.findAll();
    }
    public Users add(Users users){
        return userRepository.save(users);
    }
    @Override
    public Users getbymail(String mail){
        return userRepository.findUsersByEmail(mail);
    }
    @Override
    public String getbymailpswdrole(String mail,String pswd,String role){
        Users user= userRepository.findUsersByEmailAndPassword(mail,pswd);
        if(user != null && user.getRole().equals(role)){
            return "success";
        }
        return "failure";
    }
}
