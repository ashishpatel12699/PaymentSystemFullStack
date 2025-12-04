package com.paymentsystem.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymentsystem.entity.Card;
import com.paymentsystem.entity.Transaction;
import com.paymentsystem.repository.CardRepository;
import com.paymentsystem.repository.TransactionRepository;

@Service
public class TransactionService {
    @Autowired
    private TransactionRepository transactionRepository;

    @Autowired
    private CardRepository cardRepository;

    public Transaction makeTransaction(Long cardId, double amount, String desc) {
        Card card = cardRepository.findById(cardId).orElse(null);
        if(card != null && card.getBalance() >= amount) {
            card.setBalance(card.getBalance() - amount);
            cardRepository.save(card);

            Transaction txn = new Transaction();
            txn.setCard(card);
            txn.setAmount(amount);
            txn.setDescription(desc);
            txn.setTransactionDate(LocalDateTime.now());

            return transactionRepository.save(txn);
        }
        return null;
    }

    public List<Transaction> getTransactions(Long cardId){
        Card card = cardRepository.findById(cardId).orElse(null);
        return card != null ? transactionRepository.findAll().stream()
                .filter(t -> t.getCard().getId().equals(cardId))
                .toList() : new ArrayList<>();
    }
}
