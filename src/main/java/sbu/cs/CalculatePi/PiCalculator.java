package sbu.cs.CalculatePi;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PiCalculator {

    /**
     * Calculate pi and represent it as a BigDecimal object with the given floating point number (digits after . )
     * There are several algorithms designed for calculating pi, it's up to you to decide which one to implement.
     Experiment with different algorithms to find accurate results.

     * You must design a multithreaded program to calculate pi. Creating a thread pool is recommended.
     * Create as many classes and threads as you need.
//     * Your code must pass all of the test cases provided in the test folder.

//     * @param floatingPoint the exact number of digits after the floating point
     * @return pi in string format (the string representation of the BigDecimal object)
     */

    public static class calculatingPI implements Runnable{
        int n;
        MathContext mc = new MathContext(1000);

        public calculatingPI(int n) {
            this.n = n;
        }

        @Override
        public void run() {
            BigDecimal sign = new BigDecimal(1);
            BigDecimal i = new BigDecimal(2);
            for (i.intValue() ; i.intValue() <= n ; i = new BigDecimal(i.intValue() + 2)){
                sum = new BigDecimal(sum.intValue() + sign.multiply(BigDecimal.valueOf((4/n)*(4/(n+1) * (4/(n+2))))).intValue()) ;

                sign.multiply(BigDecimal.valueOf(-1));
            }
        }
    }

    public static BigDecimal sum;
    public static synchronized BigDecimal calculate(int floatingPoint, BigDecimal sign)
    {
        BigDecimal i = new BigDecimal(2);
        for (i.intValue() ; i.intValue() <= floatingPoint ; i = new BigDecimal(i.intValue() + 2)){
            sum = new BigDecimal(sum.intValue() + sign.multiply(BigDecimal.valueOf((4/floatingPoint)*(4/(floatingPoint+1) * (4/(floatingPoint+2))))).intValue()) ;
            sign.multiply(BigDecimal.valueOf(-1));
        }
        return sum;
    }

    public static void main(String[] args) {
        // Use the main function to test the code yourself
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        sum = new BigDecimal(0);
        for (int i = 0; i < 100; i++){
            calculatingPI task = new calculatingPI(i);
            threadPool.execute(task);
        }

        threadPool.shutdown();

        try {
            threadPool.awaitTermination(10000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Calculated Value:  " + sum);
    }
}
