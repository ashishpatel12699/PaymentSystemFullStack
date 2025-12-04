package com.paymentsystem.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentsystem.entity.Card;
import com.paymentsystem.entity.User;
import com.paymentsystem.repository.CardRepository;
import com.paymentsystem.repository.UserRepository;

@Service
public class CardService {
    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private UserRepository userRepository;

    public Card addCardToUser(Long userId, Card card) {
        User user = userRepository.findById(userId).orElse(null);
        if(user != null) {
            card.setUser(user);
            return cardRepository.save(card);
        }
        return null;
    }

    public List<Card> getCardsByUser(Long userId){
        User user = userRepository.findById(userId).orElse(null);
        return user != null ? user.getCards() : new ArrayList<>();
    }
}

