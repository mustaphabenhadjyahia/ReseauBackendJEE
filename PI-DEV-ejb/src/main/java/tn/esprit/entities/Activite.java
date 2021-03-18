package tn.esprit.entities;

import java.io.Serializable;



import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
public class Activite  implements Serializable {
private static final long serialVersionUID = 1L;

        


    @EmbeddedId
	private ActivitePK activitePK;

	
	public ActivitePK getActivitePK() {
		return activitePK;
	}
	

	
	@ManyToOne
	@JoinColumn(name = "idUser",referencedColumnName ="id",insertable=false,updatable=false)
	private User user ;

	@ManyToOne
	@JoinColumn(name = "idCommentaire",referencedColumnName ="id",insertable=false,updatable=false)
	private Commentaire commentaire ;
	
	
	@ManyToOne
	@JoinColumn(name = "idPost",referencedColumnName ="id",insertable=false,updatable=false)
	private Post post ;
	
	
	
	
	
	
	
	@Temporal(TemporalType.DATE)
	private Date dateActivite ;
	
	
	
	public Activite(ActivitePK activitePK, User user, Post post, Commentaire commentaire, Date dateActivite) {
		super();
		this.activitePK = activitePK;
		this.user = user;
		this.post = post;
		this.commentaire = commentaire;
		this.dateActivite = dateActivite;
	}



	public void setActivitePK(ActivitePK activitePK) {
		this.activitePK = activitePK;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public Post getPost() {
		return post;
	}


	public void setPost(Post post) {
		this.post = post;
	}


	public Commentaire getCommentaire() {
		return commentaire;
	}


	public void setCommentaire(Commentaire commentaire) {
		this.commentaire = commentaire;
	}


	public Activite () {
		
	}
	
	
	public Date getDateActivite() {
		return dateActivite;
	}
	public void setDateActivite(Date dateActivite) {
		this.dateActivite = dateActivite;
	}
	

}
