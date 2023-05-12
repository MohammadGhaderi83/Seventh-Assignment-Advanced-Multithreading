package sbu.cs.PrioritySimulator;

import java.util.concurrent.CountDownLatch;

public class BlueThread extends ColorThread {

    private static final String MESSAGE = "hi finished blacks, hi whites!";
    CountDownLatch blue;

    public BlueThread(CountDownLatch blue) {
        this.blue = blue;
    }

    void printMessage() {
        super.printMessage(new Message(this.getClass().getName(), getMessage()));
    }

    @Override
    String getMessage() {
        return MESSAGE;
    }

    @Override
    public void run() {
        printMessage();
        blue.countDown();
    }
}
