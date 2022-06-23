package com.Revature.Study_Buddy_Backend.Model;
import javax.persistence.*;
import java.util.List;

    @Entity
    @Table(name = "FlashCards")
public class FlashCards {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name= "flash_card_id")
        private Long fcardId;
        @Column(name= "term")
        private String term;
        @Column(name= "definition")
        private String def;
        @Column(name= "field")
        private String Field;
        @ManyToOne (fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name= "set_id", nulltable = false)
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

        public Long getFcardId() {
            return fcardId;
        }

        public void setFcardId(Long fcardId) {
            this.fcardId = fcardId;
        }

        public Long getSetId() {
            return setId;
        }

        public void setSetId(Long setId) {
            this.setId = setId;
        }

        public String getTerm() {
            return term;
        }

        public void setTerm(String term) {
            this.term = term;
        }

        public String getDef() {
            return def;
        }

        public void setDef(String def) {
            this.def = def;
        }

        public String getField() {
            return Field;
        }

        public void setField(String field) {
            Field = field;
        }
    }
