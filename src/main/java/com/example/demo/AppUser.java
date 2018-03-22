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

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Programs> userPrograms;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Programs> recommendedCourses;

    @ManyToMany(mappedBy = "userApplied")
    private Set<Programs> applied;

    @ManyToMany(mappedBy = "userApproved")
    private Set<Programs> approved;

    @ManyToMany(mappedBy = "userCourse")
    private Set<Programs> program;

    public void clearRecommend(){this.recommendedCourses.clear();}

    public  void removeRecomend(Programs program){this.recommendedCourses.remove(program);}
    public  void removeCourse(Programs program){this.program.remove(program);}
    public void removeRole(AppRole role) {
        this.roles.remove(role);
    }

    public  void addRecommend(Programs program){this.recommendedCourses.add(program);}
    public  void addCourse(Programs program){this.program.add(program);}
    public void addRole(AppRole role) {
        this.roles.add(role);
    }

    private boolean criteriaEnglish;
    private boolean criteriaUnemployed;
    private boolean criteriaUnderEmployed;
    private boolean criteriaComputerComfortable;
    private boolean criteriaItInterest;
    private boolean criteriaDiploma;
    private boolean criteriaWorkInUs;
    private boolean criteriaUnderstandOOP;
    private boolean criteriaExperienceOOP;
    private boolean criteriaCompSciMajor;
    private boolean criteriaRecentGraduate;
    private boolean criteriaCurrentEarnings;

    private boolean techCriteriaMet;
    private boolean futureCriteriaMet;


    public AppUser() {
        this.roles = new HashSet<>();
        this.applied = new HashSet<>();
        this.approved = new HashSet<>();
        this.program = new HashSet<>();
        this.criteriaCompSciMajor = false;
        this.criteriaComputerComfortable = false;
        this.criteriaCurrentEarnings = false;
        this.criteriaDiploma = false;
        this.criteriaEnglish = false;
        this.criteriaExperienceOOP = false;
        this.criteriaItInterest = false;
        this.criteriaRecentGraduate = false;
        this.criteriaUnderstandOOP = false;
        this.criteriaUnderEmployed = false;
        this.criteriaUnemployed = false;
        this.criteriaWorkInUs = false;
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

    public Set<Programs> getApplied() {
        return applied;
    }

    public void setApplied(Set<Programs> applied) {
        this.applied = applied;
    }

    public Set<Programs> getApproved() {
        return approved;
    }

    public void setApproved(Set<Programs> approved) {
        this.approved = approved;
    }

    public boolean isCriteriaEnglish() {
        return criteriaEnglish;
    }

    public void setCriteriaEnglish(boolean criteriaEnglish) {
        this.criteriaEnglish = criteriaEnglish;
    }

    public boolean isCriteriaUnemployed() {
        return criteriaUnemployed;
    }

    public void setCriteriaUnemployed(boolean criteriaUnemployed) {
        this.criteriaUnemployed = criteriaUnemployed;
    }

    public boolean isCriteriaUnderEmployed() {
        return criteriaUnderEmployed;
    }

    public void setCriteriaUnderEmployed(boolean criteriaUnderEmployed) {
        this.criteriaUnderEmployed = criteriaUnderEmployed;
    }

    public boolean isCriteriaComputerComfortable() {
        return criteriaComputerComfortable;
    }

    public void setCriteriaComputerComfortable(boolean criteriaComputerComfortable) {
        this.criteriaComputerComfortable = criteriaComputerComfortable;
    }

    public boolean isCriteriaItInterest() {
        return criteriaItInterest;
    }

    public void setCriteriaItInterest(boolean criteriaItInterest) {
        this.criteriaItInterest = criteriaItInterest;
    }

    public boolean isCriteriaDiploma() {
        return criteriaDiploma;
    }

    public void setCriteriaDiploma(boolean criteriaDiploma) {
        this.criteriaDiploma = criteriaDiploma;
    }

    public boolean isCriteriaWorkInUs() {
        return criteriaWorkInUs;
    }

    public void setCriteriaWorkInUs(boolean criteriaWorkInUs) {
        this.criteriaWorkInUs = criteriaWorkInUs;
    }

    public boolean isCriteriaUnderstandOOP() {
        return criteriaUnderstandOOP;
    }

    public void setCriteriaUnderstandOOP(boolean criteriaUnderstandOOP) {
        this.criteriaUnderstandOOP = criteriaUnderstandOOP;
    }

    public boolean isCriteriaExperienceOOP() {
        return criteriaExperienceOOP;
    }

    public void setCriteriaExperienceOOP(boolean criteriaExperienceOOP) {
        this.criteriaExperienceOOP = criteriaExperienceOOP;
    }

    public boolean isCriteriaCompSciMajor() {
        return criteriaCompSciMajor;
    }

    public void setCriteriaCompSciMajor(boolean criteriaCompSciMajor) {
        this.criteriaCompSciMajor = criteriaCompSciMajor;
    }

    public boolean isCriteriaRecentGraduate() {
        return criteriaRecentGraduate;
    }

    public void setCriteriaRecentGraduate(boolean criteriaRecentGraduate) {
        this.criteriaRecentGraduate = criteriaRecentGraduate;
    }

    public boolean isCriteriaCurrentEarnings() {
        return criteriaCurrentEarnings;
    }

    public void setCriteriaCurrentEarnings(boolean criteriaCurrentEarnings) {
        this.criteriaCurrentEarnings = criteriaCurrentEarnings;
    }

    public boolean isTechCriteriaMet() {
        if (!this.isCriteriaEnglish()){return false;}
        if (!this.isCriteriaUnemployed()){return false;}
        if (!this.isCriteriaUnderEmployed()){return false;}
        if (!this.isCriteriaComputerComfortable()){return false;}
        if (!this.isCriteriaItInterest()){return false;}
        if (!this.isCriteriaDiploma()){return false;}
        if (!this.isCriteriaWorkInUs()){return false;}
        return true;
    }

    public boolean isFutureCriteriaMet() {
        if (!this.isCriteriaExperienceOOP()) {return false;}
        if (!this.isCriteriaUnderstandOOP()) {return false;}
        if (!this.isCriteriaCompSciMajor()) {return false;}
        if (!this.isCriteriaRecentGraduate()) {return false;}
        if (!this.isCriteriaCurrentEarnings()) {return false;}
        if (!this.isCriteriaWorkInUs()) {return false;}
        return true;
    }

    public Set<Programs> getRecommendedCourses() {
        return recommendedCourses;
    }

    public void setRecommendedCourses(Set<Programs> recommendedCourses) {
        this.recommendedCourses = recommendedCourses;
    }

    public Set<Programs> getProgram() {
        return program;
    }

    public void setProgram(Set<Programs> program) {
        this.program = program;
    }

    public void setTechCriteriaMet(boolean techCriteriaMet) {
        this.techCriteriaMet = techCriteriaMet;
    }

    public void setFutureCriteriaMet(boolean futureCriteriaMet) {
        this.futureCriteriaMet = futureCriteriaMet;
    }

    public Set<Programs> getUserPrograms() {
        return userPrograms;
    }

    public void setUserPrograms(Set<Programs> userPrograms) {
        this.userPrograms = userPrograms;
    }
}
