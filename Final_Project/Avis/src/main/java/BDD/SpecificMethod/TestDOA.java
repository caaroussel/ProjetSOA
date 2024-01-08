package BDD.SpecificMethod;

/*import java.util.List;
import java.util.UUID;

import BDD.models.Mission;
public class TestDOA {
    public static void main(String[] args) {
        DatabaseAccess databaseAccess = new DatabaseAccess();
        //Test Mission

        MissionDOA missionDOA = new MissionDOA(databaseAccess);
        BDD.models.Mission mission = new BDD.models.Mission(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BDD.models.Mission.Status.REFUSED, "Opinion", "Goal", UUID.randomUUID().toString());
        System.out.println("test création de la mission \n");
        missionDOA.createMission(mission);
        System.out.println("test récupération de la mission\n");
        BDD.models.Mission testGet = missionDOA.getMission(mission.getId());
        System.out.println(testGet.getStatus());
        List<Mission> testGetAll = missionDOA.getAllMissions();
        for (Mission value : testGetAll) {
            System.out.println(value.getStatus());
        }
*/

        //Test Volunteer
        /*
        BDD.Volunteer volunteer = new BDD.Volunteer("test", "test", UUID.randomUUID().toString());
        System.out.println("test création du volontaire \n");
        VolunteerDOA volunteerDOA = new VolunteerDOA(databaseAccess);
        volunteerDOA.createVolunteer(volunteer);
        System.out.println("test récupération du volontaire \n");
        BDD.Volunteer testGet = volunteerDOA.getVolunteer(volunteer.getId());
        System.out.println(testGet.getId());
         */

        //Test HelpSeeker
        /*
        BDD.HelpSeeker helpSeeker = new BDD.HelpSeeker("test", "test", UUID.randomUUID().toString());
        System.out.println("test création du demandeur \n");
        HelpSeekerDOA helpSeekerDOA = new HelpSeekerDOA(databaseAccess);
        helpSeekerDOA.createHelpSeeker(helpSeeker);
        System.out.println("test récupération du demandeur \n");
        BDD.HelpSeeker testGet = helpSeekerDOA.getHelpSeeker(helpSeeker.getId());
        System.out.println(testGet.getId());
        */

        //Test SuperUser
        /*
        BDD.SuperUser superUser = new BDD.SuperUser("test", UUID.randomUUID().toString());
        System.out.println("test création du superUser \n");
        SuperUserDOA superUserDOA = new SuperUserDOA(databaseAccess);
        superUserDOA.createSuperUser(superUser);
        System.out.println("test récupération du superUser \n");
        BDD.SuperUser testGet = superUserDOA.getSuperUser(superUser.getId());
        System.out.println(testGet.getId());
         */

        //Test SeekerMedical
        /*
        BDD.SeekerMedical seekerMedical = new BDD.SeekerMedical("test", "test", UUID.randomUUID().toString(), UUID.randomUUID().toString());
        System.out.println("test création du SeekerMedical \n");
        SeekerMedicalDOA seekerMedicalDOA = new SeekerMedicalDOA(databaseAccess);
        seekerMedicalDOA.createSeekerMedical(seekerMedical);
        System.out.println("test récupération du SeekerMedical \n");
        BDD.SeekerMedical testGet = seekerMedicalDOA.getSeekerMedical(seekerMedical.getId());
        System.out.println(testGet.getId());
        */

        //Test SupMedical
        /*
        BDD.SupMedical supMedical = new BDD.SupMedical("test", UUID.randomUUID().toString(), UUID.randomUUID().toString());
        System.out.println("test création du SupMedical \n");
        SupMedicalDOA supMedicalDOA = new SupMedicalDOA(databaseAccess);
        supMedicalDOA.createSupMedical(supMedical);
        System.out.println("test récupération du SupMedical \n");
        BDD.SupMedical testGet = supMedicalDOA.getSupMedical(supMedical.getId());
        System.out.println(testGet.getId());
        */
  //  }
//}
