package com.example.test.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "user_role")
@Table(name = "user_role", schema = "java_spring_demo", catalog = "")
public class UserRoleEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private Long id;
//    @Basic
//    @Column(name = "role_id")
//    private int roleId;
//    @Basic
//    @Column(name = "user_id")
//    private int userId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserEntity usersByUserId;
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private RoleEntity rolesByRoleId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public int getRoleId() {
//        return roleId;
//    }
//
//    public void setRoleId(int roleId) {
//        this.roleId = roleId;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        UserRoleEntity that = (UserRoleEntity) o;
//        return id == that.id && roleId == that.roleId && userId == that.userId;
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, roleId, userId);
//    }
//
    public UserEntity getUsersByUserId() {
        return usersByUserId;
    }

    public void setUsersByUserId(UserEntity usersByUserId) {
        this.usersByUserId = usersByUserId;
    }

    public RoleEntity getRolesByRoleId() {
        return rolesByRoleId;
    }

    public void setRolesByRoleId(RoleEntity rolesByRoleId) {
        this.rolesByRoleId = rolesByRoleId;
    }
}
