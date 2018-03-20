package com.example.demo;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    private String criteriaQuestion;
    private String criteriaDescription;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<UserCriteria> criteriaCriteria;


    @ManyToMany(mappedBy = "courseCriteria")
    private Set<Programmes> programmesCriteria;

    public void removeUserCriteria(UserCriteria criteria) {
        this.criteriaCriteria.remove(criteria);
    }
    public void addUserCriteria(UserCriteria criteria) {
        this.criteriaCriteria.add(criteria);
    }

    public Criteria() {
        this.criteriaCriteria = new HashSet<>();
        this.programmesCriteria = new HashSet<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCriteriaQuestion() {
        return criteriaQuestion;
    }

    public void setCriteriaQuestion(String criteriaQuestion) {
        this.criteriaQuestion = criteriaQuestion;
    }

    public String getCriteriaDescription() {
        return criteriaDescription;
    }

    public void setCriteriaDescription(String criteriaDescription) {
        this.criteriaDescription = criteriaDescription;
    }


    public Set<Programmes> getProgrammesCriteria() {
        return programmesCriteria;
    }

    public void setProgrammesCriteria(Set<Programmes> programmesCriteria) {
        this.programmesCriteria = programmesCriteria;
    }

    public Set<UserCriteria> getCriteriaCriteria() {
        return criteriaCriteria;
    }

    public void setCriteriaCriteria(Set<UserCriteria> criteriaCriteria) {
        this.criteriaCriteria = criteriaCriteria;
    }
}
