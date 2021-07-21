package com.example.demojunitmockito.service;

import com.example.demojunitmockito.model.User;
import com.example.demojunitmockito.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAll() {
        return userRepository.findAll();
    }

    public int count() {
        return userRepository.findAll().size();
    }

    public void saveUser(User user) {
        if (!userRepository.existsUserByName(user.getName())) {
            userRepository.save(user);
        }
    }

    public Optional<User> findbyId(int id) {
        return userRepository.findById(id);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
