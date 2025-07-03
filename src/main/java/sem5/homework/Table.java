package sem5.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Table extends Thread{
    private Fork[] forks;
    private List<Philosophy> philosophies;
    private CountDownLatch cdl = new CountDownLatch(5);

    public Table() {
        forks = new Fork[]{new Fork(), new Fork(), new Fork(), new Fork(), new Fork()};
        philosophies = new ArrayList<>(Arrays.asList(new Philosophy("Confucius", 0, 1, cdl, this), new Philosophy("Aristotle", 1, 2, cdl, this ), new Philosophy("Socrate", 2, 3, cdl, this), new Philosophy("Jung", 3,4, cdl, this ), new Philosophy("Spinoza", 4, 0, cdl, this)));
    }

    @Override
    public void run() {
        try {
            sitDownPhil();
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("done with eating");
    }


    private void sitDownPhil() throws InterruptedException {
        for (Philosophy p : philosophies) {
            p.start();
        }
    }

    public synchronized boolean checkForks(int left, int right){
        if(!forks[left].isTaken() && !forks[right].isTaken()){
            setTakenForks(left, right, true);
            return true;
        }
        return false;
    }

    public void setTakenForks(int left, int right, boolean isTaken){
        forks[left].setTaken(isTaken);
        forks[right].setTaken(isTaken);
    }
}
