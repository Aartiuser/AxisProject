package com.example.eventmanagement.Controllers;

import com.example.eventmanagement.Models.UserLogin;
import com.example.eventmanagement.Models.Users;
import com.example.eventmanagement.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {
    @Autowired
    UserService userService;
    @GetMapping("/getusers")
    @ResponseBody
    public List<Users> getall(){
        return userService.getall();
    }
    @PostMapping("/login")
    @ResponseBody
    public String login(@RequestBody UserLogin userLogin) {

        String email = userLogin.getEmail();
        String password = userLogin.getPassword();
        String role = userLogin.getRole();
        String msg=userService.getbymailpswdrole(email,password,role);
        return msg;
    }
    @PostMapping("/addusers")
    @ResponseBody
    public Users add(@RequestBody Users user){
        return userService.add(user);
    }


}
