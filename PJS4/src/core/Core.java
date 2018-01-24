package core;

import ia.IACoreComponentManager;
import ihm.FactoryIHM;

public class Core {
	private static InterfaceIHM ihm;
	private static InterfaceIA ia;
	
	public static void main(String[] args) {
		ia = IACoreComponentManager.genererIA();
		ihm = FactoryIHM.genererIHM();
		while(true)
			ihm.affichage(ia.genererReponse(ihm.saisie()));
	}
}
