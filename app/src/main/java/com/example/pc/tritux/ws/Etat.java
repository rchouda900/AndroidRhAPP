package com.example.pc.tritux.ws;

import java.util.Date;



public class Etat {

    private long numetat;
    private String creationDate;
    private String modifDate;
    private String lastModifBy;
    private String libelle;

    public long getNumetat() {
        return numetat;
    }

    public void setNumetat(long numEtat) {
        this.numetat = numEtat;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifDate() {
        return modifDate;
    }

    public void setModifDate(String modifDate) {
        this.modifDate = modifDate;
    }

    public String getLastModifBy() {
        return lastModifBy;
    }

    public void setLastModifBy(String lastModifBy) {
        this.lastModifBy = lastModifBy;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
}
