package com.example.demo;


import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotEmpty
    private String username;

    @NotEmpty
    private String password;

    private String userEmail;

    private String fullName;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppRole> roles;

    @ManyToMany(mappedBy = "userApplied")
    private Set<Programmes> applied;

    @ManyToMany(mappedBy = "userApproved")
    private Set<Programmes> approved;

    @ManyToMany(mappedBy = "userInCourse")
    private Set<Programmes> inCourse;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Criteria> userCriteria;

    public void removeRole(AppRole role) {
        this.roles.remove(role);
    }
    public void addRole(AppRole role) {
        this.roles.add(role);
    }

    public void removeUserCriteria(Criteria criteria) {
        this.userCriteria.remove(criteria);
    }
    public void addUserCriteria(Criteria criteria) {
        this.userCriteria.add(criteria);
    }


    public AppUser() {
        this.roles = new HashSet<>();
        this.applied = new HashSet<>();
        this.approved = new HashSet<>();
        this.inCourse = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Set<AppRole> getRoles() {
        return roles;
    }

    public void setRoles(Set<AppRole> roles) {
        this.roles = roles;
    }


    public Set<Criteria> getUserCriteria() {
        return userCriteria;
    }

    public void setUserCriteria(Set<Criteria> userCriteria) {
        this.userCriteria = userCriteria;
    }

    public Set<Programmes> getApplied() {
        return applied;
    }

    public void setApplied(Set<Programmes> applied) {
        this.applied = applied;
    }

    public Set<Programmes> getApproved() {
        return approved;
    }

    public void setApproved(Set<Programmes> approved) {
        this.approved = approved;
    }

    public Set<Programmes> getInCourse() {
        return inCourse;
    }

    public void setInCourse(Set<Programmes> inCourse) {
        this.inCourse = inCourse;
    }
}
