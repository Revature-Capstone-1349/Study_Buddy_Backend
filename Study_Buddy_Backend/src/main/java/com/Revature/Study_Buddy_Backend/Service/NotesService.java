package com.Revature.Study_Buddy_Backend.Service;

import com.Revature.Study_Buddy_Backend.Model.Notes;
import com.Revature.Study_Buddy_Backend.Repository.NotesRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        return notesRepo.findById(id).get();
    }

    public Notes addNotes(Notes notes) {
        return notesRepo.save(notes);
    }

    //try catch find note, if not return null
    public Notes updateNotes(Notes notes) {
        return notesRepo.save(notes);
    }
    //try catch find note, if not return null
    public void deleteNotes(Long notesId){
        notesRepo.deleteBynotesId(notesId);
    }

    /*
    return a list of notes by set id
    with repository findBySetId
     */
}
