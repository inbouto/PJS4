package core;

public abstract class CoreComponentManager {

	private static Class<? extends CoreComponent> loadedComponent;
	
	public static void init(Class<? extends CoreComponent> c){
		loadedComponent = c;
	}
	
	protected static Class<? extends CoreComponent> getComponentClass(){
		return loadedComponent;
	}
	
	public static CoreComponent getComponent() {
		try {
			return loadedComponent.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
}
