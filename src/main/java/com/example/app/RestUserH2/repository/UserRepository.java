package com.example.app.RestUserH2.repository;

import com.example.app.RestUserH2.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

    <S extends User> S save(S user);

    Optional<User> findById(int id);

    List<User> findAll();

    void deleteById(int id);
}
