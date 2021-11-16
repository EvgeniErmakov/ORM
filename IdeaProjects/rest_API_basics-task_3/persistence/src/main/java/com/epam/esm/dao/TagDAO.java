package com.epam.esm.dao;

import com.epam.esm.entity.Tag;

import java.util.Optional;

public interface TagDAO extends BaseDAO<Tag, Long> {

    Optional<Tag> findByName(String name);

    Tag findOrCreate(Tag tag);

    Tag findPopular();
}
