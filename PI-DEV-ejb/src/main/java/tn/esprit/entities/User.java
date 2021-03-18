package tn.esprit.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlTransient;


@Entity
public class User implements Serializable {
private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue( strategy= GenerationType.IDENTITY)
	private int id ;
	private String prenom;
	private String nom;
	private String adresse;
	private String password;
    private Boolean isActive=false;
    @Enumerated(EnumType.STRING)
    private RoleCandidate role;

	
	 public Boolean getIsActive() {
		return isActive;
	}
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	 @OneToOne(mappedBy = "user", cascade = {CascadeType.PERSIST,CascadeType.REMOVE})
	 private VerificationToken verificationToken;
	 
	 @ManyToMany(fetch = FetchType.EAGER,cascade = CascadeType.PERSIST)
	 private Set<Candidate> candidats = new HashSet<Candidate>();
	
	 @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	 private CompanyManager entreprise;
	
	 @XmlTransient
	public Set<Candidate> getCandidats() {
		return candidats;
	}
	public void setCandidats(Set<Candidate> candidats) {
		this.candidats = candidats;
	}
	@XmlTransient
	public VerificationToken getVerificationToken() {
		return verificationToken;
	}
	public void setVerificationToken(VerificationToken verificationToken) {
		this.verificationToken = verificationToken;
	}
	
	@Enumerated(EnumType.STRING)
	private TypeCompte typeCompte = TypeCompte.FREE;
	
	public User(String prenom, String nom ,String adresse, String mail,String password) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.mail=mail;
		this.adresse=adresse;
		this.setPassword(password);
		
	}
	private String mail;
	
	@OneToMany(mappedBy="user")
	private List<Notification> listNotification ;
	
	@OneToMany(mappedBy="user")
	private List<Activite> listActivite ;
	
	
	@OneToMany(mappedBy="user")
	private List<Message> listMessage ;
	
	@OneToMany(mappedBy="user")
	private List<Claim> listClaim;
	
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String nom, String prenom,String mail,String password) {
		super();
		this.nom=nom;
		this.prenom=prenom;
		this.mail=mail;
		this.password=password;
		}
	
	public User(int id, String prenom, String nom, String adresse, TypeCompte typeCompte, String mail) {
		super();
		this.id = id;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.typeCompte = typeCompte;
		this.mail = mail;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", prenom=" + prenom + ", nom=" + nom + ", adresse=" + adresse + ", typeCompte="
				+ typeCompte + ", mail=" + mail + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public TypeCompte getTypeCompte() {
		return typeCompte;
	}
	public void setTypeCompte(TypeCompte typeCompte) {
		this.typeCompte = typeCompte;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
