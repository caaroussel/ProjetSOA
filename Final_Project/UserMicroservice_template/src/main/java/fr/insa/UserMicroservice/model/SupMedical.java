package fr.insa.UserMicroservice.model;

public class SupMedical extends SuperUser{
    private String Seek;

    public SupMedical(String name, String id, String Seek) {
        super(name, id);
        this.Seek = Seek;
    }

    // Getters
    public String getSeek() {
        return Seek;
    }
    // Setters
    public void setSeek(String Seek) {
        this.Seek = Seek;
    }
}
