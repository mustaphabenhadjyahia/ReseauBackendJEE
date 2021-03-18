package tn.esprit.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Interview implements Serializable {
	private static final long serialVersionUID = 1L;


	@EmbeddedId
	private InterviewPK interviewPK;
	
	@ManyToOne
	@JoinColumn(name = "idCompanyManager",referencedColumnName ="id",insertable=false,updatable=false)
	private CompanyManager companyManager;
	
	
	@ManyToOne
	@JoinColumn(name = "idCandidate",referencedColumnName ="id",insertable=false,updatable=false)
	private Candidate candidate;
	
	
	@Temporal(TemporalType.DATE)
	private Date date;
	
	
	
	public Interview() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public InterviewPK getInterviewPK() {
		return interviewPK;
	}

	public void setInterviewPK(InterviewPK interviewPK) {
		this.interviewPK = interviewPK;
	}

	public CompanyManager getCompanyManager() {
		return companyManager;
	}

	public void setCompanyManager(CompanyManager companyManager) {
		this.companyManager = companyManager;
	}

	public Candidate getCandidate() {
		return candidate;
	}

	public void setCandidate(Candidate candidate) {
		this.candidate = candidate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Interview [interviewPK=" + interviewPK + ", companyManager=" + companyManager + ", candidate="
				+ candidate + ", date=" + date + "]";
	}

	public Interview(InterviewPK interviewPK, CompanyManager companyManager, Candidate candidate, Date date) {
		super();
		this.interviewPK = interviewPK;
		this.companyManager = companyManager;
		this.candidate = candidate;
		this.date = date;
	}
	

}
