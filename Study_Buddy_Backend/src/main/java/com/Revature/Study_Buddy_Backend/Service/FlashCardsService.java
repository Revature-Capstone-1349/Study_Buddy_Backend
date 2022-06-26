package com.Revature.Study_Buddy_Backend.Service;

import com.Revature.Study_Buddy_Backend.Model.FlashCards;
import com.Revature.Study_Buddy_Backend.Repository.FlashCardsRepo;
import com.Revature.Study_Buddy_Backend.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashCardsService {
    @Autowired
    private FlashCardsRepo flashCardsRepo;

    public List<FlashCards> getAllFlashCardsList() {
        return flashCardsRepo.findAll();
    }

    public List<FlashCards> getBysetId(Long setId) {
        return flashCardsRepo.findBySetId(setId);
    }

    public FlashCards getByfCardId(Long fCardId) {
        return flashCardsRepo.findById(fCardId).get();
    }

    public FlashCards addFlashCards(FlashCards flashCards) {
        return flashCardsRepo.save(flashCards);
    }

    public FlashCards updateFlashCards(FlashCards flashCards) {
        return flashCardsRepo.save(flashCards);
    }

    public void deleteByfCardId(Long fCardId) {
        flashCardsRepo.deleteById(fCardId);
    }
}
