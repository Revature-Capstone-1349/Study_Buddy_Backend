package com.Revature.Study_Buddy_Backend.Controller;

import com.Revature.Study_Buddy_Backend.Model.Notes;
import com.Revature.Study_Buddy_Backend.Service.NotesService;
import com.Revature.Study_Buddy_Backend.Service.SetsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/api/Notes")
public class NotesResource {

    private NotesService notesService;
    private SetsService setsService;

    @GetMapping
    public ResponseEntity<List<Notes>> getAllNotes() {
        return new ResponseEntity<>(notesService.getAllNotes(), HttpStatus.OK);
    }

    /*
    try catch null return/ no content
     */
    @GetMapping("/{id}")
    public ResponseEntity<Notes> getNotesById(@PathVariable("id")Long id){
        try{
            Notes notes = notesService.getNotesById(id);
            return new ResponseEntity<>(notes, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Notes> addNotes(@RequestBody Notes notes){
        return new ResponseEntity<>(notesService.addNotes(notes),HttpStatus.OK);
    }

    /*
    try catch null return/ no content
     */
    @PutMapping
    public ResponseEntity<Notes> updatesNotes(@RequestBody Notes notes){
        Notes findNotes = notesService.getNotesById(notes.getNotesId());
        if(findNotes != null){
            return new ResponseEntity<>(notesService.updateNotes(notes), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    /*
    try catch null return/ no content
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNotes(@PathVariable("id")Long notesId){
        try {
            notesService.deleteNotes(notesId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        //notesService.deleteNotes(notesId);
        //return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/bySet/{id}")
    public ResponseEntity<List<Notes>> getNotesBySetId(@PathVariable("id") Long setId) {
        return new ResponseEntity<>(notesService.getNotesBySetIds(setId), HttpStatus.OK);
    }
}
