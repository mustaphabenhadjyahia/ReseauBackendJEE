package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Commentaire implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int id ;
	private String description ;
	
	@Temporal(TemporalType.DATE)
	private Date dateCommentaire ;
	public Commentaire () {}
	
	@Override
	public String toString() {
		return "Commentaire [id=" + id + ", description=" + description + ", dateCommentaire=" + dateCommentaire + "]";
	}

	public Commentaire(int id, String description , Date date) {
		super();
		this.id = id;
		this.description = description;
		this.dateCommentaire=date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateCommentaire() {
		return dateCommentaire;
	}
	public void setDateCommentaire(Date dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

}
