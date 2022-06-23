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

    /*@ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "set_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Sets sets; //Sets need to be implemented*/

    private Long setId;

    public Long getNotesId() {
        return notesId;
    }

    public void setNotesId(Long notesId) {
        this.notesId = notesId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

   /* public Sets getSets() {
        return sets;
    }

    public void setSets(Sets sets) {
        this.sets = sets;
    }*/
}
