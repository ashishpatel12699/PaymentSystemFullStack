package com.paymentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.paymentsystem.services.TransactionService;

@Controller
@RequestMapping("/transactions")
public class TransactionController {
    @Autowired
    private TransactionService transactionService;

    @GetMapping("/add/{cardId}")
    public String addTransactionForm(@PathVariable Long cardId, Model model){
        model.addAttribute("cardId", cardId);
        return "add_transaction";
    }

    @PostMapping("/add/{cardId}")
    public String addTransaction(@PathVariable Long cardId, @RequestParam double amount, @RequestParam String desc){
        transactionService.makeTransaction(cardId, amount, desc);
        return "redirect:/users";
    }
}

