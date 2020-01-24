package iceadobe.learning.spring.todo.controller;

import iceadobe.learning.spring.todo.model.Note;
import iceadobe.learning.spring.todo.model.Tag;
import iceadobe.learning.spring.todo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping(path = "/notes", produces = MediaType.APPLICATION_JSON_VALUE)
public class NoteController {

    @Autowired
    private NoteService noteService;

    @GetMapping
    public Iterable<Note> getAllNotes() {
        return noteService.listAllNotes();
    }

    @GetMapping(path = "/{id}")
    public Note getNoteById(@PathParam("id") Long id) {
        return noteService.getNoteById(id);
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public Note createNote(@RequestBody Note note) {
        return noteService.saveNote(note);
    }

    @PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public Note addTagsToNote(@PathParam("id") Long id, @RequestBody List<Tag> tags) throws Exception {
        return noteService.addTags(id, tags);
    }

    @PutMapping
    public Note updateNote(Note note) throws Exception {
        return noteService.updateNote(note);
    }

    @DeleteMapping
    public boolean deleteNote(Long id) {
        return noteService.removeNote(id);
    }


}
