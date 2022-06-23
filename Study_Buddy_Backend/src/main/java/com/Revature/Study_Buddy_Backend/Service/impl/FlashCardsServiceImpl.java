package com.Revature.Study_Buddy_Backend.Service.impl;

import com.Revature.Study_Buddy_Backend.Model.FlashCards;
import com.Revature.Study_Buddy_Backend.Repository.FlashCardsRepo;
import com.Revature.Study_Buddy_Backend.Service.FlashCardsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlashCardsServiceImpl implements FlashCardsService{
    private FlashCardsRepo flashCardsRepo;
    public List<FlashCards> getAllFlashCards(){
        return flashCardsRepo.findAll();
    }
    public FlashCards getFlashCardsbyid (Long id)

    {
        return flashCardsRepo.findByfcardId(id);
    }
    public FlashCards addFlashCards (FlashCards flashCards){
        return flashCardsRepo.save(flashCards);
    }
    public FlashCards updateFlashCards (FlashCards flashCards){
        return flashCardsRepo.save(flashCards);
    }

    public void deleteFlashCards (Long fcardid) {
        flashCardsRepo.deleteFlashCards(fcardid);
    }
}
