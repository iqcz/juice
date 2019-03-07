package crazy;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

/**
 * 根据指定格式的出生日期，计算出到现在为止过去的年，月，日的数目。
 * @author i324779
 *
 */
public class AgeCalculator {

    private final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-d");

    public Period calculateAge(LocalDate birthday) {
        LocalDate today = LocalDate.now();
        return Period.between(birthday, today);
    }

    public LocalDate getBirthday() {
        Scanner scanner = new Scanner(System.in);
        LocalDate birthday;
        while (true) {
            System.out.println(
                    "Please enter your birthday " + "in yyyy-MM-dd format (e.g. 1980-9-28): ");
            String input = scanner.nextLine();
            try {
                birthday = LocalDate.parse(input, formatter);
                // birthday = LocalDate.parse(input);
                return birthday;
            } catch (DateTimeParseException e) {
                System.out.println("Error! Please try again");
            }
        }
    }

    public static void main(String[] args) {
        AgeCalculator ageCalculator = new AgeCalculator();
        LocalDate birthday = ageCalculator.getBirthday();
        Period age = ageCalculator.calculateAge(birthday);
        System.out.printf("Today you are %d years, %d months" + " and %d days old%n",
                age.getYears(), age.getMonths(), age.getDays());
    }
}