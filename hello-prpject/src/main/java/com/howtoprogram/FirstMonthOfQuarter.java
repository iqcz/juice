package com.howtoprogram;

import java.time.LocalDate;
import java.time.Month;

/**
 * 根据指定月份，计算该月份所在的季度的第一个月份
 * 虽然基本可以实现，但还是不是很明确。
 * @see QuarterOfYearQuery
 * 
 * @author i324779
 * @date 2017/10/23
 *
 */
public class FirstMonthOfQuarter {

    public static void main(String[] args) {
	LocalDate today = LocalDate.now();

	Month currentMonth = today.getMonth();

	Month firstMonthOfQuarter = currentMonth.firstMonthOfQuarter();

	System.out.println(firstMonthOfQuarter);
    }

}
