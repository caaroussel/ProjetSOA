package fr.insa.Avis.controller;

import fr.insa.Avis.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import BDD.SpecificMethod.AvisHelpSeekerDOA;
import BDD.SpecificMethod.AvisSuperUserDOA;
import BDD.SpecificMethod.AvisVolunteerDOA;
import BDD.SpecificMethod.NotifRefusDOA;
import fr.insa.Avis.object.*;





@RestController
@RequestMapping("/api/avis")
public class AvisRessource {
    @Autowired
    private RestTemplate restTemplate;
	
	//Avis HelpSeeker
	@PostMapping("/avishelpseeker")
	public void createAvisHelpSeeker(@RequestBody AvisHelpSeeker avisHelpSeeker) {
	    Mission missionStatus = restTemplate.getForObject("http://MissionMiscroservice/api/missionsressource/missions/" + avisHelpSeeker.getMissionId(), Mission.class);
	    if (missionStatus.getStatus() == Mission.Status.DONE) {
	        AvisHelpSeekerDOA.createAvisHelpSeeker(avisHelpSeeker);
	    } else {
	        throw new RuntimeException("Cannot create AvisHelpSeeker for a non-finalized mission");
	    }
	}
	@GetMapping("/avishelpseeker/{id}")
    public AvisHelpSeeker getAvisHelpSeeker(@PathVariable String id) {
        AvisHelpSeeker avisHelpSeeker = AvisHelpSeekerDOA.getAvisHelpSeeker(id);
        Mission missionStatus = restTemplate.getForObject("http://MissionMicroservice/api/missionsressource/missions/" +avisHelpSeeker.getMissionId(), Mission.class);
        System.out.println(missionStatus.getStatus());
        if (missionStatus.getStatus() == Mission.Status.DONE) {
            return avisHelpSeeker;
        } else {
        	
            throw new RuntimeException("Cannot get AvisHelpSeeker for a non-finalized mission");
        }
    }
    
    @PostMapping("/avishelpseeker/{rating}/{id}")
    public void updateAvisHelpSeeker(@PathVariable int rating, @PathVariable String id) {
        Mission missionStatus = restTemplate.getForObject("http://MissionMicroservice/api/missionsressource/missions/" +id, Mission.class);
        
        if (missionStatus.getStatus() == Mission.Status.DONE) {
            AvisHelpSeekerDOA.updateAvisHelpSeekerRating(rating, id);
        } else {

            throw new RuntimeException("Cannot update AvisHelpSeeker for a non-finalized mission");
        }
    }
    //Avis SuperUser
	@PostMapping("/avissuperuser")
	public void createAvisSuperUser(@RequestBody AvisSuperUser avisSuperUser) {
	    Mission missionStatus = restTemplate.getForObject("http://MissionMicroservice/api/missionsressource/missions/" + avisSuperUser.getMissionId(), Mission.class);
	    if (missionStatus.getStatus() == Mission.Status.DONE) {
	    	AvisSuperUserDOA.createAvisSuperUser(avisSuperUser);
	    } else {
	        throw new RuntimeException("Cannot create AvisHelpSeeker for a non-finalized mission");
	    }
		
	}
    @GetMapping("/avissuperuser/{id}")
    public AvisSuperUser getAvisSuperUser(@PathVariable String id) {
       AvisSuperUser avisSuperUser = AvisSuperUserDOA.getAvisSuperUser(id);
       System.out.println("MISSION ID : " + avisSuperUser.getMissionId());
       Mission missionStatus = restTemplate.getForObject("http://MissionMicroservice/api/missionsressource/missions/" +avisSuperUser.getMissionId(), Mission.class);
       if(missionStatus.getStatus() == Mission.Status.REFUSED) {
    	   System.out.println("The mission is refused, you can't get AvisSuperUser"); 
       }
       if (missionStatus.getStatus() == Mission.Status.DONE){
    	   return avisSuperUser;
    } else {
    	throw new RuntimeException("Cannot get AvisSuperUser for a non-finalized mission");
    }
    }
    @PostMapping("/avissuperuser/{commentaire}/{id}")
    public void updateAvisSuperUser(@PathVariable String commentaire, @PathVariable String id) {
        Mission missionStatus = restTemplate.getForObject("http://MissionMicroservice/api/missionsressource/missions/" +id, Mission.class);
        if(missionStatus.getStatus() == Mission.Status.DONE) {
        	AvisSuperUserDOA.updateSuperUserCommentaire(commentaire, id);
        } else {
        	throw new RuntimeException("Cannot update AvisSuperUser for a non-finalized mission");
        }
    	
    }
    
    //Avis Volunteer
	@PostMapping("/avisvolunteer")
	public void createAvisVolunteer(@RequestBody AvisVolunteer avisVolunteer) {
	    Mission missionStatus = restTemplate.getForObject("http://MissionMicroservice/api/missionsressource/missions/" + avisVolunteer.getMissionId(), Mission.class);
	    if (missionStatus.getStatus() == Mission.Status.DONE) {
	    	AvisVolunteerDOA.createAvisVolunteer(avisVolunteer);
	    } else {
	        throw new RuntimeException("Cannot create AvisHelpSeeker for a non-finalized mission");
	    }
		
	}
    @GetMapping("/avisvolunteer/{id}")
    public AvisVolunteer getAvisVolunteer(@PathVariable String id) {
    	AvisVolunteer avisVolunteer = AvisVolunteerDOA.getAvisVolunteer(id);
        Mission missionStatus = restTemplate.getForObject("http://MissionMicroservice/api/missionsressource/missions/" +avisVolunteer.getMissionId(), Mission.class);
        if (missionStatus.getStatus() == Mission.Status.DONE) {
        	return avisVolunteer;
        } else {
        	throw new RuntimeException("Cannot get AvisVolunteer for a non-finalized mission");
        }
    }
    
    //Notification de refus
    @PostMapping("/notifrefus")
    public void createNotifRefus(@RequestBody NotifRefus notifRefus) {
         Mission missionStatus = restTemplate.getForObject("http://MissionMicroservice/api/missionsressource/missions/" +notifRefus.getIdMission(), Mission.class);
         if (missionStatus.getStatus() == Mission.Status.REFUSED) {
        	 NotifRefusDOA.createNotifRefus(notifRefus);
         } else {
        	 throw new RuntimeException("Can't create a NotifRefus : the mission is not refused");
         }
    	
        
    }
    
    @GetMapping("/notifrefus/{id}")
    public NotifRefus getNotifRefus(@PathVariable String id) {
    	NotifRefus notifRefus = NotifRefusDOA.getNotifRefus(id);
    	Mission missionStatus = restTemplate.getForObject("http://MissionMicroservice/api/missionsressource/missions/" +notifRefus.getIdMission(), Mission.class);
    	if(missionStatus.getStatus() == Mission.Status.REFUSED) {
    		return notifRefus; 
    	} else {
    		throw new RuntimeException("Error : This mission was not refused");
    	}
    }
}

    
