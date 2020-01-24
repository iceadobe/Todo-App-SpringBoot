package iceadobe.learning.spring.todo.bootstrap;

import iceadobe.learning.spring.todo.model.Note;
import iceadobe.learning.spring.todo.model.Tag;
import iceadobe.learning.spring.todo.repository.NoteRepository;
import iceadobe.learning.spring.todo.repository.TagRepository;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;

@Component
public class Bootstrap implements CommandLineRunner {

    @Autowired
    private NoteRepository noteRepository;
    @Autowired
    private TagRepository tagRepository;

    @Override
    public void run(String... args) throws Exception {
        Note notes[] = new Note[3];
        Tag tags[] = new Tag[3];

        for(int i=1; i<=3; i++) {
            tags[i-1] = new Tag("TAG " + i);
            notes[i-1] = new Note("NOTE " + i);
        }

        for(Tag tag: tags) tagRepository.save(tag);
        for(Note note: notes) noteRepository.save(note);

    }
}
