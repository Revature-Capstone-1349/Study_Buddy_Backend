package com.Revature.Study_Buddy_Backend.Controller;

import com.Revature.Study_Buddy_Backend.Model.Notes;
import com.Revature.Study_Buddy_Backend.Model.Sets;
import com.Revature.Study_Buddy_Backend.Model.User;
import com.Revature.Study_Buddy_Backend.Service.NotesService;
import com.Revature.Study_Buddy_Backend.Service.SetsService;
import com.Revature.Study_Buddy_Backend.Service.UserService;
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
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<Notes>> getAllNotes() {
        return new ResponseEntity<>(notesService.getAllNotes(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Notes> getNotesById(@PathVariable("id")Long id){
        try{
            return new ResponseEntity<>(notesService.getNotesById(id), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping
    public ResponseEntity<Notes> addNotes(@RequestBody Notes notes){
        try{
            Sets sets = setsService.getBySetId(notes.getSetId());
            User user = userService.getUserById(notes.getUserId());
            if(sets.getUserId().equals(notes.getUserId()) && user != null){
                return new ResponseEntity<>(notesService.addNotes(notes),HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e){
            return new ResponseEntity<>(notesService.addNotes(notes), HttpStatus.OK);
        }
    }

    @PutMapping
    public ResponseEntity<Notes> updatesNotes(@RequestBody Notes notes){
        try{
            notesService.getNotesById(notes.getNotesId());
            return new ResponseEntity<>(notesService.updateNotes(notes), HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteNotes(@PathVariable("id")Long notesId){
        try {
            notesService.getNotesById(notesId);
            notesService.deleteNotes(notesId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/byUser/{userId}")
    public ResponseEntity<List<Notes>> getNotesByUserId(@PathVariable("userId") Long userId) {
        return new ResponseEntity<>(notesService.getNotesByUserIds(userId), HttpStatus.OK);
    }
}
