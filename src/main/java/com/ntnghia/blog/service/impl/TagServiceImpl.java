package com.ntnghia.blog.service.impl;

import com.ntnghia.blog.entity.Tag;
import com.ntnghia.blog.repository.TagRepository;
import com.ntnghia.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagServiceImpl implements TagService {
    @Autowired
    TagRepository tagRepository;

    @Override
    public List<Tag> getAll() {
        return tagRepository.findAll();
    }

    @Override
    public Tag findById(int id) {
        return tagRepository.findById(id).get();
    }

    @Override
    public List<Tag> findByName(String name) {
        return null;
    }

    @Override
    public Tag saveTag(Tag tag) {
        return null;
    }

    @Override
    public Tag updateTag(int id, Tag tag) {
        return null;
    }

    @Override
    public void deleteTag(int id) {

    }
}
