package ia;

import core.InterfaceIA;

public abstract class FactoryIAV1{
	
	public static InterfaceIA genererIA() {
		return new IAV1();
	}

}
