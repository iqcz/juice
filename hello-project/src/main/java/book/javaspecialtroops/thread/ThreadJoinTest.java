package book.javaspecialtroops.thread;

/**
 * the demo for Thread join method.
 */

import java.util.Random;

public class ThreadJoinTest {

    private final static int COUNTER = 100000001;

    static class Computer extends Thread {

        private int start;
        private int end;
        private int result;
        private int[] array;

        Computer(int[] array, int start, int end) {
            this.array = array;
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i = start; i < end; i++) {
                result += array[i];
                if (result < 0) {
                    result &= Integer.MAX_VALUE;
                }
            }
        }

        private int getResult() {
            return result;
        }
    } // end class Computer

    public static void main(String[] args) throws InterruptedException {
        int[] array = new int[COUNTER];
        Random random = new Random();
        for (int i = 0; i < COUNTER; i++) {
            array[i] = Math.abs(random.nextInt());
        }

        long start = System.currentTimeMillis();
        Computer c1 = new Computer(array, 0, COUNTER / 2);
        Computer c2 = new Computer(array, (COUNTER / 2) + 1, COUNTER);
        c1.start();
        c2.start();

        // comment below 2 statement, not using join method.
        // see the time spend.
        c1.join();
        c2.join();
        System.out.println("Using time: " + (System.currentTimeMillis() - start));
        System.out.println(c1.getResult() + ", " + c2.getResult());
        System.out.println((c1.getResult() + c2.getResult()) & Integer.MAX_VALUE);
    } // end method main
}
