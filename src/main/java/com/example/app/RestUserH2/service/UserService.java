package com.example.app.RestUserH2.service;

import com.example.app.RestUserH2.entity.User;
import com.example.app.RestUserH2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository repository;

    public List<User> getAllUsers() {
        return new ArrayList<>(repository.findAll());
    }

    public ResponseEntity<User> getUserById(int id) {
        Optional<User> user = repository.findById(id);
        return user.map(value ->
                ResponseEntity.ok().body(value)).orElseGet(() ->
                ResponseEntity.notFound().build());
    }

    public User saveOrUpdate(User user) {
        return repository.save(user);
    }

    public void deleteUserById(int id) {
        repository.deleteById(id);
    }
}
