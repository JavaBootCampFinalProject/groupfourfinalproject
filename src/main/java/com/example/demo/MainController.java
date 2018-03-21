package com.example.demo;

import com.sun.org.apache.xpath.internal.operations.Mod;
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

    @GetMapping("/criteria")
    public String getCriteriaForm(Model model, Authentication authentication) {
        model.addAttribute("appUserCriteriaform", appUserRepository.findAppUserByUsername(authentication.getName()));
        return "criteriaform";
    }

    @PostMapping("/criteria")
    public String processCriteriaForm(@Valid @ModelAttribute("appUserCriteriaform") AppUser appuser, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "criteriaform";
        } else {
            appUserRepository.save(appuser);
        }
        return "recommendedlist";
    }

    @RequestMapping("/recommendedlist")
    public String recomendedList() {
        //For current user, run a check method for each course to see what they qualify for
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

    @RequestMapping("/approve/{courseId}/{studentId}") //Need to pass in a course and a student
    public String approvalPage(@PathVariable("courseId") Programs program, @PathVariable("studentId") AppUser appUser, Model model, Authentication authentication) {
        program.addUserApproved(appUser);
        program.removeUserApplied(appUser);
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

    @RequestMapping("/userAccept/{courseId}")
    public String acceptApprovalPage(@PathVariable("courseId") Programs program, Model model, Authentication authentication) {
        program.addUserInCourse(appUserRepository.findAppUserByUsername(authentication.getName()));
        program.removeUserApproved(appUserRepository.findAppUserByUsername(authentication.getName()));
        programsRepository.save(program);
        model.addAttribute("user", appUserRepository.findAppUserByUsername(authentication.getName()));
        return "welcome to course";

    }

}