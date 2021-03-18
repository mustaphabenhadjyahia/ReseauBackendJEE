package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class EntrepriseAbonnesPK implements Serializable {
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idAbonne;
		result = prime * result + idCompany;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EntrepriseAbonnesPK other = (EntrepriseAbonnesPK) obj;
		if (idAbonne != other.idAbonne)
			return false;
		if (idCompany != other.idCompany)
			return false;
		return true;
	}
	private static final long serialVersionUID = 1L;
	private int idCompany;
	private int idAbonne;
	
	
	public EntrepriseAbonnesPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getIdCompany() {
		return idCompany;
	}
	public void setIdCompany(int idCompany) {
		this.idCompany = idCompany;
	}
	public int getIdAbonne() {
		return idAbonne;
	}
	public void setIdAbonne(int idAbonne) {
		this.idAbonne = idAbonne;
	}

}
