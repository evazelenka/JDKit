package sem5.ex01;

/*
Deadlock
 */

public class Main {
    static Object objA = new Object();
    static Object objB = new Object();
    public static void main(String[] args) {

        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                workThread1();
            }
        });

        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                workThread2();
            }
        });
        thread1.start();
        thread2.start();
    }

    public static void workThread1(){
        synchronized (objA){
            try {
                System.out.println("thread 1 took object A");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (objB){
                System.out.println("thread 1 took object B");
            }
        }
    }

    public static void workThread2(){
        synchronized (objB){
            System.out.println("thread 2 took object B");
            synchronized (objA){
                System.out.println("thread 2 took object A");
            }
        }
    }
}
