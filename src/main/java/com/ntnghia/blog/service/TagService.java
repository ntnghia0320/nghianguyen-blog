package com.ntnghia.blog.service;

import com.ntnghia.blog.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAll();

    Tag findById(int id);

    List<Tag> findByName(String name);

    Tag saveTag(Tag tag);

    Tag updateTag(int id, Tag tag);

    void deleteTag(int id);
}
