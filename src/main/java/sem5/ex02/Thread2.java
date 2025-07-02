package sem5.ex02;

public class Thread2 extends Thread{

    private int counter = 100;
    private Thread1 thread;

    public Thread2(Thread1 thread) {
        this.thread = thread;
    }

    @Override
    public void run() {
        while(counter >= 0){
            if(thread.isSwitcher()){
                try {
                    Thread.sleep(100);
                    System.out.println(counter--);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
