package com.example.test.entities;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity(name = "educations")
@Table(name = "educations", schema = "java_spring_demo", catalog = "")
public class EducationEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "school")
    private String school;
    @Basic
    @Column(name = "course")
    private String course;
    @Basic
    @Column(name = "level")
    private String level;
    @Basic
    @Column(name = "GPA")
    private Double gpa;
    @Basic
    @Column(name = "start_time")
    private Timestamp startTime;
    @Basic
    @Column(name = "end_time")
    private Timestamp endTime;

    public EducationEntity() {
    }

    public EducationEntity(int id, int userId, String school, String course, String level, Double gpa, Timestamp startTime, Timestamp endTime) {
        this.id = id;
        this.userId = userId;
        this.school = school;
        this.course = course;
        this.level = level;
        this.gpa = gpa;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Double getGpa() {
        return gpa;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EducationEntity that = (EducationEntity) o;
        return id == that.id && userId == that.userId && Objects.equals(school, that.school) && Objects.equals(course, that.course) && Objects.equals(level, that.level) && Objects.equals(gpa, that.gpa) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, school, course, level, gpa, startTime, endTime);
    }
}
