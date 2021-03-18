package tn.esprit.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlTransient;


@Entity
public class CompanyManager  extends User implements Serializable {
	private static final long serialVersionUID = 1L;
	private String introduction;
	private int nbEmployee;
	private String companyName;
	private String location;
	
	@OneToMany(mappedBy="entreprise",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Set<User> employes = new HashSet<>();
	
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	/*@ManyToMany(mappedBy="entreprises",cascade = CascadeType.PERSIST,fetch = FetchType.EAGER)
	private Set <Candidate> abonnes = new HashSet<Candidate>();
	
	
	@XmlTransient
	public Set<Candidate> getAbonnes() {
		return abonnes;
	}
	public void setAbonnes(Set<Candidate> abonnes) {
		this.abonnes = abonnes;
	}*/
	public CompanyManager() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CompanyManager(int id, String prenom, String nom, String adresse, TypeCompte typeCompte, String mail) {
		super(id, prenom, nom, adresse, typeCompte, mail);
		// TODO Auto-generated constructor stub
	}
	public CompanyManager(int id, String prenom, String nom, String adresse, TypeCompte typeCompte, String mail,
			String introduction, int nbEmployee) {
		super(id, prenom, nom, adresse, typeCompte, mail);
		this.introduction = introduction;
		this.nbEmployee = nbEmployee;
	}
	
	@Override
	public String toString() {
		return "CompanyManager [introduction=" + introduction + ", nbEmployee=" + nbEmployee + "]";
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public int getNbEmployee() {
		return nbEmployee;
	}
	public void setNbEmployee(int nbEmployee) {
		this.nbEmployee = nbEmployee;
	}
	
	
	
	@XmlTransient
	public Set<User> getEmployes() {
		return employes;
	}
	public void setEmployes(Set<User> employes) {
		this.employes = employes;
	}
	
 
	@OneToMany(mappedBy = "companyManager",fetch = FetchType.EAGER)
	Set<EntrepriseAbonnes> entrepriseabonnes;

	@XmlTransient
	public Set<EntrepriseAbonnes> getEntrepriseabonnes() {
		return entrepriseabonnes;
	}
	public void setEntrepriseabonnes(Set<EntrepriseAbonnes> entrepriseabonnes) {
		this.entrepriseabonnes = entrepriseabonnes;
	}

}
