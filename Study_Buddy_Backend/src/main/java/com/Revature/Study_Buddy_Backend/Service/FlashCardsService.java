package com.Revature.Study_Buddy_Backend.Service;

import com.Revature.Study_Buddy_Backend.Repository.FlashCardsRepo;
import com.Revature.Study_Buddy_Backend.Service.impl.FlashCardsServiceImpl;
import com.Revature.Study_Buddy_Backend.Model.FlashCards;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//response
//dto
import java.util.List;

@Service
public interface FlashCardsService{
    List<FlashCards> getAllFlashCards();

    public FlashCards getFlashCardsbyid (Long id);

    FlashCards addFlashCards (FlashCards flashCards);

    FlashCards updateFlashCards (FlashCards flashCards);

    void deleteFlashCards (Long fCardId);
}
