package core;

import ia.IACCM;
import ihm.FactoryIHM;

public class Core {
	
	
	
	
	public static void main(String[] args) {
		ia = IACCM.genererIA();
		ihm = FactoryIHM.genererIHM();
		while(true)
			ihm.affichage(ia.genererReponse(ihm.saisie()));
	}
	
	private static InterfaceIHM ihm;
	private static InterfaceIA ia;
	
	public static void setIhm(InterfaceIHM ihm) {
		Core.ihm = ihm;
	}

	public static void setIa(InterfaceIA ia) {
		Core.ia = ia;
	}

	
}
