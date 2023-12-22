package BDD;

public class SupMedical extends SuperUser{
    private String SuperUser;

    private SupMedical(String name, String id, String SuperUser) {
        super(name, id);
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
