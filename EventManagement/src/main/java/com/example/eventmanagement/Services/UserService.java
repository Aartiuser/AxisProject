package com.example.eventmanagement.Services;

import com.example.eventmanagement.Models.Users;

import java.util.List;

public interface UserService {
    List<Users> getall();
    Users add(Users users);
    Users getbymail(String mail);
    String getbymailpswdrole(String mail,String pswd,String role);
}
