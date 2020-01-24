package iceadobe.learning.spring.todo.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "TAGS")
@Data
@NoArgsConstructor
public class Tag {
    @Column(name = "ID")
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "TAG")
    public String name;

    @ManyToMany(mappedBy = "tagList")
    private List<Note> notesList;

    public Tag(String name) {
        this.name = name;
    }

    public void removeTaggingFromNote(Long id) {
        notesList = notesList.stream()
                        .filter(note -> note.getId() != id)
                        .collect(Collectors.toList());
    }
}
