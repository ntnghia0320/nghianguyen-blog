package com.ntnghia.nghianguyenblog.controller;

import com.ntnghia.nghianguyenblog.entity.Tag;
import com.ntnghia.nghianguyenblog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/blog/tags")
public class TagController {
    @Autowired
    private TagService tagService;

    @GetMapping()
    public List<Tag> getAll() {
        return tagService.getAll();
    }

    @GetMapping("/{id}")
    public Tag getById(@PathVariable int id) {
        return tagService.findById(id);
    }

    @GetMapping("/search")
    public List<Tag> getByName(@RequestParam String name) {
        return tagService.findByName(name);
    }

    @PostMapping()
    public Tag post(@Valid @RequestBody Tag task) {
        return tagService.saveTag(task);
    }

    @PutMapping("/{id}")
    public Tag put(@PathVariable int id, @Valid @RequestBody Tag task) {
        return tagService.updateTag(id, task);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        tagService.deleteTag(id);
    }
}
