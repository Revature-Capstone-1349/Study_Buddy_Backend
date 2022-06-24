package com.Revature.Study_Buddy_Backend.Repository;


import com.Revature.Study_Buddy_Backend.Model.Sets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetsRepo extends JpaRepository <Sets, Long>{
    Sets findBySetId(Long setId);
    List<Sets> findsetNameByUserID(Long userId);
    void deleteSets(Long setsId);
    List<Sets> byUserId(Long userId);


}