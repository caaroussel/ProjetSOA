package fr.insa.Avis.model;


public class AvisVolunteer {
	private String idAvisVolunteer; 
	private String missionId;
	private String volunteerId;
	private String comment;
	private int rating;

	// Constructors, getters, and setters

	// Constructor
	public AvisVolunteer(String idAvisVolunteer, String missionId, String volunteerId, String comment, int rating) {
		this.idAvisVolunteer = idAvisVolunteer; 
		this.missionId = missionId;
		this.volunteerId = volunteerId;
		this.comment = comment;
		this.rating = rating;
	}

	// Getters and setters
	public String getVolunteerId() {
		return volunteerId;
	}

	public void setVolunteerId(String volunteerId) {
		this.volunteerId = volunteerId;
	}

	public String getMissionId() {
		return missionId;
	}

	public void setMissionId(String missionId) {
		this.missionId = missionId;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getIdAvisVolunteer() {
		return idAvisVolunteer;
	}

	public void setIdAvisVolunteer(String idAvisVolunteer) {
		this.idAvisVolunteer = idAvisVolunteer;
	}
}
