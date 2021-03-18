package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class EntrepriseAbonnes implements Serializable {
	

	@EmbeddedId
	private EntrepriseAbonnesPK EntrepriseAbonnesPK;
	
	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "idCompany",referencedColumnName ="id",insertable=false,updatable=false)
	private CompanyManager companyManager;
	
	
	public EntrepriseAbonnes(CompanyManager companyManager, Candidate candidate) {
		super();
		this.companyManager = companyManager;
		this.candidate = candidate;
	}

	
	public EntrepriseAbonnesPK getEntrepriseAbonnesPK() {
		return EntrepriseAbonnesPK;
	}






	public void setEntrepriseAbonnesPK(EntrepriseAbonnesPK entrepriseAbonnesPK) {
		EntrepriseAbonnesPK = entrepriseAbonnesPK;
	}

	@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name = "idAbonne",referencedColumnName ="id",insertable=false,updatable=false)
	private Candidate candidate;
	
	
	
	
	
	
	public EntrepriseAbonnes() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	
	

	public CompanyManager getCompanyManager() {
		return companyManager;
	}

	public void setCompanyManager(CompanyManager companyManager) {
		this.companyManager = companyManager;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	



}
