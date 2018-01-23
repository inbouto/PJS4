package ia;

import core.InterfaceIA;

public abstract class FactoryIA{
	
	public static InterfaceIA genererIA() {
		return new IAV1();
	}

}
