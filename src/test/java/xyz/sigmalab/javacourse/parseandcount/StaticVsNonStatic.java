package xyz.sigmalab.javacourse.parseandcount;

import org.junit.Test;

public class StaticVsNonStatic {

    public static class Simple {

        public void nonStatic() {
            System.out.println("NonStatic");
        }

        public static void andStatic() {
            System.out.println("Static");
        }

        private static int counter;
        public static int getCounter() {
            return counter;
        }

        public int nonStaticCounter;
        public Simple() {
            counter += 1;
            nonStaticCounter += 1;
        }
    }

    @Test
    public void staticVsNonStatic() {

        // Type
        Simple.andStatic();

        // Object
        // new Simple().nonStatic();

        Simple a = new Simple();
        System.out.printf("%d , %d \n", a.nonStaticCounter, Simple.getCounter());

        Simple b = new Simple();
        System.out.printf("%d , %d \n", b.nonStaticCounter, Simple.getCounter());

        Simple d = new Simple();
        System.out.printf("%d , %d \n", d.nonStaticCounter, Simple.getCounter());
    }
}
