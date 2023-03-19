package com.khayal.springsecuritydatabase.service;

import com.khayal.springsecuritydatabase.model.UserInfo;
import com.khayal.springsecuritydatabase.repository.UserInfoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserInfoRepository userInfoRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String createUser(UserInfo userInfo){

        userInfo.setPassword(passwordEncoder.encode(userInfo.getPassword()));
        userInfoRepository.save(userInfo);

        return "User has been created!";
    }
}
