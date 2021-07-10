package com.ntnghia.nghianguyenblog.service;

import com.ntnghia.nghianguyenblog.entity.Tag;

import java.util.List;

public interface TagService {
    List<Tag> getAll();

    Tag findById(int id);

    List<Tag> findByName(String name);

    Tag saveTag(Tag tag);

    Tag updateTag(int id, Tag tag);

    void deleteTag(int id);
}
