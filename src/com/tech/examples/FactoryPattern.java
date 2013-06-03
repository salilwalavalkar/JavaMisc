package com.tech.examples;

/**
 * Factory Design Pattern
 * 
 * Factory pattern encapsulate object creation logic which makes it easy to
 * change it later when you change how object gets created or you can even
 * introduce new object with just change in one class. In GOF pattern list
 * Factory pattern is listed as Creation design pattern. Factory should be an
 * interface and clients first either creates factory or get factory which later
 * used to create objects.
 * 
 * Ref: http://javarevisited.blogspot.in/2011/12/factory-design-pattern-java-example.html
 * 
 */
interface Currency {
	String getSymbol();
}

// Concrete Rupee Class code
class Rupee implements Currency {
	@Override
	public String getSymbol() {
		return "Rs";
	}
}

// Concrete SGD class Code
class SGDDollar implements Currency {
	@Override
	public String getSymbol() {
		return "SGD";
	}
}

// Concrete US Dollar code
class USDollar implements Currency {
	@Override
	public String getSymbol() {
		return "USD";
	}
}

// Factory Class
class CurrencyFactory {

	public static Currency createCurrency(String country) {
		if (country.equalsIgnoreCase("India")) {
			return new Rupee();
		} else if (country.equalsIgnoreCase("Singapore")) {
			return new SGDDollar();
		} else if (country.equalsIgnoreCase("US")) {
			return new USDollar();
		}
		throw new IllegalArgumentException("No such currency");
	}
}

// Factory client code
public class FactoryPattern {
	public static void main(String args[]) {
		String country = args[0];
		Currency rupee = CurrencyFactory.createCurrency(country);
		System.out.println(rupee.getSymbol());
	}
}