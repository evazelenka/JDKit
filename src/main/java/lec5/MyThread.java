package lec5;

public class MyThread extends Thread{

    @Override
    public void run() {
        System.out.println("1. hello from: " + Thread.currentThread());
    }
}
