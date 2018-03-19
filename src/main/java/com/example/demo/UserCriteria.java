package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class UserCriteria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private Boolean criteriaState;
    private int criteriaValue;

    @ManyToMany(mappedBy = "userCriteria")
    private Set<AppUser> studentCriteria;

    @ManyToMany(mappedBy = "criteriaCriteria")
    private Set<Criteria> cCriteria;

    public UserCriteria() {
        this.studentCriteria = new HashSet<>();
        this.cCriteria = new HashSet<>();
    }

    public void addcCriteria(Criteria criteria) {this.cCriteria.add(criteria);}
    public void addUser(AppUser user) {this.studentCriteria.add(user);}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Boolean getCriteriaState() {
        return criteriaState;
    }

    public void setCriteriaState(Boolean criteriaState) {
        this.criteriaState = criteriaState;
    }

    public int getCriteriaValue() {
        return criteriaValue;
    }

    public void setCriteriaValue(int criteriaValue) {
        this.criteriaValue = criteriaValue;
    }

    public Set<AppUser> getStudentCriteria() {
        return studentCriteria;
    }

    public void setStudentCriteria(Set<AppUser> studentCriteria) {
        this.studentCriteria = studentCriteria;
    }

    public Set<Criteria> getcCriteria() {
        return cCriteria;
    }

    public void setcCriteria(Set<Criteria> cCriteria) {
        this.cCriteria = cCriteria;
    }
}
