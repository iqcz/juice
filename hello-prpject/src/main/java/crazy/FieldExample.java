package crazy;

import java.lang.reflect.Field;

class Person {
	private String name;
	private int age;

	public String toString() {
		return "Person[name:" + name + ", age:" + age + "]";
	}
}

public class FieldExample {

	public static void main(String[] args)
			throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		Person p = new Person();

		Class<Person> clazz = Person.class;

		Field nameField = clazz.getDeclaredField("name");
		nameField.setAccessible(true);
		nameField.set(p, "LYN");

		Field ageField = clazz.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.set(p, 27);

		System.out.println(p);
	}

}
