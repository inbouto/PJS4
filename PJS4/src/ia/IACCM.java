package ia;

import core.CoreComponentManager;
import core.InterfaceIA;

public abstract class IACCM extends CoreComponentManager{
	
	public static InterfaceIA genererIA() {
		return new IAV1();
	}
	

}
