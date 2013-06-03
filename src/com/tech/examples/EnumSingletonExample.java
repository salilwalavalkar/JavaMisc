package com.tech.examples;

/**
 * Singleton Enum - Josh Bloch recommends using a single-element enum type to
 * implement singletons (see Effective Java 2nd Edition, Item 3: Enforce the
 * singleton property with a private constructor or an enum type).
 * 
 *         This approach [...] is more concise, provides the serialization
 *         machinery for free, and provides an ironclad guarantee against
 *         multiple instantiations, even in the face of sophisticated
 *         serialization or reflection attacks. While this approach has yet to
 *         be widely adopted, a single-element enum type is the best way to
 *         implement a singleton.
 * 
 *         On enum constant singleton guarantee: An enum type has no instances
 *         other than those defined by its enum constants.
 * 
 *         It is a compile-time error to attempt to explicitly instantiate an
 *         enum type. The final clone method in Enum ensures that enum constants
 *         can never be cloned, and the special treatment by the serialization
 *         mechanism ensures that duplicate instances are never created as a
 *         result of deserialization. Reflective instantiation of enum types is
 *         prohibited. Together, these four things ensure that no instances of
 *         an enum type exist beyond those defined by the enum constants.
 * 
 */

public enum EnumSingletonExample {
	INSTANCE;
	public void method1() {
		System.out.println("Method 1");
	}

	public String method2() {
		System.out.println("Method 2");
		return "Method2";
	}
}
