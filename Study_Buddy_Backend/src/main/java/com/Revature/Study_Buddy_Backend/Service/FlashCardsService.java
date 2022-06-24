package com.Revature.Study_Buddy_Backend.Service;

import com.Revature.Study_Buddy_Backend.Model.FlashCards;
import com.Revature.Study_Buddy_Backend.Repository.FlashCardsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FlashCardsService{
    @Autowired
    private FlashCardsRepo flashCardsRepo;
    public List<FlashCards> getAllFlashCards(){
        return flashCardsRepo.findAll();
    }

    // try catch if exist
    public FlashCards getByfCardId (Long id) {
        return flashCardsRepo.findByfCardId(id);
    }
    public FlashCards addFlashCards (FlashCards flashCards){
        return flashCardsRepo.save(flashCards);
    }

    //try catch find flash card if not exist return null
    public FlashCards updateFlashCards (FlashCards flashCards){
        return flashCardsRepo.save(flashCards);
    }

    //try catch find flash card if not exist return null
    public void deleteByfCardId (Long fCardId) {
        flashCardsRepo.deleteByfCardId(fCardId);
    }

    /*
    try catch if null or size is 0
    implement findBysetId

    call getAllFlashCards return list base off setId
     */


    /*
    try catch if null or size is 0
    implement findBysetId

    user's set first then other's set
    view by the userId and privacy is "public"
    return new list
     */
}
