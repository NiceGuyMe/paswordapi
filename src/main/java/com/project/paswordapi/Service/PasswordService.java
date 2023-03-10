package com.project.paswordapi.Service;

import com.project.paswordapi.Entity.PasswordEntity;
import com.project.paswordapi.Entity.UserEntity;
import com.project.paswordapi.Repository.PasswordRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class PasswordService {

    private final PasswordRepository passwordRepository;

    private static final String CHAR_LOWER = "abcdefghijklmnopqrstuvwxyz";
    private static final String CHAR_UPPER = CHAR_LOWER.toUpperCase();
    private static final String NUMBER = "0123456789";
    private static final String OTHER_CHAR = "!@#$%&*()_+-=[]?{}|<>";
    private static final String PASSWORD_ALLOW_BASE = CHAR_LOWER + CHAR_UPPER + NUMBER + OTHER_CHAR;

    public String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int index = (int) (Math.random() * PASSWORD_ALLOW_BASE.length());
            password.append(PASSWORD_ALLOW_BASE.charAt(index));
        }
        return password.toString();
    }

    public boolean isStrongPassword(String password) {
        return password.matches("^(?=.*[a-z])(?=.*[A-Z]).+$\n") && password.matches("^(?=.*\\d).+$") && password.matches("^(?=.*[@#$%^&+=]).+$");
    }

    public List<PasswordEntity> savePassword(List<PasswordEntity> passwordEntity) {
        return passwordRepository.saveAll(passwordEntity);
    }

    public List<PasswordEntity> ShowAllPassword(UserEntity user) {
        return passwordRepository.findByUserEntity(user);
    }

    public void deletePassword(UUID passwordID) {
        passwordRepository.deleteById(passwordID);
    }
}
