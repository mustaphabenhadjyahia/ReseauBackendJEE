package tn.esprit.entities;

import java.io.Serializable;


import javax.persistence.Embeddable;



@Embeddable
public class ActivitePK implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = -7512980199843093119L;

	private int idUser;
	private int idCommentaire;
	private int idPost;
	
	
	
	

	public ActivitePK() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ActivitePK(int idUser, int idPost, int idCommentaire) {
		super();
		this.idUser = idUser;
		this.idPost = idPost;
		this.idCommentaire = idCommentaire;
	}

	@Override
	public String toString() {
		return "ActivitePK [idUser=" + idUser + ", idPost=" + idPost + ", idCommentaire=" + idCommentaire + "]";
	}

	public int getIdUser() {
		return idUser;
	}

	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}

	public int getIdPost() {
		return idPost;
	}

	public void setIdPost(int idPost) {
		this.idPost = idPost;
	}

	public int getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}
   
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCommentaire;
		result = prime * result + idPost;
		result = prime * result + idUser;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ActivitePK other = (ActivitePK) obj;
		if (idCommentaire != other.idCommentaire)
			return false;
		if (idPost != other.idPost)
			return false;
		if (idUser != other.idUser)
			return false;
		return true;
	}
	
	
	
}
