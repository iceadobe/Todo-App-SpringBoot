package iceadobe.learning.spring.todo.controller;

import iceadobe.learning.spring.todo.model.Tag;
import iceadobe.learning.spring.todo.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/tags", produces = MediaType.APPLICATION_JSON_VALUE)
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping
    public Iterable<Tag> listAllTags() {
        return tagService.listAllTags();
    }

}
