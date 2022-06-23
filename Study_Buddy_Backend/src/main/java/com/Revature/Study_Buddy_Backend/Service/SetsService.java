package com.Revature.Study_Buddy_Backend.Service;

import com.Revature.Study_Buddy_Backend.Model.Sets;
import com.Revature.Study_Buddy_Backend.Repository.SetRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class SetService {
    @Autowired
    private SetRepo setRepo;

    public List<Sets> getallSetsName(){
        return allSetsame;
    }

    public Sets addSets(Sets setSets) {
        return setRepo.save(setSets);
    }

    public Sets update(Sets updateSets){
        return setRepo.save(updateSets);
        
    }
    public Sets deleteSets;(Sets deleteSets){

    }
}