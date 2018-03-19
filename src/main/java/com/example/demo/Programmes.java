package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Programmes {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String courseName;
    private String courseDescription;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUser> userApplied;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUser> userApproved;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUser> userInCourse;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Criteria> courseCriteria;

    public void addUserApplied(AppUser user) {this.userApplied.add(user);}
    public void addUserApproved(AppUser user) {this.userApproved.add(user);}
    public void addUserInCourse(AppUser user) {this.userInCourse.add(user);}
    public void addCourseCriteria(Criteria criteria) {this.courseCriteria.add(criteria);}

    public void removeUserApplied(AppUser user) {this.userApplied.remove(user);}
    public void removeUserApproved(AppUser user) {this.userApproved.remove(user);}
    public void removeUserInCourse(AppUser user) {this.userInCourse.remove(user);}
    public void removeCourseCriteria(Criteria criteria) {this.courseCriteria.remove(criteria);}

    public Programmes() {
        this.userApplied = new HashSet<>();
        this.userApproved = new HashSet<>();
        this.userInCourse = new HashSet<>();
        this.courseCriteria = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseDescription() {
        return courseDescription;
    }

    public void setCourseDescription(String courseDescription) {
        this.courseDescription = courseDescription;
    }


    public Set<AppUser> getUserApplied() {
        return userApplied;
    }

    public void setUserApplied(Set<AppUser> userApplied) {
        this.userApplied = userApplied;
    }

    public Set<AppUser> getUserApproved() {
        return userApproved;
    }

    public void setUserApproved(Set<AppUser> userApproved) {
        this.userApproved = userApproved;
    }

    public Set<AppUser> getUserInCourse() {
        return userInCourse;
    }

    public void setUserInCourse(Set<AppUser> userInCourse) {
        this.userInCourse = userInCourse;
    }

    public Set<Criteria> getCourseCriteria() {
        return courseCriteria;
    }

    public void setCourseCriteria(Set<Criteria> courseCriteria) {
        this.courseCriteria = courseCriteria;
    }
}
