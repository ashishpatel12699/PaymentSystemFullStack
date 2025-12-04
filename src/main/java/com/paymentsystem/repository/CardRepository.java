package com.paymentsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.paymentsystem.entity.Card;

public interface CardRepository extends JpaRepository<Card, Long>
{

}
