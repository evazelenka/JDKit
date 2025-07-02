package lec5;

public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("2. hello from: " + Thread.currentThread());
    }
}
