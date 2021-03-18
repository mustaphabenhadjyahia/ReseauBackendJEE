package tn.esprit.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;


import tn.esprit.entities.Candidate;
import tn.esprit.entities.CompanyManager;
import tn.esprit.entities.Competence;
import tn.esprit.entities.EntrepriseAbonnes;
import tn.esprit.entities.EntrepriseAbonnesPK;
import tn.esprit.entities.Offre;
import tn.esprit.entities.User;
import tn.esprit.entities.VerificationToken;


@Stateless
@LocalBean
public class ServiceCandidat implements ServicesRemote , ServicesLocal {

	@PersistenceContext
	EntityManager em;
	
	
	@Override
	public String ajouterCandidat(Candidate c) {
		// TODO Auto-generated method stub
		try {
			VerificationToken vt = new VerificationToken();
            c.setVerificationToken(vt);
            vt.setUser(c);
           em.persist(c);
			 
		            String host ="smtp.gmail.com" ;
		            String user = "mustaphabhy96@gmail.com";
		            String pass ="mustapha53751252";
		            String to = c.getMail();
		            String from = "mustaphabhy96@gmail.com";
		            String subject = "Confirmation compte";
		            String messageText = "Bonjour Mr/Mme "+c.getNom( )+" "+c.getPrenom()+", Nous vous remercions d'avoir choisis notre platforme ."
		                    + "Veuillez confirmer votre inscription en cliquant sur ce lien : http://localhost:4200/validerCompte/"+c.getVerificationToken().getToken()
		                    
		                    + " Merci.";
		            boolean sessionDebug = false;

		            Properties props = System.getProperties();

		            props.put("mail.smtp.starttls.enable", "true");
		            props.put("mail.smtp.host", host);
		            props.put("mail.smtp.port", "587");
		            props.put("mail.smtp.auth", "true");
		            props.put("mail.smtp.starttls.required", "true");

		            java.security.Security.addProvider(new com.sun.net.ssl.internal.ssl.Provider());
		            Session mailSession = Session.getDefaultInstance(props, null);
		            mailSession.setDebug(sessionDebug);
		            Message msg = new MimeMessage(mailSession);
		            msg.setFrom(new InternetAddress(from));
		            InternetAddress[] address = {new InternetAddress(to)};
		            msg.setRecipients(Message.RecipientType.TO, address);
		            msg.setSubject(subject); msg.setSentDate(new Date());
		            msg.setText(messageText);

		           Transport transport=mailSession.getTransport("smtp");
		           transport.connect(host, user, pass);
		           transport.sendMessage(msg, msg.getAllRecipients());
		           transport.close();
		           System.out.println("message send successfully");
		       
					return "added successfully";

		                
		         
		        
		}
		catch(Exception e){
		System.out.println("erreur ajout : "+e.getMessage());
		return "erreur";
	}
	}
	
	@Override
	public List<Candidate> getCandidates() {
		// TODO Auto-generated method stub
		List<Candidate> candidats = em.createQuery("select c from Candidate c",Candidate.class).getResultList();
		return candidats;
	
	}
	
	@Override 
	public Candidate getCandidatbyId(int id) {
		return em.find(Candidate.class, id);
	}

	@Override
	public String supprimerCandidatbyId(int id) {
		// TODO Auto-generated method stub
		try {
			Query q = em.createQuery("Delete from VerificationToken vt where vt.user.id=:id");
			q.setParameter("id", id);
			q.executeUpdate();
			Query q2 = em.createQuery("Delete from Candidate c where c.id=:id");
			q2.setParameter("id", id);
			q2.executeUpdate();
			return "removed successfully";
			/*em.remove(em.find(Candidate.class, id));
			return "removed successfully"+em.find(Candidate.class, id).getNom();*/
		}
		catch(Exception e){
		System.out.println("erreur suppression : "+e.getMessage());
		return "erreur";
	}
	}

		@Override
		public boolean updateCandidatebyId(Candidate c) {
			
			
			
			Candidate c1 = em.find(Candidate.class, c.getId());
			System.out.println("id candidat : "+c1.getId());
			c1.setNom(c.getNom());
			c1.setPrenom(c.getPrenom());
			c1.setBio(c.getBio());
			c1.setAdresse(c.getAdresse());
			c1.setCompetences(c.getCompetences());
			c1.setParcours(c.getParcours());
			c1.setMail(c.getMail());
			c1.setPassword(c.getPassword());
			c1.setCertification(c.getCertification());
			c1.setExperiences(c.getExperiences());
			c1.setPhotoProfil(c.getPhotoProfil());
			c1.setPhotoCouverture(c.getPhotoCouverture());
			c1.setNumTel(c.getNumTel());
			c1.setCv(c.getCv());
			
			return true ;
		

	
	
	}
		
		@Override
		public User Authentification(String mail, String password) {
			// TODO Auto-generated method stub
			
			TypedQuery<User> q = em.createQuery("Select u from User u where u.mail=:mail and u.password=:password",User.class);
			q.setParameter("mail", mail);
			q.setParameter("password", password);
			User u = null;
			try {u=q.getSingleResult();}
			catch (Exception e) {
				System.out.println(e.getMessage());}
			return u;
			}
		
		@Override
		public List<User> RechercheContactParNom(String nom) {
			List<User> contacts = em.createQuery("Select u from User u",User.class).getResultList();
			List<User> contactssRecherches = new ArrayList<User>(); 

			for (User u : contacts) {
			
			
				if(u.getNom().toLowerCase().contains(nom.toLowerCase()) || u.getNom().toUpperCase().contains(nom.toUpperCase())
						||u.getPrenom().toLowerCase().contains(nom.toLowerCase()) || u.getPrenom().toUpperCase().contains(nom.toUpperCase()) )
					contactssRecherches.add(u);
				}
					
				return contactssRecherches;
				
		}
		
		@Override
		public List<Candidate> RechercheContactParCompetence(String competence) {
			List<Candidate> contacts = em.createQuery("Select c from Candidate c",Candidate.class).getResultList();
			List<Candidate> contactssRecherches = new ArrayList<Candidate>(); 

			for (Candidate c : contacts) {
			
			System.out.println(c.getCompetences());
				if( (c.getCompetences().toLowerCase().contains(competence.toLowerCase())) || (c.getCompetences().toUpperCase().contains(competence.toUpperCase())))
					contactssRecherches.add(c);
				}
					
				return contactssRecherches;
				
		}
		
		@Override
		public String AjouterContactbyId(int idCandidate, int idContact) {
			try {
			Candidate c = em.find(Candidate.class, idCandidate);
			User u = em.find(User.class, idContact);
			if(idCandidate!=idContact) {
			u.getCandidats().add(c);
			c.getContacts().add(u);
			return "contact "+ u.getNom() + " ajouté au candidat " + c.getNom() + "//" + "Liste Contacts de "+c.getNom() +""+c.getContacts(); 
			
		}
			else {
				return "erreur";
			}
			}
			catch (Exception e){
			return e.getMessage();
		}
		}
		
		
		@Override
		public Set<User> AfficherContactsCandidat(int idCandidat){
			
			Candidate c = em.find(Candidate.class, idCandidat);
			return c.getContacts();
			
		}

			@Override
			public String PostulerPourOffre(int idOffre, int idCandidat) {
				try {
				Candidate c = em.find(Candidate.class, idCandidat);
				Offre o = em.find(Offre.class, idOffre);
				//o.getCandidats().add(c);
				c.getOffres().add(o);
				System.out.println(c.getOffres() + "  " + o.getCandidats());
				return "candidat "+ c.getNom() +" "+ c.getPrenom()+ " a postulé a l'offre " + o.getContenu();
				
			}catch (Exception e){
				return e.getMessage();
			}
			}
				@Override
				public Set<Offre> OffresAuxQuelsaPostuleCandidat(int idCandidat){
					Candidate c = em.find(Candidate.class, idCandidat);
					return c.getOffres();
				}
				
			@Override
				public String SabonnerAEntreprise(int idCandidat,int idCompanyManager) {
					try {
					Candidate c = em.find(Candidate.class, idCandidat);
					CompanyManager cm = em.find(CompanyManager.class, idCompanyManager);
				
					EntrepriseAbonnesPK eaPK = new EntrepriseAbonnesPK();
					eaPK.setIdAbonne(idCandidat);
					eaPK.setIdCompany(idCompanyManager);
					EntrepriseAbonnes ea = new EntrepriseAbonnes();
			
					ea.setEntrepriseAbonnesPK(eaPK);
		
                    em.persist(ea);
					
			/*		c.getEntreprises().add(cm);
					cm.getAbonnes().add(c);*/
                   System.out.println(cm.getId()+""+c.getId());
					
					return "candidat "+ c.getNom() + c.getPrenom()+ " s'est abonné à l'entreprise " + cm.getCompanyName();
					
				}
					catch (Exception e){
					return e.getMessage();
				}
				}

				@Override
				public String rating(int idCandidat,double rate) {
					Candidate c = em.find(Candidate.class, idCandidat);
                    double oldrate = c.getRate();
                    int oldnbrrate = c.getNbrrating();
System.out.println(oldrate + " nbr : " + oldnbrrate);
                    if (oldrate==0 && oldnbrrate ==0) {
                    	c.setRate(rate);
                    	c.setNbrrating(1);
                    	return "rating du candidat "+c.getNom()+" "+c.getPrenom()+" = " + c.getRate() + " / nbre de rates : "+c.getNbrrating();
                    }
                    if (rate<6 && rate >0) {
						int newnbrrate=oldnbrrate+1;
						double newrate=(oldrate+rate)/2;
						c.setRate(newrate);
						c.setNbrrating(newnbrrate);
						return "rating du candidat "+c.getNom()+" "+c.getPrenom()+" = " + c.getRate() + " / nbre de rates : "+c.getNbrrating();

					}
					else {
						return "erreur";}
				}
				
				
				@Override
				public List<Offre> rechercheEmplois(String critere){
					List<Offre> offres = em.createQuery("select o from Offre o",Offre.class).getResultList();
					List<Offre> offresRecherches = new ArrayList<Offre>(); 

					for (Offre o : offres) {
					
					
						if(o.getContenu().toLowerCase().contains(critere.toLowerCase()) || o.getContenu().toUpperCase().contains(critere.toUpperCase()) )
								offresRecherches.add(o);
							
						

					}
					
					return offresRecherches;
				}
				
				
				@Override
				public List<Offre> rechercheEmploisparLieu(String lieu){
			  
              List<CompanyManager> companies = em.createQuery("Select cm from CompanyManager cm",CompanyManager.class).getResultList();
			  Query q = em.createQuery("select o from Offre o where o.user=:cm",Offre.class);
              List offresRecherches = new ArrayList<>();
              
			for (CompanyManager cm : companies) {
				
				if (cm.getLocation().toLowerCase().equals(lieu.toLowerCase()) || cm.getLocation().toUpperCase().equals(lieu.toUpperCase())) {
                      q.setParameter("cm", cm);
                      List<Offre> offres = q.getResultList();
                      offresRecherches.add(offres);
				
			}
				

			}
			return offresRecherches;
				}

				@Override
				public List<CompanyManager> ListeEntreprisesAuxQuelsCandidatEstAbonne(int idCandidat){
					//Candidate c = em.find(Candidate.class, idCandidat);
				//	TypedQuery<CompanyManager> q = em.createQuery("Select distinct cm from CompanyManager cm join cm.EntrepriseAbonnes ea join ea.candidate c where c.id=:idCandidat",CompanyManager.class);
					//TypedQuery<CompanyManager> q = em.createQuery("Select cm from CompanyManager cm join cm.entrepriseabonnes ea join ea.candidate c where c.id=:idCandidat",CompanyManager.class);
					TypedQuery<CompanyManager> q = em.createQuery("Select DISTINCT c from CompanyManager c join c.entrepriseabonnes e join e.candidate u where u.id=:idCandidat ",CompanyManager.class);
					q.setParameter("idCandidat", idCandidat);
					
		
					
                    return q.getResultList();
				}
				
				@Override
				public String VerifierCompte(String token) {
					TypedQuery<VerificationToken> q = em.createQuery("Select v from VerificationToken v where v.token=:token",VerificationToken.class);
					q.setParameter("token", token);
					VerificationToken vt = q.getSingleResult();
					if ( vt.getStatus().equals(vt.STATUS_PENDING) && vt.getExpiredDateTime().isAfter(LocalDateTime.now())) {
						vt.setConfirmedDateTime(LocalDateTime.now());
						vt.setStatus(vt.STATUS_VERIFIED);
						vt.getUser().setIsActive(true);
						return "Félicitations Mr/Mme "+vt.getUser().getPrenom()+" "+vt.getUser().getNom()+" votre compte a été verifié avec succès";
					}
					if (vt.getStatus().equals(vt.STATUS_VERIFIED)) {
						return "Mr/Mme "+vt.getUser().getPrenom()+" "+vt.getUser().getNom()+", Votre compte a été déjà verifié.";
					}
					if (vt.getExpiredDateTime().isBefore(LocalDateTime.now())) {
						return "Vous avez dépassé la date limite pour la verification de votre compte, veuillez vous réinscrire.";
					}
					else return "jeton invalide";
					
				}
				
				@Override
				public List<Offre> rechercheEmploisparEntreprise(int idEntreprise){
			  
              
			  TypedQuery<Offre> q = em.createQuery("select o from Offre o where o.user.id=:id",Offre.class);
			  q.setParameter("id", idEntreprise);
             
			
			  return q.getResultList();
				
			
				}
				
				@Override
				public List<User> ContactsParEntreprise(int idCandidat, int idEntreprise){
					  TypedQuery<User> q = em.createQuery("select u from User u where u.entreprise.id=:id",User.class);
					  q.setParameter("id", idEntreprise);
                      List<User> users = q.getResultList(); 
                      List<User> contactsEntreprise = new ArrayList<User>();
                      Candidate c = em.find(Candidate.class, idCandidat);
                      
                      for (User u : users) {
                    	  if (c.getContacts().contains(u))
                    		  contactsEntreprise.add(u);
                      }
                      return contactsEntreprise;
                     
				}

				@Override
				public List<Offre> getAllOffres(){
					List<Offre> offres = em.createQuery("select o from Offre o",Offre.class).getResultList();
					return offres;
				
				}

				@Override
				public List<CompanyManager> getAllCompanies(){
					List<CompanyManager> companies = em.createQuery("select cm from CompanyManager cm",CompanyManager.class).getResultList();
					return companies;
				
				}
				
				@Override
				public String DesabonnerCandidat(int idCandidat, int idAbonne) {
					Candidate c = em.find(Candidate.class, idCandidat);
					User a = em.find(User.class, idAbonne);
					Set<User> la= c.getContacts();
					Set<Candidate> lc = a.getCandidats();
					la.remove(a);
					lc.remove(c);
					c.setContacts(la);
					a.setCandidats(lc);
				
					return c.getPrenom() + " est desabonné de "+a.getPrenom();
				}

				@Override
				public String DepostulerPourOffre(int idCandidat, int idOffre) {
					Candidate c = em.find(Candidate.class, idCandidat);
					Offre o = em.find(Offre.class, idOffre);
					//o.getCandidats().remove(c);
					c.getOffres().remove(o);
					return c.getNom()+" a annulé sa candidature pour l'offre "+o.getContenu();
					
				}

				@Override
				public Offre getOffrebyId(int id) {
				 
						return em.find(Offre.class, id);
				}
					


				@Override
				public CompanyManager getCompanybyId(int id) {
					// TODO Auto-generated method stub
					return em.find(CompanyManager.class, id);
				}
				
				@Override 
				public List<User> followers(int idCandidat){
					List<User> l = em.createQuery("Select u from User u",User.class).getResultList();
					Candidate c = em.find(Candidate.class, idCandidat);
					List<User> l2 = new ArrayList<User>();
					for (User u:l) {
						for (User u2: c.getCandidats()) {
							if (u==u2) {
								l2.add(u2);
							}
						}
					}

					return l2;
				}
				
				@Override
				public String DessabonnerAEntreprise(int idCandidat,int idCompanyManager) {
					try {
					/*Candidate c = em.find(Candidate.class, idCandidat);
					CompanyManager cm = em.find(CompanyManager.class, idCompanyManager);
				
					EntrepriseAbonnesPK eaPK = new EntrepriseAbonnesPK();
					eaPK.setIdAbonne(idCandidat);
					eaPK.setIdCompany(idCompanyManager);
					EntrepriseAbonnes ea = new EntrepriseAbonnes();
			
					ea.setEntrepriseAbonnesPK(eaPK);
		
                    em.remove(ea);
					
				c.getEntreprises().add(cm);
					cm.getAbonnes().add(c);
                   System.out.println(cm.getId()+""+c.getId());
					
					return "candidat "+ c.getNom() + c.getPrenom()+ " s'est désabonné de l'entreprise " + cm.getCompanyName();
					*/
						Candidate c = em.find(Candidate.class, idCandidat);
						CompanyManager cm = em.find(CompanyManager.class, idCompanyManager);
						Query q = em.createQuery("Delete from EntrepriseAbonnes e where e.candidate.id=:idCandidat and e.companyManager.id=:idCompanyManager");
						q.setParameter("idCandidat", idCandidat);
						q.setParameter("idCompanyManager", idCompanyManager);
						q.executeUpdate();
						return "candidat "+ c.getNom() + c.getPrenom()+ " s'est désabonné de l'entreprise " + cm.getCompanyName();
						
				}
					catch (Exception e){
					return e.getMessage();
				}
				}
			
}