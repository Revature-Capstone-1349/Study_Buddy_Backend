package com.Revature.Study_Buddy_Backend.Controller;

import com.Revature.Study_Buddy_Backend.Model.Notes;
import com.Revature.Study_Buddy_Backend.Service.NotesService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Notes")
public class NotesResource {

    @Autowired
    private NotesService notesService;

    @GetMapping
    public ResponseEntity<List<Notes>> getAllNotes() {
        return new ResponseEntity<>(notesService.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notes>getNotesById(@PathVariable("id")Long id){
        return new ResponseEntity<>(notesService.getNotesById(id),HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Notes>addNotes(@RequestBody Notes notes){
        return new ResponseEntity<>(notesService.addNotes(notes),HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Notes>getNotes(@RequestBody Notes notes){
        return new ResponseEntity<>(notesService.updateNotes(notes),HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNotes(@PathVariable("id")Long notesId){
        notesService.deleteNotes(notesId);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
