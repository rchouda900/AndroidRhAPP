package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.entités.Compte;
import com.example.services.CompteService;

@RestController
@RequestMapping(value="/comptes")
public class CompteController {
	
	@Autowired
	public CompteService compteservice;
	
	@RequestMapping (method=RequestMethod.GET,value="/retourner/{login}")
	public Compte getCompte(@PathVariable(value="login") String login)
	{
		return compteservice.getCompte(login);
	}
	
	
	@RequestMapping (method=RequestMethod.DELETE,value="/supprimer/{login}")
	public long deleteCompte(@PathVariable(value="login") String login)
	{
		return compteservice.deleteCompte(login);
	}
	
	@RequestMapping (method=RequestMethod.POST,value="/creer/{login}/{mdp}/{email}")
	public Compte créerCompte(@PathVariable(value="login") String login,@PathVariable(value="mdp") String mdp,@PathVariable(value="email") String email)
	{
		if (getCompte(login)==null)
		{
		Compte cp=new Compte(login,mdp,email);
		return compteservice.createCompte(cp);
		}
		else return null;
	}
	
	@RequestMapping (method=RequestMethod.PUT,value="/modifier/{login}/{mdp}")
	public int ModifierCompte(@PathVariable(value="login") String login,@PathVariable(value="mdp") String mdp)
	{
		return compteservice.updateMdp(login, mdp);
	}

	
	@RequestMapping (method=RequestMethod.GET,value="/afficheremail/{email}")
	public Compte getCompteByEmail(@PathVariable(value="email") String email)
	{
		return compteservice.getCompteByEmail(email);
	}
	
	
	@RequestMapping (method=RequestMethod.GET,value="/affichertous")
	public List <Compte> getCompteAll()
	{
		return compteservice.getAllCompte();
	}
	
	
	
}
