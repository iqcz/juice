package com.packt.java8inaction;

/**
 * What is the final value for printing this?
 * @author Yanxue
 *
 */
public class MeaningOfThis {

    public final int value = 4;

    public void doInit() {
	int value = 6;
	Runnable r = new Runnable() {
	    public final int value = 5;

	    @Override
	    public void run() {
		int value = 10;
		System.out.println(value);
		System.out.println(this.value);
		System.out.println(MeaningOfThis.this.value);
	    }
	};
	r.run();
    }

    public static void main(String[] args) {
	MeaningOfThis m = new MeaningOfThis();
	m.doInit();
    }

}
