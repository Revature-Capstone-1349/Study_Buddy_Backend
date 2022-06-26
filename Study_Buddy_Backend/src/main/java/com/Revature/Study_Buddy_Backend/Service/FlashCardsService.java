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

    /*1. get all flashcards list*/
    public List<FlashCards> getAllFlashCardsList() {
        return flashCardsRepo.findAll();
    }

    /*2.
    get by set id
     */
    public List<FlashCards> getBysetId(Long setId) {
        return flashCardsRepo.findBySetId(setId);
    }

    /*3. get flashcards by id*/
    public FlashCards getByfCardId(Long fCardId) {
        return flashCardsRepo.findById(fCardId).get();
    }

    /*4. add flashcards*/
    public FlashCards addFlashCards(FlashCards flashCards) {
        return flashCardsRepo.save(flashCards);
    }

    /*5. update flashcards*/
    public FlashCards updateFlashCards(FlashCards flashCards) {
        return flashCardsRepo.save(flashCards);
    }

    /*6. delete flashcards*/
    public void deleteByfCardId(Long fCardId) {
        flashCardsRepo.deleteById(fCardId);
    }
}
