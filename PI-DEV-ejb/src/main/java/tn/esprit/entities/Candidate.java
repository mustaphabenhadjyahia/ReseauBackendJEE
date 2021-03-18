package tn.esprit.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.OneToMany;
import javax.persistence.PersistenceContext;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Candidate extends User implements Serializable  {
	
	
	
	private static final long serialVersionUID = 1L;
	private String bio;
	private String parcours;
	private String certification;
	private String experiences;
	private String photoProfil;
	private String photoCouverture;
	private Integer numTel;
	private String cv;
	
	public Integer getNumTel() {
		return numTel;
	}

	public void setNumTel(Integer numTel) {
		this.numTel = numTel;
	}

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getPhotoProfil() {
		return photoProfil;
	}

	public void setPhotoProfil(String photoProfil) {
		this.photoProfil = photoProfil;
	}

	public String getPhotoCouverture() {
		return photoCouverture;
	}

	public void setPhotoCouverture(String photoCouverture) {
		this.photoCouverture = photoCouverture;
	}

	public String getExperiences() {
		return experiences;
	}

	public void setExperiences(String experiences) {
		this.experiences = experiences;
	}
	private String competences;
	private double rate = 0;
	
	
    private int nbrrating = 0;
	
	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getNbrrating() {
		return nbrrating;
	}

	public void setNbrrating(int nbrrating) {
		this.nbrrating = nbrrating;
	}
	@ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set<Offre> offres = new HashSet<Offre>();
	
	@XmlTransient
	public Set<Offre> getOffres() {
		return offres;
	}

	public void setOffres(Set<Offre> offres) {
		this.offres = offres;
	}
	@ManyToMany(mappedBy="candidats",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<User> contacts = new HashSet<User>();
	
	private int afftected;
	
	/*@OneToMany(targetEntity=Competence.class,mappedBy="candidate" ,fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	private List<Competence> competences = new ArrayList<Competence>();*/
	
	
	@XmlTransient
	public Set<User> getContacts() {
		return contacts;
	}

	public void setContacts(Set<User> contacts) {
		this.contacts = contacts;
	}
	
	
	
	public Candidate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

  /* @ManyToMany(cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
    private Set<CompanyManager> entreprises = new HashSet<CompanyManager>() ;

	@XmlTransient
	public Set<CompanyManager> getEntreprises() {
		return entreprises;
	}

	public void setEntreprises(Set<CompanyManager> entreprises) {
		this.entreprises = entreprises;
	}*/

/*	@XmlTransient
	public List<Competence> getCompetences() {
		return competences;
	}

	public void setCompetences(List<Competence> competences) {
		this.competences = competences;
	}*/

	public Candidate(String prenom, String nom,String mail,String password) {
		super(prenom, nom, mail, password);
		// TODO Auto-generated constructor stub
	}


	public Candidate(int id, String prenom, String nom, String adresse, TypeCompte typeCompte, String mail) {
		super(id, prenom, nom, adresse, typeCompte, mail);
		// TODO Auto-generated constructor stub
	}

	public Candidate(String prenom, String nom,String adresse, String mail,String password,String bio,String parcours,String certification,String competences) {
		super(prenom, nom,adresse ,mail,password);
		this.bio = bio;
		this.parcours=parcours;
		this.certification=certification;
		this.competences=competences;
		
	}

	public String getCompetences() {
		return competences;
	}

	public void setCompetences(String competences) {
		this.competences = competences;
	}

	public Candidate(int id, String prenom, String nom, String adresse, TypeCompte typeCompte, String mail, String bio,
			String parcours, String certification, int afftected) {
		super(id, prenom, nom, adresse, typeCompte, mail);
		this.bio = bio;
		this.parcours = parcours;
		this.certification = certification;
		this.afftected = afftected;
		
	}

	@Override
	public String toString() {
		return "Candidate [bio=" + bio + ", parcours=" + parcours + ", certification=" + certification + ", afftected="
				+ afftected + ",   ]";
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getParcours() {
		return parcours;
	}

	public void setParcours(String parcours) {
		this.parcours = parcours;
	}

	public String getCertification() {
		return certification;
	}

	public void setCertification(String certification) {
		this.certification = certification;
	}

	public int getAfftected() {
		return afftected;
	}

	public void setAfftected(int afftected) {
		this.afftected = afftected;
	}


	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@OneToMany(mappedBy = "candidate",fetch = FetchType.EAGER)
	List<EntrepriseAbonnes> entrepriseabonnes;

	@XmlTransient
	public List<EntrepriseAbonnes> getEntrepriseabonnes() {
		return entrepriseabonnes;
	}

	public void setEntrepriseabonnes(List<EntrepriseAbonnes> entrepriseabonnes) {
		this.entrepriseabonnes = entrepriseabonnes;
	}
	
	


}
