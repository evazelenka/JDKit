package sem5.ex03;

import lombok.AllArgsConstructor;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Runner implements Runnable{

    private String name;
    private CountDownLatch cdl;
    private long speed;

    public Runner(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
        speed = new Random().nextInt(7, 10);
    }

    @Override
    public void run() {
        try {
            goOnStart();
            synchronized (this){
                wait();
            }
            goOnFinish();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void goOnStart() throws InterruptedException {
        System.out.println("runner " + name + " is going to start");
        Thread.sleep(new Random().nextInt(1000, 3000));
        System.out.println("runner " + name + " is ready");
        cdl.countDown();
    }

    private void goOnFinish() throws InterruptedException {
        System.out.println("runner " + name + " started running");
        long time = 100L / speed;
        Thread.sleep(time*1000);
        System.out.println("runner " + name + " finished running, speed: " + speed + " m/sec, time: " + time);
    }

    public void go(){
        synchronized (this){
            notify();
        }
    }
}
