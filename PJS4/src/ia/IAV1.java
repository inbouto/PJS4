package ia;

import core.InterfaceIA;

public class IAV1 implements InterfaceIA {

	//Ceci est une utilisation de bloc statique pour appeller le CoreComponentManager correspondant à l'IA
	static{
		
	}
	
	@Override
	public String genererReponse(String question) {
		return "Her name is Caroline";
	}

}
