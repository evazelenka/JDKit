package sem5.ex02;

public class Thread1 extends Thread{

    private volatile Boolean switcher = false;

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(1000);
                switcher = !switcher;
                System.out.println("switcher is changed " + switcher);
            } catch (InterruptedException e) {
                System.out.println("the program is done");
                break;
            }
        }
    }

    public boolean isSwitcher() {
        return switcher;
    }
}
