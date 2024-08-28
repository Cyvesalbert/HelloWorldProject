package ht.helloworld;

import java.io.Serializable;

public class Personne implements Serializable {
	private String nom;
	private String prenom;
	private int  age;
	private String rue;
	private String ville;
	private String pays;
	private String telephone;
	private String nif;
	
	public Personne(String nom, String prenom, int age, String rue, String ville, String pays, String telephone, String nif ) {
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setAge(age);
		this.setRue(rue);
		this.setVille(ville);
		this.setPays(pays);
		this.setTelephone(telephone);
		this.setNif(nif);
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getRue() {
		return rue;
	}

	public void setRue(String rue) {
		this.rue = rue;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNif() {
		return nif;
	}

	public void setNif(String nif) {
		this.nif = nif;
	}
	
	public String toString() {
		return this.nom + " = " + this.prenom + " = " + this.age + " = " + this.rue + " = " + this.ville +
				" = " + this.pays + " = " + this.telephone + " = " + this.nif ;
	}
	
	

}
