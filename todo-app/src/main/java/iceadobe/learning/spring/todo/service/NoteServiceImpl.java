package iceadobe.learning.spring.todo.service;

import iceadobe.learning.spring.todo.model.Note;
import iceadobe.learning.spring.todo.model.Tag;
import iceadobe.learning.spring.todo.repository.NoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {

    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Iterable<Note> listAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note getNoteById(Long id) {
        return noteRepository.findById(id).orElse(null);
    }

    @Override
    public Note saveNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public boolean removeNote(Long id) {
        noteRepository.deleteById(id);
        if (noteRepository.findById(id).isPresent()) {
            return true;
        }
        return false;
    }

    @Override
    public Note updateNote(Note note) throws Exception {
        Optional<Note> noteinDB = noteRepository.findById(note.getId());
        if (noteinDB.isPresent() && noteinDB.get().getId() == note.getId()) {
            return noteRepository.save(note);
        } else {
            throw new Exception("Unable to find Note with ID: " + note.getId());
        }
    }

    @Override
    public Note addTags(Long id, List<Tag> tags) throws Exception {
        Optional<Note> noteinDB = noteRepository.findById(id);
        if (noteinDB.isPresent()) {
            Note note = noteinDB.get();
            for (Tag tag : tags) note.addTag(tag);
            return noteRepository.save(note);
        } else {
            throw new Exception("Unable to find Note with ID: " + id);
        }
    }
}
