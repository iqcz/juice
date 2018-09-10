package upgradingtojava8.chapter04;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.stream.Stream;

/**
 * the usage of map and mapToLong method.
 * @author i324779
 *
 */
public class StreamMapDemo {

    class Employee {

        public String name;
        public LocalDate birthday;

        public Employee(String name, LocalDate birthday) {
            this.name = name;
            this.birthday = birthday;
        }
    }

    public Employee[] getEmployees() {
        Employee[] employees = { new Employee("Will Biteman", LocalDate.of(1984, Month.JANUARY, 1)),
                new Employee("Sue Everyman", LocalDate.of(1980, Month.DECEMBER, 25)),
                new Employee("Ann Wangi", LocalDate.of(1976, Month.JULY, 4)),
                new Employee("Wong Kaching", LocalDate.of(1980, Month.SEPTEMBER, 1)) };
        return employees;
    }

    public double calculateAverageAge(Employee[] employees) {
        LocalDate today = LocalDate.now();
        Stream<Employee> stream = Stream.of(employees);
        Stream<Period> periods = stream.map((employee) -> Period.between(employee.birthday, today));

        return periods.mapToLong(Period::toTotalMonths).average().getAsDouble() / 12;
    }

    public static void main(String[] args) {
        StreamMapDemo demo = new StreamMapDemo();
        Employee[] employees = demo.getEmployees();
        double avgAge = demo.calculateAverageAge(employees);
        System.out.printf("Average employee age : %2.2f\n", avgAge);
    }
}