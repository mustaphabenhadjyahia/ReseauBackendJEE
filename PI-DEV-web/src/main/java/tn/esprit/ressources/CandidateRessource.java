package tn.esprit.ressources;




import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import tn.esprit.entities.Candidate;
import tn.esprit.services.ServiceCandidat;

@Path("candidat")
public class CandidateRessource {

	@EJB
	ServiceCandidat sc;
	
	@POST
	@Path("add")
	@Consumes("application/json")
	@Produces(MediaType.TEXT_PLAIN)
	public Response ajouterCandidat(Candidate c) {
		return Response.ok(sc.ajouterCandidat(c), MediaType.APPLICATION_JSON).build();
		
	}

	
    @GET
	@Produces("application/json")
	public Response getCandidates() {
		
			if (sc.getCandidates() == null)
				return Response.status(Response.Status.NOT_FOUND).build();

			if (sc.getCandidates().size() == 0)
				return Response.status(Response.Status.NO_CONTENT).entity("Pas de contenu").build();

			else
				return Response.ok(sc.getCandidates(), MediaType.APPLICATION_JSON).build();

	}

    @GET
    @Path("{id}")
	@Produces("application/json")
	public Response getCandidatbyId(@PathParam(value="id") int id) {
		
				return Response.ok(sc.getCandidatbyId(id), MediaType.APPLICATION_JSON).build();

	}


   @DELETE
   @Path("delete/{id}")
   @Produces("application/json")
   public Response deleteCandidate(@PathParam(value="id") int id) {
	   
	return Response.ok(sc.supprimerCandidatbyId(id), MediaType.APPLICATION_JSON).build();
	
   }
   
    @PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public Response updateCandidate(Candidate c) {
    	return Response.ok(sc.updateCandidatebyId(c), MediaType.APPLICATION_JSON).build();
    	
	}

    
    @GET
    @Produces("application/json")
    @Path("authentification/{mail}/{password}")
    public Response Authentification( @PathParam(value="mail") String mail, @PathParam(value="password") String password) {
    	return Response.ok(sc.Authentification(mail, password), MediaType.APPLICATION_JSON).build();
    }
    
    
    @GET
    @Path("rechercheNom/{nom}")
    @Produces("application/json")
    public Response rechercheContactParNom(@PathParam(value="nom") String nom) {
 	   
    	return Response.ok(sc.RechercheContactParNom(nom), MediaType.APPLICATION_JSON).build();
    	
       }
    
    @GET
    @Path("rechercheCompetence/{competence}")
    @Produces("application/json")
    public Response rechercheContactParCompetence(@PathParam(value="competence") String competence) {
 	   
    	return Response.ok(sc.RechercheContactParCompetence(competence), MediaType.APPLICATION_JSON).build();
    	
       }

    @POST
    @Path("ajoutContact/{idCandidat}/{idContact}")
    @Produces("application/json")
    public Response ajouterContact(@PathParam(value="idCandidat") int idCandidat,@PathParam(value="idContact") int idContact) {
    	
		return Response.ok(sc.AjouterContactbyId(idCandidat, idContact), MediaType.APPLICATION_JSON).build();
    	
    }
    
    @POST
    @Path("PostulerPourOffre/{idOffre}/{idCandidat}")
    @Produces("application/json")
    public Response PostulerPourOffre(@PathParam(value="idOffre") int idOffre,@PathParam(value="idCandidat") int idCandidat) {
    	
		return Response.ok(sc.PostulerPourOffre(idOffre,idCandidat), MediaType.APPLICATION_JSON).build();
    	
    }
	
    @GET
    @Path("contacts/{idCandidat}")
    @Produces("application/json")
    public Response rechercheContact(@PathParam(value="idCandidat") int idCandidat) {
 	   
    	return Response.ok(sc.AfficherContactsCandidat(idCandidat), MediaType.APPLICATION_JSON).build();
    	
       }
	
    @GET
    @Path("OffresAuxQuelsaPostule/{idCandidat}")
    @Produces("application/json")
    public Response OffresAuxQuelsaPostuleCandidat(@PathParam(value="idCandidat") int idCandidat) {
 	   
    	return Response.ok(sc.OffresAuxQuelsaPostuleCandidat(idCandidat), MediaType.APPLICATION_JSON).build();
    	
       }
    
    @POST
    @Path("SabonnerAEntreprise/{idCandidat}/{idCompanyManager}")
    @Produces("application/json")
    public Response SabonnerAEntreprise(@PathParam(value="idCandidat") int idCandidat,@PathParam(value="idCompanyManager") int idCompanyManager) {
    	
		return Response.ok(sc.SabonnerAEntreprise(idCandidat,idCompanyManager), MediaType.APPLICATION_JSON).build();
    	
    }
    
    @POST
    @Path("Rating/{idCandidat}/{rate}")
    @Produces("application/json")
    public Response Rating(@PathParam(value="idCandidat") int idCandidat,@PathParam(value="rate") double rate) {
    	
		return Response.ok(sc.rating(idCandidat, rate), MediaType.APPLICATION_JSON).build();
    	
    }
    

    @GET
    @Path("rechercheEmplois/{critere}")
    @Produces("application/json")
    public Response rechercheEmplois(@PathParam(value="critere") String critere) {
 	   
    	return Response.ok(sc.rechercheEmplois(critere), MediaType.APPLICATION_JSON).build();
    	
       }
    
    @GET
    @Path("rechercheEmploisParLieu/{lieu}")
    @Produces("application/json")
    public Response rechercheEmploisParLieu(@PathParam(value="lieu") String lieu) {
 	   
    	return Response.ok(sc.rechercheEmploisparLieu(lieu), MediaType.APPLICATION_JSON).build();
    	
       }
    
    @GET
    @Path("ListeEntreprisesAuxQuelsCandidatEstAbonne/{idCandidat}")
    @Produces("application/json")
    public Response ListeEntreprisesAuxQuelsCandidatEstAbonne(@PathParam(value="idCandidat") int idCandidat) {
 	   
    	return Response.ok(sc.ListeEntreprisesAuxQuelsCandidatEstAbonne(idCandidat), MediaType.APPLICATION_JSON).build();
    	
       }
    
    @GET
    @Path("VerifierCompte/{token}")
    @Produces("application/json")
    public Response VerifierCompte(@PathParam(value="token") String token) {
 	   
    	return Response.ok(sc.VerifierCompte(token), MediaType.APPLICATION_JSON).build();
    	
       }
    
    @GET
    @Path("rechercheEmploisParEntreprise/{idEntreprise}")
    @Produces("application/json")
    public Response rechercheEmploisParEntreprise(@PathParam(value="idEntreprise") int idEntreprise) {
 	   
    	return Response.ok(sc.rechercheEmploisparEntreprise(idEntreprise), MediaType.APPLICATION_JSON).build();
    	
       }
    
    @GET
    @Path("ContactsDansEntreprise/{idCandidat}/{idEntreprise}")
    @Produces("application/json")
    public Response ContactsDansEntreprise(@PathParam(value="idCandidat") int idCandidat,@PathParam(value="idEntreprise") int idEntreprise) {
 	   
    	return Response.ok(sc.ContactsParEntreprise(idCandidat, idEntreprise), MediaType.APPLICATION_JSON).build();
    	
       }
    
    
    @GET
    @Path("ContactsdeCandidat/{idCandidat}")
    @Produces("application/json")
    public Response ContactsCandidat(@PathParam(value="idCandidat") int idCandidat) {
 	   
    	return Response.ok(sc.AfficherContactsCandidat(idCandidat), MediaType.APPLICATION_JSON).build();
    	
       }
    
    @GET
    @Path("AllOffres")
    @Produces("application/json")
    public Response Offres() {
    	return Response.ok(sc.getAllOffres(), MediaType.APPLICATION_JSON).build();
    	
       }
    
    @GET
    @Path("AllCompanies")
    @Produces("application/json")
    public Response Companies() {
    	return Response.ok(sc.getAllCompanies(), MediaType.APPLICATION_JSON).build();
    	
       }
    
    @DELETE
    @Path("desabonnerCandidat/{idC}/{idA}")
    @Produces("application/json")
    public Response desabonnerCandidat(@PathParam(value="idC") int idC, @PathParam(value="idA") int idA) {
 	   
 	return Response.ok(sc.DesabonnerCandidat(idC, idA), MediaType.APPLICATION_JSON).build();
 	
    }
    
    @DELETE
    @Path("depostulerPourOffre/{idC}/{idO}")
    @Produces("application/json")
    public Response depostulerPourOffre(@PathParam(value="idC") int idC, @PathParam(value="idO") int idO) {
 	   
 	return Response.ok(sc.DepostulerPourOffre(idC, idO), MediaType.APPLICATION_JSON).build();
 	
    }
    
    @GET
    @Path("offre/{id}")
	@Produces("application/json")
	public Response getOffrebyId(@PathParam(value="id") int id) {
		
				return Response.ok(sc.getOffrebyId(id), MediaType.APPLICATION_JSON).build();

	}

    @GET
    @Path("company/{id}")
	@Produces("application/json")
	public Response getCompanybyId(@PathParam(value="id") int id) {
		
				return Response.ok(sc.getCompanybyId(id), MediaType.APPLICATION_JSON).build();

	}

    @GET
    @Path("followers/{id}")
	@Produces("application/json")
	public Response followers(@PathParam(value="id") int id) {
		
				return Response.ok(sc.followers(id), MediaType.APPLICATION_JSON).build();

	}

    @POST
    @Path("DesabonnerAEntreprise/{idCandidat}/{idCompanyManager}")
    @Produces("application/json")
    public Response DesabonnerAEntreprise(@PathParam(value="idCandidat") int idCandidat,@PathParam(value="idCompanyManager") int idCompanyManager) {
    	
		return Response.ok(sc.DessabonnerAEntreprise(idCandidat, idCompanyManager), MediaType.APPLICATION_JSON).build();
    	
    }

    
}
