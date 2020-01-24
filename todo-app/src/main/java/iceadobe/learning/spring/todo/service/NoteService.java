package iceadobe.learning.spring.todo.service;

import iceadobe.learning.spring.todo.model.Note;
import iceadobe.learning.spring.todo.model.Tag;

import java.util.List;

public interface NoteService {

    Iterable<Note> listAllNotes();
    Note getNoteById(Long id);
    Note saveNote(Note note);
    boolean removeNote(Long id);
    Note updateNote(Note note) throws Exception;
    Note addTags(Long id, List<Tag> tags) throws Exception;
}
