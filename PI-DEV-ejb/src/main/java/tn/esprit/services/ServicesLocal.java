package tn.esprit.services;

import java.util.List;
import java.util.Set;

import javax.ejb.Local;


import tn.esprit.entities.Candidate;
import tn.esprit.entities.CompanyManager;
import tn.esprit.entities.Offre;
import tn.esprit.entities.User;



@Local
public interface ServicesLocal {

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
	public List<CompanyManager> ListeEntreprisesAuxQuelsCandidatEstAbonne(int idCandidat);
	public String VerifierCompte(String token);
}
