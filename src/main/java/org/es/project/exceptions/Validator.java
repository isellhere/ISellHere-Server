package org.es.project.exceptions;

public class Validator {
	
	public static boolean isEmpty(String target) {
		if (target == null || target.isEmpty()) {
			return true;
		}
	
		return false;
	}
	
	public static boolean isEmpty(Object target) {
		if (target == null) {
			return true;
		}
		
		return false;
	}

}
