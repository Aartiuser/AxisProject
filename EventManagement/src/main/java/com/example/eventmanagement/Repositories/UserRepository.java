package com.example.eventmanagement.Repositories;

import com.example.eventmanagement.Models.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {
    @Override
    List<Users> findAll();
    @Override
    Users  save(Users users);

    Users findUsersByEmail(String email);
    Users findUsersByEmailAndPassword(String email, String password);
}
