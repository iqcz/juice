package com.howtoprogram;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class BirthdayDiary {
    
    private Map<String, LocalDate> birthdays;

    public BirthdayDiary() {
	birthdays = new HashMap<>();
    }

    public LocalDate addBirthday(String name, int day, int month, int year) {
	LocalDate birthday = LocalDate.of(year, month, day);
	
	birthdays.put(name, birthday);// add to map
	
	return birthday;
    }

    public LocalDate getBirthdayFor(String name) {
	return birthdays.get(name);
    }

    public int getAgeInYear(String name, int year) {
	Period period = Period.between(birthdays.get(name), birthdays.get(name).withYear(year));

	return period.getYears();
    }

    public Set<String> getFriendsOfAgeIn(int age, int year) {
	return birthdays.keySet().stream()
		.filter(p -> getAgeInYear(p, year) == age)
		.collect(Collectors.toSet());
    }

    public int getDaysUntilBirthday(String name) {
	Period period = Period.between(LocalDate.now(), birthdays.get(name));
	
	return  period.getDays();
    }

    public Set<String> getBirthdaysIn(Month month) {
	return birthdays.entrySet().stream().
		filter(p -> p.getValue().getMonth() == month)
		.map(p -> p.getKey())
		.collect(Collectors.toSet());
    }

    public Set<String> getBirthdaysInNextMonth() {
	return getBirthdaysIn(LocalDate.now().getMonth());
    }

    public int getTotalAgeInYears() {
	return birthdays.keySet().stream()
		.mapToInt(p -> getAgeInYear(p, LocalDate.now().getYear()))
		.sum();
    }
    
    public static void main(String[] args) {
	BirthdayDiary bd = new BirthdayDiary();
	
	LocalDate linzhiling = bd.addBirthday("linzhiling", 29, 11, 1982);
	LocalDate yizi = bd.addBirthday("yizi", 3, 2, 1992);
	LocalDate zhangbozhi = bd.addBirthday("zhangbozhi", 9, 11, 1986);
	
	// 打印指定某一名字的生日
	System.out.println("birthday: " + bd.getBirthdayFor("linzhiling"));
	
	// 打印生日年份到指定年份的年份数量
	System.out.println(bd.getAgeInYear("zhangbozhi", 2017));
	
	// 打印指定年份的某一人的年龄集合
	System.out.println(bd.getFriendsOfAgeIn(31, 2017));
	
	// TODO
	System.out.println(bd.getDaysUntilBirthday("yizi"));
	
	// 查找指定月份出生的人的集合
	System.out.println(bd.getBirthdaysIn(Month.NOVEMBER));
	
    }
}
