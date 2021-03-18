package tn.esprit.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class InterviewPK implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private int idCompanyManager;
	private int idCandidate;
	
	public int getIdCompanyManager() {
		return idCompanyManager;
	}
	public void setIdCompanyManager(int idCompanyManager) {
		this.idCompanyManager = idCompanyManager;
	}
	public int getIdCandidate() {
		return idCandidate;
	}
	public void setIdCandidate(int idCandidate) {
		this.idCandidate = idCandidate;
	}
	@Override
	public String toString() {
		return "InterviewPK [idCompanyManager=" + idCompanyManager + ", idCandidate=" + idCandidate + "]";
	}
	public InterviewPK(int idCompanyManager, int idCandidate) {
		super();
		this.idCompanyManager = idCompanyManager;
		this.idCandidate = idCandidate;
	}
	public InterviewPK() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idCandidate;
		result = prime * result + idCompanyManager;
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
		InterviewPK other = (InterviewPK) obj;
		if (idCandidate != other.idCandidate)
			return false;
		if (idCompanyManager != other.idCompanyManager)
			return false;
		return true;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
