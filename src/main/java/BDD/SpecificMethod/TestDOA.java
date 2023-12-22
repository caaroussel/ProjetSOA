package BDD.SpecificMethod;

import java.util.UUID;
public class TestDOA {
    public static void main(String[] args) {
        DatabaseAccess databaseAccess = new DatabaseAccess();

        MissionDOA missionDOA = new MissionDOA(databaseAccess);


        BDD.Mission mission = new BDD.Mission(UUID.randomUUID().toString(), UUID.randomUUID().toString(), BDD.Mission.Status.WAITING, "Opinion", "Goal", UUID.randomUUID().toString());
        System.out.println("test création de la mission \n");
        missionDOA.createMission(mission);
        System.out.println("test récupération de la mission\n");
        BDD.Mission testGet = missionDOA.getMission(mission.getId());

        System.out.println(testGet.getId());
    }
}
