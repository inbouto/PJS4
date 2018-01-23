package donnees;

import java.util.HashMap;
import java.util.Map;

import core.InterfaceBDD;
import donnee.InterfaceDonnee;

public class Dictionnaire implements InterfaceBDD {
	Map<String, InterfaceDonnee> dico = new HashMap<>(); 
	
	public Dictionnaire(){
		this.dico = new HashMap<String, InterfaceDonnee>();
	}

	@Override
	public InterfaceDonnee getElement(String s) {
		 InterfaceDonnee r = dico.get(s);
		 
		 if(){
			 
		 }
		return r;
	}

	@Override
	public void addElement(InterfaceDonnee d) {
		this.dico.put(d.getNom(), d);
	}

	@Override
	public InterfaceBDD getBDD() {
		return this;
	}

	@Override
	public void deleteElement(InterfaceDonnee d) {
		
	}
}
