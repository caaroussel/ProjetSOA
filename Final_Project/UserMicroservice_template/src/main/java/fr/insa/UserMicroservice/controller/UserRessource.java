package fr.insa.UserMicroservice.controller;

import BDD.SpecificMethod.*;
import fr.insa.UserMicroservice.model.HelpSeeker;
import fr.insa.UserMicroservice.model.SeekerMedical;
import fr.insa.UserMicroservice.model.SupMedical;
import fr.insa.UserMicroservice.model.SuperUser;
import fr.insa.UserMicroservice.model.Volunteer;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRessource {


    // Volunteers
    @GetMapping("/volunteers")
    public List<Volunteer> getAllVolunteers() {
        return VolunteerDOA.getAllVolunteers();
    }

    @GetMapping("/volunteers/{id}")
    public Volunteer getVolunteer(@PathVariable String id) {
        return VolunteerDOA.getVolunteer(id);
    }

    @PostMapping("/volunteers")
    public void addVolunteer(@RequestBody Volunteer volunteer) {
        VolunteerDOA.createVolunteer(volunteer);
    }


    // HelpSeekers
    @GetMapping("/helpseekers")
    public List<HelpSeeker> getAllHelpSeekers() {
        return HelpSeekerDOA.getAllHelpSeekers();
    }

    @GetMapping("/helpseekers/{id}")
    public HelpSeeker getHelpSeekerById(@PathVariable String id) {
        return HelpSeekerDOA.getHelpSeeker(id);
    }

    @PostMapping("/helpseekers")
    public void addHelpSeeker(@RequestBody HelpSeeker helpSeeker) {
        HelpSeekerDOA.createHelpSeeker(helpSeeker);
    }


    // SuperUsers
    @GetMapping("/superusers")
    public List<SuperUser> getAllSuperUsers() {
        return SuperUserDOA.getAllSuperUsers();
    }

    @GetMapping("/superusers/{id}")
    public SuperUser getSuperUser(@PathVariable String id) {
        return SuperUserDOA.getSuperUser(id);
    }

    @PostMapping("/superusers")
    public void addSuperUser(@RequestBody SuperUser superUser) {
        SuperUserDOA.createSuperUser(superUser);
    }


    // SupMedicals
    @GetMapping("/supermedicals")
    public List<SupMedical> getAllSuperMedicals() {
        return SupMedicalDOA.getAllSupMedical();
    }

    @GetMapping("/supermedicals/{id}")
    public SupMedical getSuperMedical(@PathVariable String id) {
        return SupMedicalDOA.getSupMedical(id);
    }

    @PostMapping("/supermedicals")
    public void addSuperMedical(@RequestBody SupMedical superMedical) {
        SupMedicalDOA.createSupMedical(superMedical);
    }

    @PostMapping("/supermedicals/{id}/{seek}")
    public void updateSuperMedicalSeek(@PathVariable String id, @PathVariable String seek) {
        SupMedicalDOA.updateSeek(id, seek);
    }


    // SeekerMedicals
    @GetMapping("/seekermedicals")
    public List<SeekerMedical> getAllSeekerMedicals() {
        return SeekerMedicalDOA.getAllSeekMedical();
    }

    @GetMapping("/seekermedicals/{id}")
    public SeekerMedical getSeekerMedical(@PathVariable String id) {
        return SeekerMedicalDOA.getSeekerMedical(id);
    }

    @PostMapping("/seekermedicals")
    public void addSeekerMedical(@RequestBody SeekerMedical seekerMedical) {
        SeekerMedicalDOA.createSeekerMedical(seekerMedical);
    }

    @PostMapping("/seekermedicals/{id}/{sup}")
    public void updateSeekerMedicalSup(@PathVariable String id, @PathVariable String sup) {
        SeekerMedicalDOA.updateSeekerMedicalSup(id, sup);
    }





    
}

