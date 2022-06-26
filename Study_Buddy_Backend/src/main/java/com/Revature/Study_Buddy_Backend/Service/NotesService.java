package com.Revature.Study_Buddy_Backend.Service;

import com.Revature.Study_Buddy_Backend.Model.Notes;
import com.Revature.Study_Buddy_Backend.Repository.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class NotesService {

    @Autowired
    private NotesRepo notesRepo;

    public List<Notes>getAllNotes(){
        return notesRepo.findAll();
    }

    /*
    try catch find note, if not return null
    fix with repository method findBynotesId
     */
    public Notes getNotesById(Long id){
        Optional<Notes> optionalNotes = notesRepo.findById(id);
        return optionalNotes.orElse(null);
    }


    public Notes addNotes(Notes notes) {
        return notesRepo.save(notes);
    }

    //try catch find note, if not return null
    public Notes updateNotes(Notes notes) {
        Notes findNote = getNotesById(notes.getNotesId());
        if(findNote != null) {
            return notesRepo.save(notes);
        }
        return null;
    }

    //try catch find note, if not return null
    public void deleteNotes(Long notes){
        notesRepo.deleteById(notes);
    }

    public List<Notes> getNotesBySetIds(Long setId){
        return notesRepo.findBySetId(setId);
    }

    /*
    return a list of notes by set id
    with repository findBySetId
     */
}
