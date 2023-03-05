package com.project.paswordapi.Service;

import com.project.paswordapi.Entity.UserEntity;
import com.project.paswordapi.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<UserEntity> createUser(List<UserEntity> userEntity){
     return userRepository.saveAll(userEntity);
    }

    public void deleteUser(UUID userID){
        userRepository.deleteById(userID);
    }
}
