package tn.esprit.services;

import java.util.List;
import java.util.Set;

import javax.ejb.Remote;

import tn.esprit.entities.Candidate;
import tn.esprit.entities.CompanyManager;
import tn.esprit.entities.Offre;
import tn.esprit.entities.User;



@Remote
public interface ServicesRemote {

	public String ajouterCandidat(Candidate c);
	public List<Candidate> getCandidates();
	public String supprimerCandidatbyId(int id);
	public boolean updateCandidatebyId(Candidate c);
	public Candidate getCandidatbyId(int id);
	
	public List<User> RechercheContactParNom(String nom);
	public String AjouterContactbyId(int idCandidate, int idContact);
	public String PostulerPourOffre(int idOffre, int idCandidat);
	public User Authentification(String mail, String password);
	public Set<User> AfficherContactsCandidat(int idCandidat);
	public Set<Offre> OffresAuxQuelsaPostuleCandidat(int idCandidat);
	public String SabonnerAEntreprise(int idCandidat, int idCompanyManager);
	public String rating(int idCandidat, double rate);
	public List<Offre> rechercheEmplois(String critere);
	public List<Offre> rechercheEmploisparLieu(String lieu);
	public List ListeEntreprisesAuxQuelsCandidatEstAbonne(int idCandidat);
	public String VerifierCompte(String token);
	public List<Candidate> RechercheContactParCompetence(String competence);
	public List<Offre> rechercheEmploisparEntreprise(int idEntreprise);
	public List<User> ContactsParEntreprise(int idCandidat, int idEntreprise);
	public List<Offre> getAllOffres();
	public List<CompanyManager> getAllCompanies();
	public String DesabonnerCandidat(int idCandidat, int idAbonne);
	public String DepostulerPourOffre(int idCandidat, int idOffre);
	public Offre getOffrebyId(int id);
	public CompanyManager getCompanybyId(int id);
	public List<User> followers(int idCandidat);
	public String DessabonnerAEntreprise(int idCandidat, int idCompanyManager);
}
