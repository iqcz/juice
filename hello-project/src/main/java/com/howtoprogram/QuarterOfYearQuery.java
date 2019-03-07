package com.howtoprogram;

import java.time.LocalDate;
import java.time.Month;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;

public class QuarterOfYearQuery implements TemporalQuery<Quarter> {

    @Override
    public Quarter queryFrom(TemporalAccessor temporal) {
	LocalDate now = LocalDate.from(temporal);

	if (now.isBefore(now.with(Month.APRIL).withDayOfMonth(1))) {
	    return Quarter.FIRST;
	} else if (now.isBefore(now.with(Month.JULY).withDayOfMonth(1))) {
	    return Quarter.SECOND;
	} else if (now.isBefore(now.with(Month.OCTOBER).withDayOfMonth(1))) {
	    return Quarter.THIRD;
	} else {
	    return Quarter.FORTH;
	}
    } // end method QuarterOfYearQuery

    public static void main(String[] args) {
	QuarterOfYearQuery q = new QuarterOfYearQuery();

	// direct
	Quarter quarter = q.queryFrom(LocalDate.now());
	System.out.println(quarter);

	// indirect
	quarter = LocalDate.now().query(q);
	System.out.println(quarter);
    }
}
