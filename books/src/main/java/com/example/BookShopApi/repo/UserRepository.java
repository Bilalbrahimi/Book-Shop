package com.example.BookShopApi.repo;

import com.example.BookShopApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    @Override
    void deleteById(Long id);

    User findByUsername (String username);

    @Override
    Optional<User> findById (Long id);
}