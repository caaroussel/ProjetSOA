package fr.insa.Avis.model;

public class AvisHelpSeeker {
	private String idAvisHelpSeeker; 
	private String missionId;
	private String helpSeekerId;
	private String comment;
	private int rating;

	// Constructors, getters, and setters

	// Constructor
	public AvisHelpSeeker(String idAvisHelpSeeker, String missionId, String helpSeekerId, String comment, int rating) {
		this.idAvisHelpSeeker = idAvisHelpSeeker; 
		this.missionId = missionId;
		this.helpSeekerId = helpSeekerId;
		this.comment = comment;
		this.rating = rating;
	}

	// Getters and setters
	public String getMissionId() {
		return missionId;
	}

	public void setMissionId(String missionId) {
		this.missionId = missionId;
	}

	public String getHelpSeekerId() {
		return helpSeekerId;
	}

	public void setHelpSeekerId(String helpSeekerId) {
		this.helpSeekerId = helpSeekerId;
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

	public String getIdAvisHelpSeeker() {
		return idAvisHelpSeeker;
	}

	public void setIdAvisHelpSeeker(String idAvisHelpSeeker) {
		this.idAvisHelpSeeker = idAvisHelpSeeker;
	}
}
