package com.mybean;

  public class Utilisateur {

    private String email;
    private String motDePasse;
    private String nom;

  
    public void setMotDePasse(String motDePasse) {
      this.motDePasse = motDePasse;
    }
    public String getMotDePasse() {
      return motDePasse;
    }

    public void setNom(String nom) {
      this.nom = nom;
    }
    public String getNom() {
      return nom;
    }
  }

