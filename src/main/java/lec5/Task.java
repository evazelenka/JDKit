package lec5;

import lombok.Getter;
import lombok.Setter;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Task implements Runnable{

    @Getter
    private final AtomicInteger value;
    @Setter
    private CountDownLatch cdl;

    public Task(int value) {
        this.value = new AtomicInteger(value);
    }

    public void inc(){
        value.incrementAndGet();
    }

    @Override
    public void run() {
        for (int i = 0; i < 10000000; i++) {
            inc();
        }
        cdl.countDown();
    }

    @Override
    public String toString() {
        return String.format("(%s)", value);
    }
}
