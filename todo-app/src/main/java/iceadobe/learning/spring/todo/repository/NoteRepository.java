package iceadobe.learning.spring.todo.repository;

import iceadobe.learning.spring.todo.model.Note;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteRepository extends CrudRepository<Note, Long> {

}
