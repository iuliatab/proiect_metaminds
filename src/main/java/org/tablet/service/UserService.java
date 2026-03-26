package org.tablet.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.tablet.persistence.UserRepository;
import org.tablet.persistence.entity.User;

import java.security.MessageDigest;
import java.util.Base64;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User registerUser(User user) {
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Acest email este deja folosit de alt utilizator!");
        }

        String parolaSecurizata = hashPassword(user.getPassword());
        user.setPassword(parolaSecurizata);

        return userRepository.save(user);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            return Base64.getEncoder().encodeToString(hash);
        } catch (Exception e) {
            throw new RuntimeException("Eroare la securizarea parolei!");
        }
    }
}