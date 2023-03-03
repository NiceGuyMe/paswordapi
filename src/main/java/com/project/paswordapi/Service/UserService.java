package com.project.paswordapi.Service;

import com.project.paswordapi.Entity.UserEntity;
import com.project.paswordapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity createUser(UserEntity userEntity){
     return userRepository.save(userEntity);
    }

    public void deleteUser(Long userID){
        userRepository.deleteById(userID);
    }
}
