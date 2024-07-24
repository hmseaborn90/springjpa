package org.springjpa.springjpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springjpa.springjpa.entities.Content;


@Repository
public interface ContentRepository extends JpaRepository<Content, Integer> {
    public Content findById(int id);
}
