package com.example.test.repositories;

import com.example.test.entities.ExperienceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienceRepository extends JpaRepository<ExperienceEntity, Integer> {
    @Query("select e from experiences e where concat(e.id, e.company, e.description, e.position) like %?1%")
    public List<ExperienceEntity> findByQuery(String keyword);
}
