package com.Revature.Study_Buddy_Backend.Service.impl;

import com.Revature.Study_Buddy_Backend.Model.FlashCards;
import com.Revature.Study_Buddy_Backend.Repository.FlashCardsRepo;
import com.Revature.Study_Buddy_Backend.Service.FlashCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashCardsServiceImpl implements FlashCardsService{
    @Autowired
    private final FlashCardsRepo flashCardsRepo;
    public FlashCardsServiceImpl(FlashCardsRepo flashCardsRepo){ this.flashCardsRepo = flashCardsRepo;}
    public List<FlashCards> getAllFlashCards(){
        return flashCardsRepo.findAll();
    }
    public FlashCards getByfCardId (Long id) {
        return flashCardsRepo.findByfCardId(id);
    }
    public FlashCards addFlashCards (FlashCards flashCards){
        return flashCardsRepo.save(flashCards);
    }
    public FlashCards updateFlashCards (FlashCards flashCards){
        return flashCardsRepo.save(flashCards);
    }

    public void deleteByfCardId (Long fCardId) {
        flashCardsRepo.deleteByfCardId(fCardId);
    }
}
