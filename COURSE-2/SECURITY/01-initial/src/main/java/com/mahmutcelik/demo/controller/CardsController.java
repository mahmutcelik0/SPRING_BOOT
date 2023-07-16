package com.mahmutcelik.demo.controller;

import com.mahmutcelik.demo.model.Cards;
import com.mahmutcelik.demo.repository.CardsRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cards")
public class CardsController {
    private final CardsRepository cardsRepository;

    public CardsController(CardsRepository cardsRepository) {
        this.cardsRepository = cardsRepository;
    }

    @GetMapping
    public List<Cards> getCardsDetails(@RequestParam int id) {
        List<Cards> cards = cardsRepository.findByCustomerId(id);

        return cards;
    }
}
