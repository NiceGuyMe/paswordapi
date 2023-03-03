package com.project.paswordapi.Controller;

import com.project.paswordapi.Entity.UserEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

@RestController
public class UserController {

    @GetMapping("/{id}")
    public String getUserById(@PathVariable Long id) {
        return "Hello User " + id + "!";
    }
}
