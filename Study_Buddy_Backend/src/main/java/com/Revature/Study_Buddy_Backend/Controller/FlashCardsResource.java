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
    @Autowired
    private FlashCardsService flashCardsService;
    @GetMapping("/FlashCards")
    public ResponseEntity<List<FlashCards>>getAllfcard() {
        return new ResponseEntity<>(flashCardsService.getAllFlashCards(),HttpStatus.OK);
    }

    @GetMapping("FlashCards/{id}")
    public ResponseEntity<FlashCards> getFlashCardsbyid(@PathVariable("id") Long id) {
        return new ResponseEntity<>(flashCardsService.getFlashCardsbyid(id),HttpStatus.OK);
    }

    @PostMapping("/FlashCards")
    public ResponseEntity <FlashCards> addFlashCards (@RequestBody FlashCards flashCards) {
        return new ResponseEntity<>(flashCardsService.addFlashCards(flashCards), HttpStatus.OK);
    }
    @PutMapping("FlashCards/{id}")
    public ResponseEntity <FlashCards> updateFlashCards (@RequestBody FlashCards flashCards){
        return new ResponseEntity<>(flashCardsService.updateFlashCards(flashCards),HttpStatus.OK);
    }

    @DeleteMapping("FlashCards/{id}")
    public ResponseEntity deleteFlashCards (@PathVariable ("id")Long fcardid){
         flashCardsService.deleteFlashCards(fcardid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
