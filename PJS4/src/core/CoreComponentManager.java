package core;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;

public class CoreComponentManager {

	//WARNING : N'EST PAS THREAD-SAFE !!!!!
	
	//TODO: TESTS
	static{
		loadedComponents = new ArrayList<Class<? extends CoreComponent>>();
	}
	
	private static List<Class<? extends CoreComponent>> loadedComponents;
	
	public static void init(Class<? extends CoreComponent> c){
		loadedComponents.add(c);
	}
	
	
	
	public static void getComponent() {
		try {
			for(Class<? extends CoreComponent> c : loadedComponents)
				c.newInstance().init();
			} catch (InstantiationException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
}
