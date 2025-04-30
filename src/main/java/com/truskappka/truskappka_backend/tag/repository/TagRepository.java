package com.truskappka.truskappka_backend.tag.repository;

import com.truskappka.truskappka_backend.tag.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TagRepository extends JpaRepository<Tag, Long> {

    Optional<Tag> findByName(String name);
}
