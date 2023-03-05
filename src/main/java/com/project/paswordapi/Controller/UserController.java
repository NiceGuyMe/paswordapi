package com.project.paswordapi.Controller;

import com.project.paswordapi.Controller.Mapper.UserMapper;
import com.project.paswordapi.Controller.Response.CreateUserResponse;
import com.project.paswordapi.Controller.Response.UserResponse;
import com.project.paswordapi.Entity.UserEntity;
import com.project.paswordapi.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
public class UserController {
    @Autowired
private UserService userService;
    @Autowired
    private UserMapper userMapper;
    @PostMapping("/createUser")
    public List<UserResponse> createUser(@RequestBody List<CreateUserResponse> createUserResponses){
        List<UserEntity> domain = createUserResponses.stream().map(userMapper::toDomain).toList();
        userService.createUser(domain);
        return domain.stream().map(userMapper::toRest).toList();
    }
}
