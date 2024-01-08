package fr.insa.Avis.model;

public class NotifRefus {
    private String id;
    private String idMission;
    private String idVolunteer;
    private String idHelpSeeker;
    private String idSuperUser;
    private String message;
    
    public NotifRefus() {
        
    }
    
    public NotifRefus(String id, String idMission, String idVolunteer, String idHelpSeeker, String idSuperUser, String message) {
        this.id = id;
        this.idMission = idMission;
        this.idVolunteer = idVolunteer;
        this.idHelpSeeker = idHelpSeeker;
        this.idSuperUser = idSuperUser;
        this.message = message;
    }
    
    public String getId() {
        return id;
    }
    
    public String getIdMission() {
        return idMission;
    }
    
    public String getIdVolunteer() {
        return idVolunteer;
    }
    
    public String getIdHelpSeeker() {
        return idHelpSeeker;
    }
    
    public String getIdSuperUser() {
        return idSuperUser;
    }
    
    public String getMessage() {
        return message;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public void setIdMission(String idMission) {
        this.idMission = idMission;
    }
    
    public void setIdVolunteer(String idVolunteer) {
        this.idVolunteer = idVolunteer;
    }
    
    public void setIdHelpSeeker(String idHelpSeeker) {
        this.idHelpSeeker = idHelpSeeker;
    }
    
    public void setIdSuperUser(String idSuperUser) {
        this.idSuperUser = idSuperUser;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
}
