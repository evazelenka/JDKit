package sem5.ex02;

public class Main {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread2 thread2 = new Thread2(thread1);

        thread1.start();
        thread2.start();

        try {
            thread2.join();
            thread1.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
