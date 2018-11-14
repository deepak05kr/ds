package reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class TestingReflection {
	public static void main(String args[]) {
		Class reflectClass = UFOEnemyShip.class;
		String className = reflectClass.getName();
		System.out.println(className);

		int classModifier = reflectClass.getModifiers();
		System.out.println(Modifier.isPublic(classModifier));

		Class[] interfaces = reflectClass.getInterfaces();
		Class classSuper = reflectClass.getSuperclass();
		System.out.println(classSuper.getName());

		Method[] classMethods = reflectClass.getMethods();

		for (Method method : classMethods) {
			System.out.println(method.getName());
			if (method.getName().startsWith("get")) {
				System.out.println("getter method");
			} else if (method.getName().startsWith("set")) {
				System.out.println("setter method");
			}
			System.out.println("return type : " + method.getReturnType());

			Class[] parameterType = method.getParameterTypes();
			for (Class parameter : parameterType) {
				System.out.println(parameter.getName());
			}
			System.out.println();

		}
		Constructor constructor = null;
		Object constructor2 = null;
		try {
			constructor = reflectClass.getConstructor(new Class[] { EnemyShipFactory.class });
			constructor2 = reflectClass.getConstructor(int.class, String.class).newInstance(12, "random string");
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}

		Class[] constructParameters = constructor.getParameterTypes();

		for (Class parameter : constructParameters) {
			System.out.print(parameter.getName() + " ");
		}
		UFOEnemyShip newEnemyShip = null;
		EnemyShipFactory shipFactory = null;
		try {
			newEnemyShip = (UFOEnemyShip) constructor.newInstance(shipFactory);
		} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
				| InvocationTargetException e) {
			e.printStackTrace();
		}
		newEnemyShip.setName("XT-1000");
		System.out.println("Enemy ship name : " + newEnemyShip.getName());

		Field privateStringName = null;
		UFOEnemyShip enemyShipPrivate = new UFOEnemyShip(shipFactory);

		try {
			privateStringName = UFOEnemyShip.class.getDeclaredField("idcode");
			privateStringName.setAccessible(true);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
		try {
			String valueOfName = (String) privateStringName.get(enemyShipPrivate);
			System.out.println("Private field Name: " + valueOfName);
			String methodName = "getPrivate";
			Method privateMethod = UFOEnemyShip.class.getDeclaredMethod(methodName, null);
			privateMethod.setAccessible(true);

			String privateReturnVal = (String) privateMethod.invoke(enemyShipPrivate, null);
			System.out.println(privateReturnVal);
		} catch (IllegalArgumentException | IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
