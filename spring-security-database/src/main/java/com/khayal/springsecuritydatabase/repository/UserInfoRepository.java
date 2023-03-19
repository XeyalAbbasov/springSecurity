package com.khayal.springsecuritydatabase.repository;

import com.khayal.springsecuritydatabase.model.UserInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserInfoRepository extends JpaRepository<UserInfo,Integer> {


   //bazadan neyi elde edirikse onu userdetails e convert edirik
    Optional<UserInfo> findByName(String username);
}
