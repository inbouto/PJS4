package core;

public class Core {
	
	private static ICoreComponentManager CCM;
	
	
	
	
	public static void main(String[] args) {
		
		try {
			CCM = (ICoreComponentManager) Class.forName(args[0]).newInstance();
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			System.err.println("Impossible de charger le CoreComponentManager. L'application va maintenant se fermer.");
			e.printStackTrace();
			System.exit(-1);
		}
		CCM.initComponents();
		
	}
	
	public static InterfaceIA getIA() {
		return CCM.getIA();
	}

	public static InterfaceIHM getIHM() {
		return CCM.getIHM();
	}
	public static InterfaceDonnees getDonnees() {
		return CCM.getDonnees();
	}

	
}
