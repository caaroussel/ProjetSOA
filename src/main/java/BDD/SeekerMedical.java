package BDD;

public class SeekerMedical extends HelpSeeker {
    private String SuperUser;

    private SeekerMedical(String name, String Miss, String id, String SuperUser) {
        super(name, Miss, id);
        this.SuperUser = SuperUser;
    }

    // Getters
    public String getSuperUser() {
        return SuperUser;
    }
    // Setters
    public void setSuperUser(String SuperUser) {
        this.SuperUser = SuperUser;
    }

}
