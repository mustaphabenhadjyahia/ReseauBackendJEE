package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlTransient;

@Entity
public class Competence  implements Serializable {
	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int id ;
	private static final long serialVersionUID = 1L;
	private String competences;
	@ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Candidate candidate;
	public Competence () {
		
	}
	
	public Competence(String competences) {
		super();
		
		this.competences=competences;
		
	}
	
	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public Competence(int id, String competences) {
		super();
		this.id = id;
		this.competences=competences;
		
	}
		
	@Override
	public String toString() {
		return "Competence [id=" + id + ", competences=" + competences + ", candidate=" + candidate + "]";
	}

	public String getCompetences() {
		return competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
