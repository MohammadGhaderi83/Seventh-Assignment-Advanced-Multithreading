package sbu.cs.PrioritySimulator;

import java.util.concurrent.CountDownLatch;

public class WhiteThread extends ColorThread {

    private static final String MESSAGE = "hi finished blacks, hi finished blues!";

    void printMessage() {
        super.printMessage(new Message(this.getClass().getName(), getMessage()));
    }
    CountDownLatch white;

    public WhiteThread(CountDownLatch white) {
        this.white = white;
    }

    @Override
    String getMessage() {
        return MESSAGE;
    }

    @Override
    public void run() {
        printMessage();
        white.countDown();
    }
}
