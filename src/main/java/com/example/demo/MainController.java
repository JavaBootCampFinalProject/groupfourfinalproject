package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class MainController {
    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    ProgramsRepository programsRepository;


    @RequestMapping("/")
    public String index() {return "index";}

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/appuserform")
    public String getUserForm(Model model) {
        model.addAttribute("appuser", new AppUser());
        return "appuserform";
    }

    @PostMapping("/appuserform")
    public String processAppUserForm(@Valid @ModelAttribute("appuser") AppUser appuser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "appuserform";
        } else {
            model.addAttribute("message", "User Account Successfully Created");
            appUserRepository.save(appuser);
        }
        return "login";
    }

    @GetMapping("/getcriteria")
    public String getCriteriaForm(Model model, Authentication authentication) {
        model.addAttribute("appUserCriteriaform", appUserRepository.findAppUserByUsername(authentication.getName()));
        return "criteriaform";
    }

    @PostMapping("/processcriteria")
    public String processCriteriaForm(@Valid @ModelAttribute("appUserCriteriaform") AppUser appuser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "criteriaform";
        } else {
            appUserRepository.save(appuser);
        }
        return "recommendedlist";
    }

    @RequestMapping("/recommendedlist")
    public String recomendedList(Model model, Authentication authentication) {
        AppUser appUser = appUserRepository.findAppUserByUsername(authentication.getName());
        appUser.clearRecommend();
        if (appUser.isFutureCriteriaMet()){appUser.addRecommend(programsRepository.findOne(new Long(1)));}
        if (appUser.isFutureCriteriaMet()){appUser.addRecommend(programsRepository.findOne(new Long(2)));}
        model.addAttribute("user", appUser);
        return "recommendedlist";
    }

    @RequestMapping("/apply/{courseId}")
    public String confirmationPage(@PathVariable("courseId") Programs program, Model model, Authentication authentication) {
        program.addUserApplied(appUserRepository.findAppUserByUsername(authentication.getName()));
        programsRepository.save(program);
        return "confirmationpage";
    }

    @RequestMapping("/applicantslist/{courseId}")
    public String applicantList(@PathVariable("courseId") Programs program,Model model) {
        model.addAttribute("applicants", program.getUserApplied());
        return "applicantlist";
    }

    @RequestMapping("/studentlist/{courseId}")
    public String studentList(@PathVariable("courseId") Programs program,Model model) {
        model.addAttribute("students", program.getUserCourse());
        return "coursestudents";
    }

    @RequestMapping("/approve/{courseId}/{studentId}") //Need to pass in a course and a student
    public String approvalPage(@PathVariable("courseId") Programs program, @PathVariable("studentId") AppUser appUser, Model model, Authentication authentication) {
        program.addUserApproved(appUser);
        program.removeUserApplied(appUser);
        appUser.addCourse(program);
        appUserRepository.save(appUser);
        programsRepository.save(program);
        model.addAttribute("user", appUser);
        return "approvalconfirmation";
    }

    @RequestMapping("/programindex")
    public String programIndex(Model model){
        model.addAttribute("courses", programsRepository.findAll());
        return "index2";
    }

    @RequestMapping("/programslist/{courseId}")
    public String programList(@PathVariable("courseId") Programs program, Model model){
        model.addAttribute("program", program);
        return "programslist";
    }

    @RequestMapping("/userAccept/{courseId}") //Email method needs to go in here
    public String acceptApprovalPage(@PathVariable("courseId") Programs program, Model model, Authentication authentication) {
        AppUser appUser = appUserRepository.findAppUserByUsername(authentication.getName());
        program.addUserInCourse(appUser);
        program.removeUserApproved(appUser);
        appUser.removeCourse(program);
        appUserRepository.save(appUser);
        programsRepository.save(program);
        model.addAttribute("user", appUser);
        return "welcome to course";

    }

    @GetMapping("/getadminform")
    public String getAdminForm(Model model) {
        AppUser appUser = new AppUser();
        appUser.addRole(appRoleRepository.findAppRoleByRoleName("ADMIN"));
        appUserRepository.save(appUser);
        model.addAttribute("appuser", appUser);
        return "adminform";
    }

    @PostMapping("/processadminform")
    public String processAdminForm(@Valid @ModelAttribute("adminUser") AppUser appuser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "appuserform";
        } else {
            model.addAttribute("message", "User Account Successfully Created");
            appUserRepository.save(appuser);
        }
        return "login";
    }

    @PostMapping("/currentuserpage")
    public String currentUserPage(Model model, Authentication authentication){
        model.addAttribute("user", appUserRepository.findAppUserByUsername(authentication.getName()));
        return "userpage";
    }
}