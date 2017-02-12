package com.packt.mvneclipse.javainanutshell;


public class Person {

       private String name ;

       private int age ;

       public Person() {

      }

       public Person(String name) {
             this.setName(name);
      }

       public Person(int age) {
             this.setAge(age);
      }

       public Person(String name, int age) {
             this.setName(name);
             this.setAge(age);
      }

       public String getName() {
             return name ;
      }

       public void setName(String name) {
             this.name = name;
      }

       public int getAge() {
             return age ;
      }

       public void setAge(int age) {
             this.age = age;
      }

       public String sayHello(String name, int age) {
             return "Hello, " + this. name + ", you're " + this. age + " years old.";
      }

       @Override
       public String toString() {
             return "Person[name: " + this. name + ", age: " + this. age + "]";
      }
}
