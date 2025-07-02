package sem5.ex03;

import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Race extends Thread{
    private CountDownLatch cdl = new CountDownLatch(3);
//    private static final int COUNT_RUNNERS = 3;
    private List<Runner> runners;

    public Race() {
        runners = new ArrayList<>(Arrays.asList(
                new Runner("Nika", cdl),
                new Runner("Vika", cdl),
                new Runner("Olga", cdl)
        ));
    }

    @Override
    public void run() {
        try {
            System.out.println("the race on 100 m");
            goOnStart();
            cdl.await();
            goAll();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private void goOnStart(){
        for(Runner runner : runners){
            new Thread(runner).start();
        }
    }

    private void goAll() throws InterruptedException {
        System.out.println("ready");
        Thread.sleep(100);
        System.out.println("set");
        Thread.sleep(100);
        System.out.println("go");
        for(Runner runner : runners){
            runner.go();
        }
//        System.out.println("the race is finished");
    }
}
