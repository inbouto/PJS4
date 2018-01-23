package core;

import donnee.InterfaceDonnee;

public interface InterfaceBDD {
	
	public InterfaceDonnee getElement(String s);
	
	public void addElement(InterfaceDonnee d);
	
	public InterfaceBDD getBDD();
	
	public void deleteElement(InterfaceDonnee d);
	
	
}
