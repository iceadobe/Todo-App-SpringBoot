package iceadobe.learning.spring.todo.service;

import iceadobe.learning.spring.todo.model.Tag;
import iceadobe.learning.spring.todo.repository.TagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServiceImpl implements TagService {

    @Autowired
    private TagRepository tagRepository;

    @Override
    public Iterable<Tag> listAllTags() {
        return tagRepository.findAll();
    }

    @Override
    public Tag getTagById(Long id) {
        return tagRepository.findById(id).orElse(null);
    }

    @Override
    public Tag saveTag(Tag tag) {
        return tagRepository.save(tag);
    }
}
