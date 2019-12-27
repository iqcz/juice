package com.packt.mvneclipse.javainanutshell;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Some date usage in Java 8
 *
 * @author Yanxue
 */
public class BirthdayDiary {

    /**
     * the container hold person's birthday according person name.
     */
    private Map<String, LocalDate> birthdays;

    /**
     * construct method. instance the container.
     */
    public BirthdayDiary() {
        this.birthdays = new HashMap<>();
    }

    /**
     * add the person's name and birthday to the container
     *
     * @param name  person's name
     * @param day   day of birthday
     * @param month month of birthday
     * @param year  year of birthday
     * @return the person's birthday
     */
    public LocalDate addBirthday(String name, int day, int month, int year) {
        LocalDate birthday = LocalDate.of(year, month, day);
        birthdays.put(name, birthday);

        return birthday;
    }

    /**
     * get birthday according by person's name
     *
     * @param name person's name
     * @return the birthday
     */
    public LocalDate getBirthdayFor(String name) {
        return birthdays.get(name);
    }

    /**
     * get person's age according to year
     *
     * @param name person's name
     * @param year year
     * @return the age
     */
    public int getAgeInYear(String name, int year) {
        Period period = Period.between(birthdays.get(name), birthdays.get(name).withYear(year));
        return period.getYears();
    }

    /**
     * the container holds all the person's name according to age
     *
     * @param age  the age
     * @param year birthday year
     * @return person's name container
     */
    public Set<String> getFriendsOfAgeIn(int age, int year) {
        return birthdays.keySet().stream().filter(name -> this.getAgeInYear(name, year) == age)
                .collect(Collectors.toSet());
    }

    /**
     * get total days between current date to birthday date
     *
     * @param name person's name
     * @return total days
     */
    public String getDaysUntilBirthday(String name) {
        Period period = Period.between(birthdays.get(name), LocalDate.now());

        return String.format("You have been living %d years, %d monthds and %d days in the world.\n", period.getYears(),
                period.getMonths(), period.getDays());
    }

    public Set<String> getBirthdaysIn(Month month) {
        return birthdays.entrySet().stream().filter(p -> p.getValue().getMonth() == month).map(Map.Entry::getKey)
                .collect(Collectors.toSet());
    }

    public Set<String> getBirthdayInNextMonth() {
        return this.getBirthdaysIn(LocalDate.now().getMonth());
    }

    public int getTotalAgeInYears() {
        return this.birthdays.keySet().stream().mapToInt(name -> this.getAgeInYear(name, LocalDate.now().getYear()))
                .sum();
    }

    public static void main(String[] args) {
        BirthdayDiary birthdays = new BirthdayDiary();

        birthdays.addBirthday("xiaoMing", 9, 1, 1986);
        birthdays.addBirthday("xiaoGang", 11, 12, 1983);
        birthdays.addBirthday("xiaoHong", 15, 1, 1984);
        birthdays.addBirthday("xiaoLing", 13, 12, 1985);
        birthdays.addBirthday("xiaoQing", 15, 11, 1983);

        LocalDate xiaoMingBirth = birthdays.getBirthdayFor("xiaoMing");
        System.out.println(xiaoMingBirth.format(DateTimeFormatter.ofPattern("uuuu MM dd")));

        int ageOfXiaoMing = birthdays.getAgeInYear("xiaoMing", 2017);
        System.out.println(ageOfXiaoMing);

        Set<String> names = birthdays.getFriendsOfAgeIn(34, 2017);
        System.out.println(names);

        String totalDays = birthdays.getDaysUntilBirthday("xiaoHong");
        System.out.println(totalDays);

        // TODO 获取两个日期之间所有的天数，月数，年数。

        // get the person's name according the month
        Set<String> month = birthdays.getBirthdaysIn(Month.NOVEMBER);
        System.out.println(month);

        System.out.println("=============");
        // 得到当前月份所在季度的第一个月份。
        LocalDate today = LocalDate.now();
        Month currentMonth = today.getMonth();
        Month firstMonthOfQuarter = currentMonth.firstMonthOfQuarter();
        System.out.println(firstMonthOfQuarter);

    }
}
