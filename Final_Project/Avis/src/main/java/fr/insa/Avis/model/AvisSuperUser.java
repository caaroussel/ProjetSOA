package fr.insa.Avis.model;

public class AvisSuperUser {
	private String idAvisSuperUser; 
	private String missionId; 
	private String SupId;
	private int rating;
	private String comment;

	public AvisSuperUser(String idAvisSuperUser, String missionId, String SupId,  String comment, int rating) {
		this.idAvisSuperUser = idAvisSuperUser;
		this.missionId = missionId;
		this.SupId = SupId;
		this.comment = comment;
		this.rating = rating;
	}

	public String getMissionId() {
		return missionId;
	}

	public void setMissionId(String missionId) {
		this.missionId = missionId;
	}

	public String getUtilisateur() {
		return SupId;
	}

	public void setUtilisateur(String SupId) {
		this.SupId = SupId;
	}

	public int getNote() {
		return rating;
	}

	public void setNote(int note) {
		this.rating = note;
	}

	public String getCommentaire() {
		return comment;
	}

	public void setCommentaire(String comment) {
		this.comment = comment;
	}

	public String getIdAvisSuperUser() {
		return idAvisSuperUser;
	}

	public void setIdAvisSuperUser(String idAvisSuperUser) {
		this.idAvisSuperUser = idAvisSuperUser;
	}
}

