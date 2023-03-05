package com.project.paswordapi.Service;

import com.project.paswordapi.Entity.UserEntity;
import com.project.paswordapi.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void createUser(List<UserEntity> userEntity){
        userRepository.saveAll(userEntity);
    }

    public void deleteUser(UUID userID){
        userRepository.deleteById(userID);
    }
}
