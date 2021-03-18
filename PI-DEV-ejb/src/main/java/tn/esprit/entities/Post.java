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
public class Post   implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int id ;
	private String desciption ;
	
	@Temporal(TemporalType.DATE)
	private Date datePost ;
	public Post () {
	}
	
	public Post(int id, String desciption, Date datePost) {
		super();
		this.id = id;
		this.desciption = desciption;
		this.datePost = datePost;
	}

	@Override
	public String toString() {
		return "Post [id=" + id + ", desciption=" + desciption + ", datePost=" + datePost + "]";
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDesciption() {
		return desciption;
	}
	public void setDesciption(String desciption) {
		this.desciption = desciption;
	}
	public Date getDatePost() {
		return datePost;
	}
	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

}
