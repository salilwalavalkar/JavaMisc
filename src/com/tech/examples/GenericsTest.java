package com.tech.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;


public class GenericsTest {

	public static void main(String[] args) {
		testPrinntCollections();
		testGenericsDeclarations();
	}
	
	/**
	 * If you are writing Generics method than you need to declare type
	 * parameters in method signature between method modifiers and return type
	 */
	public static <T> T identical(T source){
	    return source;
	}

	/**************************************** EXAMPLE 1 - Starts ****************************************************************/
	@SuppressWarnings({ "unused", "rawtypes" })
	private static void testGenericsDeclarations() {
		
		//Parametrized type like Set<T> is subtype of raw type Set and you can assign Set<T> to Set
		Set setOfRawType = new HashSet<String>();
		setOfRawType = new HashSet<Integer>();

		// Set<Object> is setOfAnyType, it can store String, Integer but you can not assign setOfString or setOfInteger to setOfObject using Generics
		Set<Object> setOfAnyType = new HashSet<Object>();
		setOfAnyType.add("abc"); //legal
		setOfAnyType.add(new Float(3.0f)); //legal - <Object> can accept any type

		// Set<?> represents SetOfUnknownType and you can assign SetOfString or SetOfInteger to Set<?>
		Set<?> setOfUnknownType = new LinkedHashSet<String>();
		setOfUnknownType = new LinkedHashSet<Integer>();

		Set<? extends Number> setOfAllSubTypeOfNumber = new HashSet<Integer>(); //legal - Integer extends Number
		setOfAllSubTypeOfNumber = new HashSet<Float>(); //legal - because Float extends Number
		
		Set<? super TreeMap> setOfAllSuperTypeOfTreeMap = new LinkedHashSet<TreeMap>(); //legal because TreeMap is superType of itself

		setOfAllSuperTypeOfTreeMap = new HashSet<SortedMap>(); //legal because SorteMap is super class of TreeMap
		setOfAllSuperTypeOfTreeMap = new LinkedHashSet<Map>(); //legal since Map is super type of TreeMap
		
		// List.class //legal
		// List<String>.class  //illegal

		ArrayList<?> unknownList = new ArrayList<Number>();
		unknownList = new ArrayList<Float>();

		ArrayList<? extends Number> numberList = new ArrayList<Number>();
		numberList = new ArrayList<Integer>();
		numberList = new ArrayList<Float>();

		ArrayList<? super Integer> numberList2 = new ArrayList<Number>();
		numberList2 = new ArrayList<Integer>();
		//numberList2 = new ArrayList<Float>(); //compilation error
	}
	/**************************************** EXAMPLE 1 - Ends ****************************************************************/

	/**************************************** EXAMPLE 2 - Starts ****************************************************************/
	private static void testPrinntCollections() {
		List<String> strList = Arrays.asList("ABC", "PQR");
		PrintCollections co = new PrintCollections();
		co.printCollection1(strList); // valid
		//co.printCollection2(strList); // not valid
		co.printCollection3(strList); // valid
		co.printCollection4(strList); // valid
	}
}

class PrintCollections
{
	// Raw [Will take string list]
	@SuppressWarnings("rawtypes")
	void printCollection1(Collection c) {
		Iterator i = c.iterator();
		for (int k = 0; k < c.size(); k++) {
			System.out.println(i.next());
		}
	}
	
	// Version 2 [Will NOT take string list]
	void printCollection2(Collection<Object> c) {
		for (Object e : c) {
			System.out.println(e);
		}
	}
		
	// Unbounded wildcard - Version 3 - [Will take string list]
	void printCollection3(Collection<?> c) {  
											
		for (Object o : c) {
			System.out.println(o);
		}
	}
	
	// generic method with type parameters, that is, without using wildcards - 
	// Version 4 - [Will take string list]
	<T> void printCollection4(Collection<T> c) {  
											
		for (T o : c) {
			System.out.println(o);
		}
	}
}
/**************************************** EXAMPLE 2 - Ends ****************************************************************/

/**************************************** EXAMPLE 3 - Starts ****************************************************************/
class someClass<T> {
	public List<T> someMethod() {
		List<T> list = Collections.<T> emptyList();
		// ...
		return list;
	}

	@SuppressWarnings("unused")
	public static <S> void anotherMethod(S arg) {
		List<S> list = Collections.<S> emptyList();
		// ...
	}
}
/**************************************** EXAMPLE 3 - Ends ****************************************************************/

/**************************************** EXAMPLE 4 - Starts ****************************************************************/
class ReverseGenericMethod {

	/* How do I implement a method that takes a wildcard argument?
	 * Using the wildcard type List<?> we can neither create a temporary copy of
	 * the argument nor can we invoke the set method
	 */
//	public static void reverse1(List<?> list) {
//		List<?> tmp = new ArrayList<?>(list); // error
//		for (int i = 0; i < list.size(); i++) {
//			tmp.set(i, list.get(list.size() - i - 1)); // error
//		}
//		list = tmp;
//	}
	

	public static <T> void reverse3(List<T> list) {
		List<T> tmp = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			tmp.set(i, list.get(list.size() - i - 1));
		}
		list = tmp;
	}
	
}

/**************************************** EXAMPLE 4 - Ends ****************************************************************/

/**************************************** EXAMPLE 5 - Starts ****************************************************************/
class Queue<T> {
	private LinkedList<T> items = new LinkedList<T>();

	public void enqueue(T item) {
		items.addLast(item);
	}

	public T dequeue() {
		return items.removeFirst();
	}

	public boolean isEmpty() {
		return (items.size() == 0);
	}
}

class Stack<T> {
	private List<T> content;

	public Stack() {
		content = new LinkedList<T>();
	}

	public void push(T item) {
		content.add(item);
	}

	public T top() {
		return content.get(0);
	}

	public T pop() {
		return content.remove(0);
	}

	public boolean isEmpty() {
		return content.isEmpty();
	}
}
/**************************************** EXAMPLE 5 - Ends ****************************************************************/

/**************************************** EXAMPLE 6 - Starts ****************************************************************/
class OldBox {
	Object data;

	public OldBox(Object data) {
		this.data = data;
	}

	public Object getData() {
		return data;
	}
}

class Box<E> {
	E data;

	public Box(E data) {
		this.data = data;
	}

	public E getData() {
		return data;
	}
	
	public void copyFrom(Box<E> b) {
		this.data = b.getData();
	}	
}

class MathBox<E extends Number> extends Box<Number> {
	public MathBox(E data) {
		super(data);
	}
	public double sqrt() {
		return Math.sqrt(getData().doubleValue());
	}
}

/**
 * Fix foo and vary parameter to aMethod()
 */
class Foo {
	// Foo is not parameterized
	public <T> T aMethod(T x) {
		// will not compile without <T>
		// to indicate that this is a
		// parameterized method.
		return x;
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Foo foo = new Foo();
		int k = foo.aMethod(5);
		String s = foo.aMethod("abc");
	}
}

/**
 * Once Bar<T>object is fixed, we are locked to a specific T.
 */
class Bar<T> {
	//Bar is parameterized 
	public T aMethod(T x) 
	{
		return x;
	}
	
	@SuppressWarnings("unused")
	public static void main(String[] args) 
	{
		Bar<Integer> bar = new Bar<Integer>(); 
		int k = bar.aMethod(5);
		//String s = bar.aMethod("abc"); //Compilation error here
	}
}
/**************************************** EXAMPLE 6 - Ends ****************************************************************/

