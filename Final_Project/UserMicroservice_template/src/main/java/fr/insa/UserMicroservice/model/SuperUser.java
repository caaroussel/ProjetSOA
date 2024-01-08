package fr.insa.UserMicroservice.model;

public class SuperUser {
    private String name;
    private String id;

    // constructeur
    public SuperUser(String name, String id) {
        this.name = name;
        this.id = id;
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setId(String id) {
        this.id = id;
    }
    // Getters
    public String getName() {
        return name;
    }
    public String getId() {
        return id;
    }
}
