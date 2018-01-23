package ihm;

import core.InterfaceIHM;

public abstract class IHMFactory{

	public InterfaceIHM creerIHM(){
		return new IHMV1();
	}
}
