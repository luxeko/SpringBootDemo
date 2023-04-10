package com.example.test.entities;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.Objects;

@Entity(name = "experiences")
@Table(name = "experiences", schema = "java_spring_demo", catalog = "")
public class ExperienceEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "user_id")
    private int userId;
    @Basic
    @Column(name = "company")
    @Size(min = 2, max = 255, message = "Size must be between 2 and 255")
    private String company;
    @Basic
    @Column(name = "position")
    @NotEmpty(message = "Company cannot be empty")
    private String position;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "start_time")
    private Date startTime;
    @Basic
    @Column(name = "end_time")
    private Date endTime;

    public ExperienceEntity() {
    }

    public ExperienceEntity(int id, int userId, String company, String position, String description, Date startTime, Date endTime) {
        this.id = id;
        this.userId = userId;
        this.company = company;
        this.position = position;
        this.description = description;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExperienceEntity that = (ExperienceEntity) o;
        return id == that.id && userId == that.userId && Objects.equals(company, that.company) && Objects.equals(position, that.position) && Objects.equals(description, that.description) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, company, position, description, startTime, endTime);
    }
}
