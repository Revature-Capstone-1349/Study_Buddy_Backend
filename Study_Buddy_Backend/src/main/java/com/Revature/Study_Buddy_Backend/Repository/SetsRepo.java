package com.Revature.Study_Buddy_Backend.Repository;


import com.Revature.Study_Buddy_Backend.Model.Sets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetRepo extends JpaRepository <Sets, Long>{
    Sets findBySetId(Long setId);
    List<Sets> findsetNameByUserID(Long userId);



}
