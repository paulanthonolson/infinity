package cscmatchtest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestClass {
	private String name = null;
	private Class<?> clazz = null;
	private Constructor<?> constructor = null;
	private String constructorError = null;

	public TestClass(String name, Class<?>... parameters) {
		this.name = name;
		try {
			clazz = Class.forName(name);
			constructor = clazz.getDeclaredConstructor(parameters);
		} catch (ClassNotFoundException e) {
			// We can ignore this
		} catch (NoSuchMethodException e) {
			this.constructorError = e.getMessage();
		}
	}

	public String getName() {
		return name;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public Constructor<?> getConstructor() {
		return constructor;
	}

	public String getConstructorError() {
		return constructorError;
	}

	public Object newInstance(Object... parameters)
			throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		return constructor.newInstance(parameters);
	}
}
