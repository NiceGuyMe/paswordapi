package com.project.paswordapi.Controller;

import com.project.paswordapi.Controller.Mapper.UserMapper;
import com.project.paswordapi.Controller.Response.CreateUserResponse;
import com.project.paswordapi.Controller.Response.UserResponse;
import com.project.paswordapi.Entity.UserEntity;
import com.project.paswordapi.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.UUID;

@RestController
@AllArgsConstructor
@SuppressWarnings("unused")
public class UserController {
private final UserService userService;
    private final UserMapper userMapper;
    @PostMapping("/createUser")
    public List<UserResponse> createUser(@RequestBody List<CreateUserResponse> createUserResponses){
        List<UserEntity> domain = createUserResponses.stream().map(userMapper::toDomain).toList();
        userService.createUser(domain);
        return domain.stream().map(userMapper::toRest).toList();
    }
    @DeleteMapping("/deleteUser/{userId}")
    public void deleteUser (@PathVariable UUID userId){
        userService.deleteUser(userId);
    }
}
