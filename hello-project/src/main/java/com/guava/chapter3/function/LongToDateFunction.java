package com.guava.chapter3.function;

import java.util.Date;

import com.google.common.base.Function;

public class LongToDateFunction implements Function<Long, Date> {

    @Override
    public Date apply(Long input) {
        Date date = new Date();
        date.setTime(input);
        return date;
    }
}
