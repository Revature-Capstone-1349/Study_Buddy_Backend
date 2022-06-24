package com.Revature.Study_Buddy_Backend.Controller;

import com.Revature.Study_Buddy_Backend.Model.FlashCards;
import com.Revature.Study_Buddy_Backend.Service.FlashCardsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import java.util.List;

@RestController
@RequestMapping("/api/flashcards")
public class FlashCardsResource {

    private FlashCardsService flashCardsService;
    @GetMapping
    public ResponseEntity<List<FlashCards>>getAllFlashCards() {
        return new ResponseEntity<>(flashCardsService.getAllFlashCards(),HttpStatus.OK);
    }

    @GetMapping("{fCardId}")
    public ResponseEntity<FlashCards> getFlashCardsById(@PathVariable("fCardId") Long id) {
        return new ResponseEntity<>(flashCardsService.getByfCardId(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<FlashCards> addFlashCards (@RequestBody FlashCards flashCards) {
        return new ResponseEntity<>(flashCardsService.addFlashCards(flashCards), HttpStatus.OK);
    }
    @PutMapping
    public ResponseEntity<FlashCards> updateFlashCards (@RequestBody FlashCards flashCards){
        return new ResponseEntity<>(flashCardsService.updateFlashCards(flashCards),HttpStatus.OK);
    }

    @DeleteMapping("{fCardId}")
    public ResponseEntity<?> deleteByFCardId (@PathVariable ("fCardId")Long fCardId){
         flashCardsService.deleteByfCardId(fCardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
