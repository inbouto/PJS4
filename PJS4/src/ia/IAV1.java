package ia;

import core.Core;
import core.ICoreComponent;
import core.InterfaceIA;
import coreComponents.ComponentType;
import coreComponents.CoreComponentManager;

public class IAV1 implements InterfaceIA, ICoreComponent {
	
	
	@Override
	public String genererReponse(String question) {
		
		return "Her name is Caroline";
	}

	
	//Ceci est un exemple de comment un CoreComponent s'initialise au sein du core.
	@Override
	public ComponentType getCoreComponentType() {
		return ComponentType.IA;
	}

}
