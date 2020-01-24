package iceadobe.learning.spring.todo.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table
@EqualsAndHashCode
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String body;

    @ManyToMany
    @JoinTable(
            name = "association",
            joinColumns = @JoinColumn(name = "associated_tags"),
            inverseJoinColumns = @JoinColumn(name = "associated_notes")
    )
    private List<Tag> tagList;

    public Note(String body) {
        this.body = body;
    }

    public Note(String body, List<Tag> tags) {
        this.body = body;
        this.tagList = tags;
    }

    public void addTag(Tag tag) {
        tagList.add(tag);
    }

}
