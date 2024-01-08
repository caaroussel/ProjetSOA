package fr.insa.UserMicroservice.model;

public class Volunteer {
    private String name;
    private String Miss;
    private String id;

    // constructeur
    public Volunteer(String name, String Miss, String id) {
        this.name = name;
        this.Miss = Miss;
        this.id = id;
    }
    // Setters
    public void setName(String name) {
        this.name = name;
    }
    public void setMiss(String Miss) {
        this.Miss = Miss;
    }
    public void setId(String id) {
        this.id = id;
    }
    // Getters
    public String getName() {
        return name;
    }
    public String getMiss() {
        return Miss;
    }
    public String getId() {
        return id;
    }
}
