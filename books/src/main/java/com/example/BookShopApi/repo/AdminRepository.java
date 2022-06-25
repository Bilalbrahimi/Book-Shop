package com.example.BookShopApi.repo;

import com.example.BookShopApi.model.Admin;
import com.example.BookShopApi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, Long> {
    @Override
    void deleteById(Long id);

    User findByAdminName (String username);

    @Override
    Optional<Admin> findById (Long id);

}
