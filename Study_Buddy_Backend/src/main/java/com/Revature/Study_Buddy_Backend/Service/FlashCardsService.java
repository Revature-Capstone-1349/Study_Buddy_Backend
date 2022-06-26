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

    /*1. try catch if exist*/
    public List<FlashCards> getAllFlashCardsList() {
        return flashCardsRepo.findAll();
    }

    /*2.
    try catch if null or size is 0
    implement findBysetId

    call getAllFlashCardsList return list base off setId
     */
    public List<FlashCards> getBysetId(Long setId) {
        return flashCardsRepo.findBySetId(setId);
    }

    /*3. try catch if exist*/
    public FlashCards getByfCardId(Long fCardId) {
        return flashCardsRepo.findById(fCardId).get();
    }

    /*4. adding flashcards*/
    public FlashCards addFlashCards(FlashCards flashCards) {
        return flashCardsRepo.save(flashCards);
    }

    /*5. try catch find flash card if not exist return null*/
    public FlashCards updateFlashCards(FlashCards flashCards) {
        return flashCardsRepo.save(flashCards);
    }

    /*6. try catch find flash card if not exist return null*/
    public void deleteByfCardId(Long fCardId) {
        flashCardsRepo.deleteById(fCardId);
    }
}
