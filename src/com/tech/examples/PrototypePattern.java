package com.tech.examples;

/**
 * Prototype Design Pattern
 * 
 * A prototype is a template of any object before the actual object is
 * constructed. In java also, it holds the same meaning. Prototype design
 * pattern is used in scenarios where application needs to create a number of
 * instances of a class, which has almost same state or differs very little.
 * 
 * In this design pattern, an instance of actual object (i.e. prototype) is
 * created on starting, and thereafter whenever a new instance is required, this
 * prototype is cloned to have another instance. The main advantage of this
 * pattern is to have minimal instance creation process which is much costly
 * than cloning process.
 * 
 * Important: Please ensure that you want to deep clone or shallow clone your
 * prototype because both will have different behavior on runtime. If deep copy
 * is needed, you can use a good technique given here using in memory
 * serialization.
 * 
 * Following sample java source code demonstrates the prototype pattern. We have
 * a basic bike in hand with four gears. We want to make a different object,
 * an advance bike with six gears We copy the existing instance. Then make
 * necessary modifications to the copied instance.
 * 
 * The Prototype pattern is much more than Clone. Clone semantics are broader,
 * meaning the scalars/value fields of one object instance are duplicated in a
 * new instance such that they have the equivalent state but occupy different
 * locations in memory. Clone can be used to support many different needs.
 * 
 * The Prototype pattern incorporates Clone specifically into resolving the
 * larger problem of separating object construction from object use. Prototype
 * semantics state that the only (or at least the supported/preferred) method
 * for constructing a new object of required behavior is by Cloning a particular
 * instance, known as the prototype instance. These prototype instances can live
 * in a prototype factory, which is implemented to create new instances by
 * calling Clone on the prototype instances. The prototype instances can be
 * initialized via dependency injection. The injecting code is the only code
 * that needs to know how to build the prototype instances, and this effectively
 * becomes the real factory code.
 */

class Bike implements Cloneable {
	@SuppressWarnings("unused")
	private int gears;
	@SuppressWarnings("unused")
	private String bikeType;
	private String model;

	public Bike() {
		bikeType = "Standard";
		model = "Leopard";
		gears = 4;
	}

	public Bike clone() {
		return new Bike();
	}

	public void makeAdvanced() {
		bikeType = "Advanced";
		model = "Jaguar";
		gears = 6;
	}

	public String getModel() {
		return model;
	}
}

public class PrototypePattern {
	public Bike makeJaguar(Bike basicBike) {
		basicBike.makeAdvanced();
		return basicBike;
	}

	public static void main(String args[]) {
		Bike bike = new Bike();
		Bike basicBike = bike.clone();
		PrototypePattern workShop = new PrototypePattern();
		Bike advancedBike = workShop.makeJaguar(basicBike);
		System.out.println("Prototype Design Pattern: "
				+ advancedBike.getModel());
	}
}