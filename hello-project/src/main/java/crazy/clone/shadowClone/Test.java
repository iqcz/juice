package crazy.clone.shadowClone;

public class Test {

    public static void main(String[] args) {
        System.out.println("Before Clone:");

        Address address = new Address("China", "Jilin", "Changjun");

        Employee em1 = new Employee("NoSlient", 32, address);
        System.out.println("Employee 1 info: ");
        System.out.println(em1);

        System.out.println("--------");

        System.out.println("After Clone:");
        Employee em2 = em1.clone();

        em2.getAddress().setState("China"); // reference type
        em2.getAddress().setProvince("Liaoning"); // reference type
        em2.getAddress().setCity("Dalian"); // reference type
        em2.setName("Haha");
        em2.setAge(21);

        System.out.println("Employee 2 info:");
        System.out.println(em2);

        System.out.println("Employee 1 info: ");
        System.out.println(em1); // after clone, employee1's address has been changed.

        // after sallow clone, employee 2 and employee1 have the same Address reference, 
        // one changed, the other is also changed.

    }

}
