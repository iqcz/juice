package com.packt.mvneclipse.constructordemo;

class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.setName(name);
		this.setAge(age);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Student extends Person {
	private String school;

	public Student(String name, int age, String school) {
		super(name, age);
		this.setSchool(school);
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}
}

public class SuperDemo {
	
	public static void main(String ...args) {
		Student s = new Student("Nick", 30, "qinghua");
		System.out.println(s.getName() + ", " + s.getAge() + ", " + s.getSchool());
	}

}
