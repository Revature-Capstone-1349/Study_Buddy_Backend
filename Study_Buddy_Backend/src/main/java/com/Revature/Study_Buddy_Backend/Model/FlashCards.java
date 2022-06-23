package com.Revature.Study_Buddy_Backend.Model;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import javax.persistence.*;
import java.util.List;


    @Entity
    @Data
    @Table(name = "FlashCards")
public class FlashCards {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
       
        private Long fcardId;
       
        private String term;
        
        private String def;
        
        private String Field;
        //@ManyToOne (fetch = FetchType.LAZY, optional = false)
        //@JoinColumn(name= "setId", nullable = false)
        private Long setId;

        public FlashCards() {

        }
        public FlashCards (Long fcardId, Long setId, String term, String def, String Field){
            this.fcardId = fcardId;
            this.setId = setId;
            this.term = term;
            this.def = def;
            this.Field = Field;
        }

    }
