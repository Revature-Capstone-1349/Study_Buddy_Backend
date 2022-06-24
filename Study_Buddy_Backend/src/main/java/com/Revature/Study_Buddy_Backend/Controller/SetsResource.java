package com.Revature.Study_Buddy_Backend.Controller;

import com.Revature.Study_Buddy_Backend.Model.Sets;
import com.Revature.Study_Buddy_Backend.Service.SetsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RequestMapping("/api/Sets")
@RestController
public class SetsResource {

    private SetsService setsService;

    @GetMapping("/listSets")
    public ResponseEntity<List<Sets>> getListSets() {
        return new ResponseEntity<>(setsService.getallSets(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Sets>addListSets(@RequestBody Sets newSets) {
        return new ResponseEntity<>(setsService.addSets(newSets), HttpStatus.OK);
    }

    public ResponseEntity<Sets>updateListSets(Sets sets){
        return new ResponseEntity<>(setsService.update(sets),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    private ResponseEntity<?> deleteListSets(@PathVariable("id")Long id){
        setsService.deleteSets(id);
        return new ResponseEntity<>(HttpStatus.OK);

    }

}