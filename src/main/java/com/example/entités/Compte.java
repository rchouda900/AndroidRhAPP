package com.example.entités;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.*;

import org.hibernate.validator.constraints.Email;

@Entity
public class Compte implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long compteid;
	
	@Column(nullable=false,unique=true)
	private String login;
	
	@Column(nullable=false)
	private String mdp;
	
	@Column(unique=true,nullable=false)
	@Email
	private String email;
	


	public Compte() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Compte(String login, String mdp, String email) {
		super();
		this.login = login;
		this.mdp = mdp;
		this.email = email;
	}
	

	
	

	public long getCompteid() {
		return compteid;
	}

	public void setCompteid(long compteid) {
		this.compteid = compteid;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	@OneToMany(mappedBy="compte",cascade={CascadeType.REMOVE,CascadeType.MERGE})
	private Collection <Etat> etats;
	
	

}
