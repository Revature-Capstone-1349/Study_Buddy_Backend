package com.Revature.Study_Buddy_Backend.Controller;

import com.Revature.Study_Buddy_Backend.Model.Sets;
import com.Revature.Study_Buddy_Backend.Service.SetsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;
@AllArgsConstructor
@RequestMapping("/api/Sets")
@RestController
public class SetsResource {

    private SetsService setsService;
    @GetMapping("/listSets")
    public ResponseEntity<List<Sets>> getListSets() {
        return new ResponseEntity<>(setsService.getAllSets(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sets>addListSets(@RequestBody Sets newSets) {
        return new ResponseEntity<>(setsService.addSets(newSets), HttpStatus.OK);
    }

    //find if user exist then update, if not return null
    @PutMapping
    public ResponseEntity<Sets>updateListSets(@RequestBody Sets sets){
        return new ResponseEntity<>(setsService.updateSets(sets),HttpStatus.OK);
    }

    //find if the user exist, then delete them, if not return null
    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteListSets(@PathVariable("id")Long id){
        setsService.deleteSets(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //need to find a list of sets that shows all that belong to a user and all public set


}