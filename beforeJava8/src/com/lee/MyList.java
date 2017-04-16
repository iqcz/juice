package com.lee;

/**
 * Type parameters in chained method calls
 * Another common problem with type inference is when methods are chained together. 

 * @author TurtusLi
 *
 * @param <T>
 */
public class MyList<T> {
    
    static <T> MyList<T> emptyList() {
	return new MyList<T>();
    }
    
    MyList<T> add(T t) {
	// TODO add element
	
	return this;
    }

    public static void main(String ... args) {
	// This was due to be fixed in Java 8, but unfortunately it was dropped. 
	// So, at least for now, you'll still need to explicitly offer up a type to the compiler; 
	// you'll still need a type witness.
	MyList<String> myList = MyList.<String>emptyList().add("One").add("two").add("second");
	
	System.out.println(myList);
    }
}
