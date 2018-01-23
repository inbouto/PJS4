package ihm;

import core.InterfaceIHM;

public abstract class FactoryIHM{

	public static InterfaceIHM genererIHM(){
		return new IHMV1();
	}
}
