package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Notification implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int id;
	private String description;
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@ManyToOne
	private User user;
	
	

	
	public Notification() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Notification(int id, String description, Date date) {
		super();
		this.id = id;
		this.description = description;
		this.date = date;
	}

	@Override
	public String toString() {
		return "Notification [id=" + id + ", description=" + description + ", date=" + date + "]";
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

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	

}
