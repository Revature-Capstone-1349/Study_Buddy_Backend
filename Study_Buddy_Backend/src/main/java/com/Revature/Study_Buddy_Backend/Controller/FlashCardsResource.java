package com.Revature.Study_Buddy_Backend.Controller;

import com.Revature.Study_Buddy_Backend.Model.FlashCards;
import com.Revature.Study_Buddy_Backend.Service.FlashCardsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/flashcards")
public class FlashCardsResource {
    @Autowired
    private FlashCardsService flashCardsService;

    //  Get FlashCardsList
    @GetMapping
    public ResponseEntity<List<FlashCards>> FlashCardsList() {
        return new ResponseEntity<>(flashCardsService.getAllFlashCardsList(), HttpStatus.OK);
    }

    //getting flash card by card id
    @GetMapping("/getSet/{fCardId}")
    public ResponseEntity<List<FlashCards>> getAllFlashCardsBySetId(@PathVariable("fCardId") Long id) {
        return new ResponseEntity<>(flashCardsService.getBysetId(id), HttpStatus.OK);
    }

    //try catch null return/ no content
    @GetMapping("/{fCardId}")
    public ResponseEntity<FlashCards> getFlashCardsById(@PathVariable("fCardId") Long id) {
        try {
            return new ResponseEntity<>(flashCardsService.getByfCardId(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //Get FlashCardsList
    @PostMapping
    public ResponseEntity<FlashCards> addFlashCards(@RequestBody FlashCards flashCards) {
        return new ResponseEntity<>(flashCardsService.addFlashCards(flashCards), HttpStatus.OK);
    }

    //try catch null return/ no content
    @PutMapping
    public ResponseEntity<FlashCards> updateFlashCards(@RequestBody FlashCards flashCards) {
        try {
            FlashCards findCard = flashCardsService.getByfCardId(flashCards.getFCardId());
            return new ResponseEntity<>(flashCardsService.updateFlashCards(flashCards), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    //try catch null return/ no content
    @DeleteMapping("/{fCardId}")
    public ResponseEntity<?> deleteByFCardId(@PathVariable("fCardId") Long fCardId) {
        try {
            flashCardsService.getByfCardId(fCardId);
            flashCardsService.deleteByfCardId(fCardId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}
