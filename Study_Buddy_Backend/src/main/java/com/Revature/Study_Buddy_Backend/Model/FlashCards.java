package com.Revature.Study_Buddy_Backend.Model;
import lombok.Data;
import org.springframework.web.bind.annotation.*;
import javax.persistence.*;
import java.util.List;


//    @Entity
//    @Data
//    @Table(name = "FlashCards")
public class FlashCards {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
       
        private Long fCardId;
       
        private String term;
        
        private String def;

        //@ManyToOne (fetch = FetchType.LAZY, optional = false)
        //@JoinColumn(name= "setId", nullable = false)
        private Long setId;

        public FlashCards() {

        }
        public FlashCards (Long fCardId, Long setId, String term, String def){
            this.fCardId = fCardId;
            this.setId = setId;
            this.term = term;
            this.def = def;
        }

    }
