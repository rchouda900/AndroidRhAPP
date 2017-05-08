package com.example.services;

import java.util.List;

import com.example.entités.Compte;

public interface CompteService {

	public Compte getCompte(String login);
	public Compte getCompteByEmail(String email);
	public long deleteCompte(String login);
	public Compte createCompte (Compte compte);
	public int updateMdp (String login,String mdp);
	public List <Compte> getAllCompte();
	

	
}
