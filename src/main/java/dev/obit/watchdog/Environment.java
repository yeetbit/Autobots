package dev.obit.watchdog;

import java.util.ArrayList;
import java.util.Collection;

public enum Environment {
	
	UNIX, LINUX, DARWIN, WINDOWS, NULL;
	
	private static Environment current;
	
	public static void setEnvironment(String os) {
		String t = os.toLowerCase();
		if(t.contains("nix")) {
			current = Environment.UNIX;
		}else if(t.contains("nux")) {
			current = Environment.LINUX;
		}else if(t.contains("darw")) {
			current = Environment.DARWIN;
		}else if(t.contains("indo")) {
			current = Environment.WINDOWS;
		}else {
			current = null;
		}
		
	}
	
	public static Environment getEnvironment() {
		return current;
		
	}
	
	public static Collection<Environment> getAll(){
		Collection<Environment> envors = new ArrayList<>();
		for(Environment e : Environment.values()) {
			envors.add(e);
		};
		return envors;
		
	}

}
