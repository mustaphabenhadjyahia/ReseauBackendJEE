package tn.esprit.ressources;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.crypto.spec.SecretKeySpec;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import tn.esprit.services.ServiceCandidat;

@Path("authentification")
public class AuthentificationEndPoint {
	// ======================================
	// = Injection Points =
	// ======================================
	@Context
	private UriInfo uriInfo;
	
	@EJB
	ServiceCandidat sc;
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response authenticateUser(@FormParam("mail") String mail, @FormParam("password") String password) {

	try {
	authenticate(mail, password);
	
	String token = issueToken(password);
	
	return Response.ok(token).build();
	} catch (Exception e) {
	return Response.status(Response.Status.FORBIDDEN).build();
	}
	
	}
	
	private void authenticate(String mail, String password) {
	
		sc.Authentification(mail, password);
	System.out.println("Authenticating user...");
	
	}
	
	private String issueToken(String mail) {
	
	String keyString = "simplekey";
	Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "DES");
	System.out.println("the key is : " + key.hashCode());
	System.out.println("uriInfo.getAbsolutePath().toString() : " +
			uriInfo.getAbsolutePath().toString());
	System.out.println("Expiration date: " + toDate(LocalDateTime.now().plusMinutes(15L)));
	String jwtToken =
	Jwts.builder().setSubject(mail).setIssuer(uriInfo.getAbsolutePath().toString())
	.setIssuedAt(new Date()).setExpiration(toDate(LocalDateTime.now().plusMinutes(15L)))
	.signWith(SignatureAlgorithm.HS512, key).compact();
	System.out.println("the returned token is : " + jwtToken);
	
	return jwtToken;

	
	}
	
	private Date toDate(LocalDateTime localDateTime) {
		return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
		}

}
