package iceadobe.learning.spring.todo.service;

import iceadobe.learning.spring.todo.model.Tag;

public interface TagService {
    Iterable<Tag> listAllTags();

    Tag getTagById(Long id);

    Tag saveTag(Tag tag);
}
