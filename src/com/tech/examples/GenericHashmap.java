package com.tech.examples;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * One noteworthy feature of generic methods is that you needn’t specify the
 * value of the type parameter explicitly as you must when invoking generic
 * constructors. The compiler figures out the value of the type parameters by
 * examining the types of the method arguments. This process is called type
 * inference. You can exploit the type inference provided by generic method
 * invocation to ease the process of creating parameterized type instances. To
 * refresh your memory, the need to pass the values of type parameters
 * explicitly when invoking generic constructors can be annoying. The type
 * parameters appear redundantly on the left- and right-hand sides of variable
 * declarations [This has been removed in Java 1.7]: 
 */
public class GenericHashmap {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		
		// Parameterized type instance creation with constructor
		Map<String, List<String>> anagrams1 = new HashMap<String, List<String>>();
		
		/*
		 * With a generic static factory method, you can replace the repetitious
		 * declaration above with this concise one:
		 */

		// Parameterized type instance creation with static factory
		Map<String, List<String>> anagrams2 = newHashMap();
	}
	
  	/**
  	 * Generic static factory method
	 */
	public static <K,V> HashMap<K,V> newHashMap() {
		return new HashMap<K,V>();
	}	
}