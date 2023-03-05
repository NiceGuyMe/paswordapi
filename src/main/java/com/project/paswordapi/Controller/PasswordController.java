package com.project.paswordapi.Controller;

import com.project.paswordapi.Controller.Mapper.PasswordMapper;
import com.project.paswordapi.Controller.Response.CreatePasswordResponse;
import com.project.paswordapi.Controller.Response.PasswordResponse;
import com.project.paswordapi.Entity.PasswordEntity;
import com.project.paswordapi.Entity.UserEntity;
import com.project.paswordapi.Service.PasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@CrossOrigin("*")
public class PasswordController {
    @Autowired
    private PasswordService passwordService;

    @Autowired
    private PasswordMapper passwordMapper;

    @GetMapping("/generate/{passwordSize}")
    public String createPassword(@PathVariable Integer passwordSize) {
        return passwordService.generatePassword(passwordSize);
    }

    @GetMapping("/isString/{password}")
    public boolean isStrong(@PathVariable String password) {
        return passwordService.isStrongPassword(password);
    }

    @GetMapping("/mypassword")
    public List<PasswordResponse> showallpassword(@RequestBody UserEntity user) {
        List<PasswordEntity> domain = passwordService.ShowAllPassword(user);
        return domain.stream().map(passwordMapper::toRest).toList();
    }

    @PostMapping("/save")
    public List<PasswordResponse> savePassword (@RequestBody List<CreatePasswordResponse> createPasswordResponses){
        List<PasswordEntity> Domain = createPasswordResponses.stream().map(passwordMapper::toDomain).toList();
         passwordService.savePassword(Domain);
         return Domain.stream().map(passwordMapper::toRest).toList();
    }


//    public List<PasswordEntity> savePassword (@RequestBody List<PasswordEntity> passwordEntities){
//        return passwordService.savePassword(passwordEntities);
//    }
    @PostMapping("/ping")
    public String ping(){
        return "pong";
    }

    @DeleteMapping("delete/{passwordID}")
    public void deletePassword(@PathVariable Long passwordID) {
        passwordService.deletePassword(passwordID);
    }
}
