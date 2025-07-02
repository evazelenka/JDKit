package sem5.ex02_2;

public class Main {
    public static void main(String[] args) {
        MyProgramState state = new MyProgramState();

        Thread1 thread1 = new Thread1(state);
        Thread2 thread2 = new Thread2(state);

        thread1.start();
        thread2.start();

    }
}
