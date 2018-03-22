package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Programs {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String courseName;
    private String courseDescription;
    private String courseCriteria;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUser> userApplied;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUser> userApproved;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<AppUser> userCourse;

    @ManyToMany(mappedBy = "userPrograms")
    private Set<AppUser> programUsers;

    @ManyToMany(mappedBy = "recommendedCourses")
    private Set<AppUser> recommendCourses;

    public void addUserApplied(AppUser user) {this.userApplied.add(user);}
    public void addUserApproved(AppUser user) {this.userApproved.add(user);}
    public void addUserInCourse(AppUser user) {this.userCourse.add(user);}

    public void removeUserApplied(AppUser user) {this.userApplied.remove(user);}
    public void removeUserApproved(AppUser user) {this.userApproved.remove(user);}
    public void removeUserInCourse(AppUser user) {this.userCourse.remove(user);}

    public Programs() {
        this.userApplied = new HashSet<>();
        this.userApproved = new HashSet<>();
        this.userCourse = new HashSet<>();
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

    public String getCourseCriteria() {
        return courseCriteria;
    }

    public void setCourseCriteria(String courseCriteria) {
        this.courseCriteria = courseCriteria;
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


    public Set<AppUser> getRecommendCourses() {
        return recommendCourses;
    }

    public void setRecommendCourses(Set<AppUser> recommendCourses) {
        this.recommendCourses = recommendCourses;
    }

    public Set<AppUser> getProgramUsers() {
        return programUsers;
    }

    public void setProgramUsers(Set<AppUser> programUsers) {
        this.programUsers = programUsers;
    }

    public Set<AppUser> getUserCourse() {
        return userCourse;
    }

    public void setUserCourse(Set<AppUser> userCourse) {
        this.userCourse = userCourse;
    }
}
