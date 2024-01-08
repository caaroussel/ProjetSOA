package fr.insa.MissionMicroservice.controller;


import BDD.SpecificMethod.*;
import fr.insa.MissionMicroservice.model.*;


import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/missionsressource")
public class MissionRessource {

    @GetMapping("/missions")
    public List<Mission> getAllMissions() {
        return MissionDOA.getAllMissions();
    }

    @GetMapping("/missions/{id}")
    public Mission getMission(@PathVariable String id) {
        return MissionDOA.getMission(id);
    }

    @GetMapping("/missions/status/{id}")
    public Mission.Status getMissionStatus(@PathVariable String id) {
        return MissionDOA.getStatus(id);
    }

    @PostMapping("/missions")
    public void addMission(@RequestBody Mission mission) {
        MissionDOA.createMission(mission);
    }

    @PutMapping("/missions/{id}/seeker")
    public void updateMissionSeeker(@RequestBody String seeker, @PathVariable String id) {
        MissionDOA.updateMissionSeeker(seeker, id);
    }

    @PutMapping("/missions/{id}/vol")
    public void updateMissionVol(@RequestBody String vol, @PathVariable String id) {
        MissionDOA.updateMissionVol(vol, id);
    }

    @PutMapping("/missions/{id}/status")
    public void updateMissionStatus(@RequestBody Mission.Status status, @PathVariable String id) {
        MissionDOA.updateMissionStatus(status, id);
    }

    @PutMapping("/missions/{id}/opinion")
    public void updateMissionOpinion(@RequestBody String opinion, @PathVariable String id) {
        MissionDOA.updateMissionOpinion(opinion, id);
    }




    
}