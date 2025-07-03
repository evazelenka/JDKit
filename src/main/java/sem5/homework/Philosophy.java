package sem5.homework;

import lombok.Getter;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Philosophy extends Thread{

    private String name;
    private String state;
    private static final String EATING = " is eating";
    private static final String THINKING = " is thinking";
    private boolean isEatingPrevious;
    private CountDownLatch eat = new CountDownLatch(3);
    private int leftForkIndex;
    private int rightForkIndex;
    private CountDownLatch cdl;
    private Table table;
    private Random rnd;

    public Philosophy(String name, int leftForkIndex, int rightForkIndex, CountDownLatch cdl, Table table) {
        isEatingPrevious = false;
        this.name = name;
        this.leftForkIndex = leftForkIndex;
        this.rightForkIndex = rightForkIndex;
        this.cdl = cdl;
        this.table = table;
        rnd = new Random();
    }

    private void showState(){
        System.out.println(name + state + " with " + leftForkIndex + " " + rightForkIndex);
    }

    private void changeState(String state) throws InterruptedException {
        this.state = state;
    }

    private void eat() throws InterruptedException {
        if(table.checkForks(leftForkIndex, rightForkIndex)){
            changeState(EATING);
            showState();
            eat.countDown();
            isEatingPrevious = true;
            sleep(rnd.nextLong(3000, 7000));
            table.setTakenForks(leftForkIndex, rightForkIndex, false);
            System.out.println(name + " puts down the forks " + leftForkIndex + " " + rightForkIndex);
        }
    }

    @Override
    public void run() {
        while (eat.getCount() != 0){
            try {
                eat();
                think();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(name + " done with eating");
        cdl.countDown();
    }

    private void think() throws InterruptedException {
        changeState(THINKING);
        isEatingPrevious = false;
        showState();
        sleep(rnd.nextLong(3000, 6000));
    }

}
