package com.example.services;

import java.util.Date;

import com.example.entités.Etat;

public interface EtatService {
	
	public Etat getEtat(long numetat);
	public long deleteEtat(long numetat);
	public Etat createEtat(Etat etat);
	public int updateEtat(String libelle,Date date,long compteid,long numetat);
	public int updateEtatNum(long numetat,String libelle,long compteid);
	

}
