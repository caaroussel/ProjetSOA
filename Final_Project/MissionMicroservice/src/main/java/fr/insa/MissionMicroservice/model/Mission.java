package fr.insa.MissionMicroservice.model;


public class Mission {

	public enum Status {
        WAITING,
        APPROVED,
        DONE,
        REFUSED
    }

    private String vol;
    private String seek;
    private Status status;
    private String opinion;
    private String goal;
    private String id;

    // constructeur
    public Mission(String vol, String seek, Status status, String opinion, String goal, String id) {
        this.vol = vol;
        this.seek = seek;
        this.status = status;
        this.opinion = opinion;
        this.goal = goal;
        this.id = id;
    }
    //Empty constructor. Necessary for JSON to Java deserialization 
    public Mission() {
		
	}
    // Setters
    public void setVol(String vol) {
        this.vol = vol;
    }
    public void setSeek(String seek) {
        this.seek = seek;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public void setOpinion(String opinion) {
        this.opinion = opinion;
    }
    public void setGoal(String goal) {
        this.goal = goal;
    }
    public void setId(String id) {
        this.id = id;
    }
    // Getters
    public String getVol() {
        return vol;
    }
    public String getSeek() {
        return seek;
    }
    public Status getStatus() {
        return status;
    }
    public String getOpinion() {
        return opinion;
    }
    public String getGoal() {
        return goal;
    }
    public String getId() {
        return id;
    }



}
