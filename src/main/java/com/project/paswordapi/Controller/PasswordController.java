package com.project.paswordapi.Controller;

import com.project.paswordapi.Controller.Mapper.PasswordMapper;
import com.project.paswordapi.Controller.Response.CreatePasswordResponses;
import com.project.paswordapi.Controller.Response.PasswordResponse;
import com.project.paswordapi.Entity.PasswordEntity;
import com.project.paswordapi.Entity.UserEntity;
import com.project.paswordapi.Service.PasswordService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin("*")
@AllArgsConstructor
@SuppressWarnings("unused")
public class PasswordController {
    private final PasswordService passwordService;

    private final PasswordMapper passwordMapper;

    @GetMapping("/generate/{passwordSize}")
    public String createPassword(@PathVariable Integer passwordSize) {
        return passwordService.generatePassword(passwordSize);
    }

    @GetMapping("/isString/{password}")
    public boolean isStrong(@PathVariable String password) {
        return passwordService.isStrongPassword(password);
    }

    @GetMapping("/{userID}/myPassword")
    public List<PasswordResponse> showAllPassword(@PathVariable UUID userID) {
        UserEntity user = new UserEntity();
        user.setId(userID);
        List<PasswordEntity> domain = passwordService.ShowAllPassword(user);
        return domain.stream().map(passwordMapper::toRest).toList();
    }

    @PostMapping("/save")
    public List<PasswordResponse> savePassword (@RequestBody List<CreatePasswordResponses> createPasswordResponses){
        List<PasswordEntity> Domain = createPasswordResponses.stream().map(passwordMapper::toDomain).toList();
         passwordService.savePassword(Domain);
         return Domain.stream().map(passwordMapper::toRest).toList();
    }

    @PostMapping("/ping")
    public String ping(){
        return "pong";
    }

    @DeleteMapping("delete/{passwordID}")
    public void deletePassword(@PathVariable UUID passwordID) {
        passwordService.deletePassword(passwordID);
    }
}
