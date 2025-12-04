package com.paymentsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


import com.paymentsystem.entity.Card;
import com.paymentsystem.services.CardService;

@Controller
@RequestMapping("/cards")
public class CardController {
    @Autowired
    private CardService cardService;

    @GetMapping("/add/{userId}")
    public String addCardForm(@PathVariable Long userId, Model model){
        model.addAttribute("card", new Card());
        model.addAttribute("userId", userId);
        return "add_card";
    }

    @PostMapping("/add/{userId}")
    public String addCard(@PathVariable Long userId, @ModelAttribute Card card){
        cardService.addCardToUser(userId, card);
        return "redirect:/users";
    }
}
