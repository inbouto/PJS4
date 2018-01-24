package ia;

import core.Core;
import core.CoreComponent;
import core.CoreComponentManager;
import core.InterfaceIA;

public class IAV1 implements InterfaceIA, CoreComponent {

	//Ceci est une utilisation de bloc statique pour appeller le CoreComponentManager correspondant à l'IA
	static{
		CoreComponentManager.init(IAV1.class);
	}
	
	@Override
	public String genererReponse(String question) {
		return "Her name is Caroline";
	}

	
	//Ceci est un exemple de comment un CoreComponent s'initialise au sein du core.
	
	@Override
	public void init() {
		Core.setIa(this);
	}

}
