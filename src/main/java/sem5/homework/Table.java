package sem5.homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;

public class Table extends Thread{

    private List<Fork> forks;
    private List<Philosophy> philosophies;
    private CountDownLatch cdl = new CountDownLatch(15);

    public Table() {
        forks = new ArrayList<>(Arrays.asList(new Fork(), new Fork(), new Fork(), new Fork(), new Fork()));
        philosophies = new ArrayList<>(Arrays.asList(new Philosophy("Confucius", cdl), new Philosophy("Aristotle", cdl), new Philosophy("Socrate", cdl), new Philosophy("Jung", cdl), new Philosophy("Spinoza", cdl)));
        setForks();
    }

    private void setForks() {
        for (int i = 0; i < 5; i++) {
            philosophies.get(i).setLeftForkIndex(i);
            if(i==4){
                philosophies.get(i).setRightForkIndex(0);
            }else philosophies.get(i).setRightForkIndex(i+1);
        }
    }


    private void eatOrThink() throws InterruptedException {
        int left;
        int right;
        for (int i = 0; i < 5; i++) {
            left = philosophies.get(i).getLeftForkIndex();
            right = philosophies.get(i).getRightForkIndex();
            if(!forks.get(left).isTaken() && !forks.get(right).isTaken() && philosophies.get(i).checkEating()){
                takeForks(left, right, i);
                cdl.countDown();
                throwForks(left, right, i);
            }

        }
    }

    private void takeForks(int left, int right, int i) throws InterruptedException {
        forks.get(left).setTaken(true);
        forks.get(right).setTaken(true);
        philosophies.get(i).eating();
    }

    private void throwForks(int left, int right, int i){
        forks.get(left).setTaken(false);
        forks.get(right).setTaken(false);
        philosophies.get(i).thinking();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            new Thread(philosophies.get(i)).start();
        }
        while(cdl.getCount() > 0){
            try {
                eatOrThink();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
