package core;

import coreComponents.ComponentType;

public interface ICoreComponentManager {

	public void initComponents();

	public InterfaceIA getIA();

	public InterfaceIHM getIHM();
	
	public InterfaceDonnees getDonnees();
	
}