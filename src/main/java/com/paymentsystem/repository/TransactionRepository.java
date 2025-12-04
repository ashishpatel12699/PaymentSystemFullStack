package com.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentsystem.entity.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {}

