package com.guava.chapter2.preconditions;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkElementIndex;
import static com.google.common.base.Preconditions.checkNotNull;
import static com.google.common.base.Preconditions.checkState;

/**
 * @author i324779
 */
public class PreconditionExample {

    private String state;
    private int[] values = new int[5];
    private int currentIndex;

    public PreconditionExample(String state) {
        //returns value of object if not null
        this.state = checkNotNull(state, "Label can't be null");
    }

    public void updateCurrentIndexValue(int index, int valueToSet) {
        //Check index valid first
        this.currentIndex = checkElementIndex(index, values.length, "Index out of bounds for values");
        //Validate state of value
        checkArgument(valueToSet <= 100, "Value can't be more than 100");
        values[this.currentIndex] = valueToSet;
    }

    public void doOperation() {
        checkState(validateObjectState(), "Can't perform operation");
    }

    private boolean validateObjectState() {
        return "open".equalsIgnoreCase(this.state) && values[this.currentIndex] == 10;
    }


    public int[] getValues() {
        return values;
    }

    public static void main(String[] args) {
        System.out.println("Hello, Guava.");
    }
}
