package lambdasinaction.mydemo;

/**
 * 定义若干 Employee 实例并加入数组，
 * 把数组转换成 list，
 * 根据 Employee的Last Name 和 First Name 定义比较器。
 * 使用 lambda 和  stream 对 Employee 类进行操作。
 */
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {

    public static void main(String[] args) {
        // 定义Employee类数组
        Employee[] employees = { new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing") };

        // 转换成list
        List<Employee> list = Arrays.asList(employees);

        // 打印全部的Employee信息
        System.out.println("Complete Employee List: ");
        list.stream().forEach(System.out::println);

        System.out.println("-------------------------------");

        // 定义函数式接口，返回boolean值，指定工资范围在大于等于4000小于等于6000的区间。
        Predicate<Employee> four2SixThousand = e -> (e.getSalary() >= 4000
                && e.getSalary() <= 6000);

        // 使用 stream 过滤，排序，再循环遍历打印。
        list.stream().filter(four2SixThousand).sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);

        // 打印比较器区间工资最小的Employee信息
        System.out.printf("%nFirst employee who earns $4000-$6000:%n%s%n", list.stream()
                .filter(four2SixThousand).min(Comparator.comparing(Employee::getSalary)).get());

        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastName;
        // 指定比较器比较规则
        Comparator<Employee> lastThenFistComp = Comparator.comparing(byLastName)
                .thenComparing(byFirstName);

        // 先根据last name 比较，如果相同，再比较 first name。
        System.out.printf("%nEmployees in ascending order by last name then fist name: %n");
        list.stream().sorted(lastThenFistComp).forEach(System.out::println);

        // 先根据first name 比较，如果相同，再比较 last name。
        System.out.printf("%nEmployees in descending order by last name then first:%n");
        list.stream().sorted(lastThenFistComp.reversed()).forEach(System.out::println);

        System.out.printf("%nEmployees by department:%n");
        Map<String, List<Employee>> groupingByDepartment = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        groupingByDepartment.forEach((department, employeesInDepartment) -> {
            System.out.println(department);
            employeesInDepartment.forEach(employee -> System.out.printf(" %s%n", employee));
        });

        // count number of Employees in each department
        System.out.printf("%nCount of Employees by department:%n");
        Map<String, Long> employeeCountByDepartment = list.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));

        employeeCountByDepartment.forEach((department, count) -> {
            System.out.printf("%s has %d employee(s)%n", department, count);
        });

        // map的foreach使用
        Map<Integer, String> students = new HashMap<>();
        students.put(1, "zhangsan");
        students.put(2, "lisi");
        students.put(3, "wangwu");

        students.forEach((id, name) -> {
            System.out.println(id + "->" + name);
        });
    }
}