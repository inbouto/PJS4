package donnees;

import donnee.InterfaceDonnee;

public class Mot implements InterfaceDonnee {
	
	private String libelle;
	private String def;
	//private TypeMot type; si jamais on vient à classifier les types de mot
	
	public Mot (String s){
		this.libelle = s;
	}

	@Override
	public String getNom() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

}
