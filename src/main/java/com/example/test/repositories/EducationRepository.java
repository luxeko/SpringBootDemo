package com.example.test.repositories;

import com.example.test.entities.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EducationRepository extends JpaRepository<EducationEntity, Integer> {
    @Query("SELECT e from educations e where concat(e.id, e.school, e.course, e.level, e.gpa) like %?1%")
    public List<EducationEntity> findByQuery(String keyword);

//    public List<EducationEntity> findAllBySchoolOrCourseOrLevelLike(String school, String course, String level);
}
