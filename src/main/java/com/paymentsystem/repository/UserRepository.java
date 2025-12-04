package com.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentsystem.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {}



