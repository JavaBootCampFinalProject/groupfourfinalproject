package com.example.demo;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    AppRoleRepository appRoleRepository;

    @Autowired
    AppUserRepository appUserRepository;

    @Autowired
    ProgrammesRepository programmesRepository;

    @Autowired
    CriteriaReposiotry  criteriaReposiotry;

    @Autowired
    UserCriteriaRepository userCriteriaRepository;


    @Override
    public void run(String... strings) throws Exception {

        AppRole role = new AppRole();
        role.setRoleName("USER");
        appRoleRepository.save(role);

        role = new AppRole();
        role.setRoleName("ADMIN");
        appRoleRepository.save(role);

        Criteria criteria = new Criteria();
        criteria.setCriteriaDescription("English Language Learner");
        criteria.setCriteriaQuestion("Are you currently learning English?");
        criteriaReposiotry.save(criteria);

        criteria = new Criteria();
        criteria.setCriteriaDescription("Unemployed with barriers to employment");
        criteria.setCriteriaQuestion("Are you currently unemployed with barriers to employment?");
        criteriaReposiotry.save(criteria);

        criteria = new Criteria();
        criteria.setCriteriaDescription("Underemployed with barriers to better employment");
        criteria.setCriteriaQuestion("Are you currently underemployed with barriers to better employment?");
        criteriaReposiotry.save(criteria);

        criteria = new Criteria();
        criteria.setCriteriaDescription("Be comfortable using computers for everyday purposes");
        criteria.setCriteriaQuestion("Are you comfortable using computers for everyday purposes?");
        criteriaReposiotry.save(criteria);

        criteria = new Criteria();
        criteria.setCriteriaDescription("Have a strong interest in an IT career");
        criteria.setCriteriaQuestion("Do you have a strong intrest in an IT career?");
        criteriaReposiotry.save(criteria);

        criteria = new Criteria();
        criteria.setCriteriaDescription("Have a high school diploma or GED");
        criteria.setCriteriaQuestion("Do you have a high school diploma or GED?");
        criteriaReposiotry.save(criteria);

        criteria = new Criteria();
        criteria.setCriteriaDescription("Be legally authorized to work in the U.S.");
        criteria.setCriteriaQuestion("Are you legally authorized to work in the U.S.?");
        criteriaReposiotry.save(criteria);

        criteria = new Criteria();
        criteria.setCriteriaDescription("Basic understanding of object oriented programing");
        criteria.setCriteriaQuestion("Do you have a basic understanding of object oriented programming?");
        criteriaReposiotry.save(criteria);

        criteria = new Criteria();
        criteria.setCriteriaDescription("Previous experience with an object-oriented language");
        criteria.setCriteriaQuestion("Do you have previous experience with an object-oriented language?");
        criteriaReposiotry.save(criteria);

        criteria = new Criteria();
        criteria.setCriteriaDescription("Major in Computer Science/Information Systems");
        criteria.setCriteriaQuestion("Do you have a major in Computer Science/Information Systems?");
        criteriaReposiotry.save(criteria);

        criteria = new Criteria();
        criteria.setCriteriaDescription("Graduated within the last six years");
        criteria.setCriteriaQuestion("Did you graduate within the last six years?");
        criteriaReposiotry.save(criteria);

        criteria = new Criteria();
        criteria.setCriteriaDescription("Currently earning 42,000 or less");
        criteria.setCriteriaQuestion("Are you currently earning less then 42,000?"); //Maybe change to allow a sliding scale
        criteriaReposiotry.save(criteria);



        // A few users
        // Admin 1
        AppUser user = new AppUser();
        user.setUsername("John");
        user.setPassword("password1");
        user.setFullName("John Doe");
        user.setUserEmail("g1@gmail.com");
        appUserRepository.save(user);
        user.addRole(appRoleRepository.findAppRoleByRoleName("USER"));
        appUserRepository.save(user);
        // Admin 2
        user = new AppUser();
        user.setUsername("Jacob");
        user.setPassword("password2");
        user.setFullName("Jacob Smith");
        user.setUserEmail("g2@gmail.com");
        appUserRepository.save(user);
        user.addRole(appRoleRepository.findAppRoleByRoleName("ADMIN"));
        appUserRepository.save(user);
        // User 1
        user = new AppUser();
        user.setUsername("Joe");
        user.setPassword("password3");
        user.setFullName("Joe Blow");
        user.setUserEmail("g3@gmail.com");
        appUserRepository.save(user);
        user.addRole(appRoleRepository.findAppRoleByRoleName("USER"));
        appUserRepository.save(user);
        // User 2
        user = new AppUser();
        user.setUsername("Jane");
        user.setPassword("password4");
        user.setFullName("Jane Pane");
        user.setUserEmail("g4@gmail.com");
        appUserRepository.save(user);
        user.addRole(appRoleRepository.findAppRoleByRoleName("USER"));
        appUserRepository.save(user);

        // User 3
        user = new AppUser();
        user.setUsername("Jake");
        user.setPassword("password5");
        user.setFullName("Jake English");
        user.setUserEmail("g5@gmail.com");
        appUserRepository.save(user);
        user.addRole(appRoleRepository.findAppRoleByRoleName("USER"));
        appUserRepository.save(user);

        // User 4
        user = new AppUser();
        user.setUsername("John");
        user.setPassword("password6");
        user.setFullName("John Snow");
        user.setUserEmail("g6@gmail.com");
        appUserRepository.save(user);
        user.addRole(appRoleRepository.findAppRoleByRoleName("USER"));
        appUserRepository.save(user);

        //User Criteria

        UserCriteria userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(1)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);

        userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(2)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);

        userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(3)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);

        userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(4)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);

        userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(5)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);

        userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(6)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);

        userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(7)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);

        userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(8)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);

        userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(9)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);

        userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(10)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);

        userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(11)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);

        userCriteria = new UserCriteria();
        userCriteria.setCriteriaState(true);
        userCriteria.addcCriteria(criteriaReposiotry.findOne(new Long(12)));
        userCriteria.addUser(appUserRepository.findOne(new Long(3)));
        userCriteriaRepository.save(userCriteria);


        // Course 1
        Programmes course = new Programmes();
        course.setCourseName("Tech Hire");
        course.setCourseDescription("fillerDescription");
        course.addCourseCriteria(criteriaReposiotry.findOne(new Long(1)));
        programmesRepository.save(course);
        course.addUserApplied(appUserRepository.findOne(new Long(4)));
        course.addUserApproved(appUserRepository.findOne( new Long(3)));
        course.addUserInCourse(appUserRepository.findOne(new Long(5)));
        programmesRepository.save(course);
        //Course 2
        course = new Programmes();
        course.setCourseName("Java Boot Camp");
        course.setCourseDescription("fillerDescription2");
        course.addCourseCriteria(criteriaReposiotry.findOne(new Long(2)));
        programmesRepository.save(course);
        }
}
