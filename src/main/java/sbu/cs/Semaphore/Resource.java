package sbu.cs.Semaphore;

import java.time.LocalTime;

public class Resource {

    public static void accessResource() {
        try {
            LocalTime time = LocalTime.now();
            System.out.println("Thread Name: " + Thread.currentThread().getName()+ " System Time: " + time);
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
