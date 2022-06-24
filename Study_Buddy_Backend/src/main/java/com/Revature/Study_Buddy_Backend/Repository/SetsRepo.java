package com.Revature.Study_Buddy_Backend.Repository;


import com.Revature.Study_Buddy_Backend.Model.Sets;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SetsRepo extends JpaRepository <Sets, Long>{
    Sets findBysetId(Long setId);
    List<Sets> findByuserId(Long userId);
    void deleteBysetId(Long setsId);



}