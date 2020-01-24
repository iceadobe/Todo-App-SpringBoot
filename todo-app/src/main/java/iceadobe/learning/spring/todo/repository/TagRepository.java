package iceadobe.learning.spring.todo.repository;

import iceadobe.learning.spring.todo.model.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends CrudRepository<Tag, Long> {

}
