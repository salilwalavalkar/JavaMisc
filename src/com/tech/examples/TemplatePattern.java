package com.tech.examples;

/**
 * Template Design Pattern
 * 
 * Template method pattern is a behavioral design pattern which provide base method for algorithm,called template method which defers 
 * some of its steps to subclasses So algorithm structure is same but some of its steps can be redefined by subclasses according to context.
 *
 * Use when:
 *   - When you have a preset format or steps for algorithm but implementation of steps may vary.
 *   - When you want to avoid code duplication,implementing common code in base class and variation in subclass.
 */
abstract class CrossCompiler {

	/**
	 * Note: Main template method in super class should not be overriden so making it final.
	 */
	public final void crossCompile() {
		collectSource();
		compileToTarget();
	}

	/*
	 * Hook methods are intended to be overridden, concrete
	 * methods are not
	 */
	protected abstract void collectSource();

	/*
	 * Hook methods are intended to be overridden, concrete
	 * methods are not
	 */
	protected abstract void compileToTarget();
}

class IPhoneCompiler extends CrossCompiler {
	@Override
	protected void collectSource() {
		System.out.println("Collect source : IPhone");
	}
	@Override
	protected void compileToTarget() {
		System.out.println("Compile to target : IPhone");
	}

}

class AndroidCompiler extends CrossCompiler {
	@Override
	protected void collectSource() {
		System.out.println("Collect source : Android");
	}
	@Override
	protected void compileToTarget() {
		System.out.println("Compile to target : Android");
	}
}

public class TemplatePattern {
	public static void main(String[] args) {
		CrossCompiler iphone = new IPhoneCompiler();
		iphone.crossCompile();

		CrossCompiler android = new AndroidCompiler();
		android.crossCompile();
	}
}