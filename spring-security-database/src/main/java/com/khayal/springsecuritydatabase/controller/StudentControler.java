package com.khayal.springsecuritydatabase.controller;

import com.khayal.springsecuritydatabase.model.UserInfo;
import com.khayal.springsecuritydatabase.service.ProductService;
import com.khayal.springsecuritydatabase.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class StudentControler {

    @Autowired
    private UserService userService;

    @PostMapping("/new")
    public String createUser(@RequestBody UserInfo userInfo){

        return userService.createUser(userInfo);
    }
}
