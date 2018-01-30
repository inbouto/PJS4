package coreComponents;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

import core.ICoreComponent;
import core.ICoreComponentManager;
import core.InterfaceDonnees;
import core.InterfaceIA;
import core.InterfaceIHM;

public class CoreComponentManager implements ICoreComponentManager {

	
	private ArrayList<Class<? extends ICoreComponent>> loadedComponents;
	private InterfaceIHM ihm;
	private InterfaceIA ia;
	private String initFile;
	private InterfaceDonnees donnees;

	//WARNING : N'EST PAS THREAD-SAFE !!!!!
	
	//TODO: TESTS
	
	
	//Le nom par défaut des Component à charger est "init"
	public CoreComponentManager() {
		this("init");
	}
	
	public CoreComponentManager(String initFile) {
		this.initFile = initFile;
		loadedComponents = new ArrayList<Class<? extends ICoreComponent>>();
	}

	public void add(Class<? extends ICoreComponent> c){
		loadedComponents.add(c);
	}

	
	
	//Cette fonction initialise la liste des components, puis charge dans l'ordre les components précisés
	@Override
	public void initComponents() {
		try {
			getComponentsFromFile(initFile);
		} catch (ClassNotFoundException e1) {
			System.err.println("Le CoreComponent spécifié dans le fichier " + initFile + " n'existe pas");
			e1.printStackTrace();
		} catch (IOException e1) {
			System.err.println("Le fichier d'initialisation n'a pas pu être chargé");
			e1.printStackTrace();
		}
		for(Class<? extends ICoreComponent> c : loadedComponents){
			try {
				ICoreComponent cc = c.newInstance();
				switch(cc.getCoreComponentType()){
				case IA:
					//TODO: Code sale, peut-on faire autrement qu'un cast ???
					this.ia = (InterfaceIA) cc;
					break;
				case Donnees:
					//TODO: implémenter les donnees
					//this.donnees = (InterfaceDonnees) cc;
					break;
				case IHM:
					this.ihm = (InterfaceIHM) cc;
					break;
				default:
					throw new UnknownComponentTypeException();
				}
			} catch (InstantiationException | IllegalAccessException | UnknownComponentTypeException e) {
				System.err.println("Le CoreComponent : " + c.toString() + "n'a pas pu être lancé");
				e.printStackTrace();
			}
		}
	}

	
	
	//Cette fonction charge tous les Components précisés dans le fichier d"initialisation
	private void getComponentsFromFile(String string) throws IOException, ClassNotFoundException {
		for(String s : Files.readAllLines(FileSystems.getDefault().getPath(string))){
			if(ICoreComponent.class.isAssignableFrom(Class.forName(s))){
				//ENCORE UN CAST (meme avec le if, c'est sale)
				this.add((Class<? extends ICoreComponent>) Class.forName(s));
				System.out.println(s + " ajouté à la liste des Components chargés");
			}
		}
	}

	@Override
	public InterfaceIA getIA() {
		return ia;
	}

	@Override
	public InterfaceIHM getIHM() {
		return ihm;
	}

	@Override
	public InterfaceDonnees getDonnees() {
		return donnees;
	}
	
	
	
}
