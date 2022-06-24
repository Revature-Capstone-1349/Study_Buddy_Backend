package com.Revature.Study_Buddy_Backend.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Notes {
    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private Long notesId;

    private String title;
    private String cat;
    private String content;
    private Long setId;

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "set_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Sets sets; //Sets need to be implemented*/


}
