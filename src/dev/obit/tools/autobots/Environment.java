package dev.obit.tools.autobots;

public enum Environment {
	
	UNIX, LINUX, DARWIN, WINDOWS;
	
	private static Environment current;
	
	public static void setEnvironment(String os) {
		String t = os.toLowerCase();
		if(t.contains("nix")) {
			current = Environment.UNIX;
		}else if(t.contains("nux")) {
			current = Environment.LINUX;
		}else if(t.contains("darw")) {
			current = Environment.DARWIN;
		}else if(t.contains("wind")) {
			current = Environment.WINDOWS;
		}else {
			current = null;
		}
		
	}
	
	public static Environment getEnvironment() {
		return current;
		
	}

}
