package sem5.homework;

import java.util.concurrent.CountDownLatch;

public class Philosophy implements Runnable{
    private String name;
    private int leftForkIndex;
    private int rightForkIndex;
    private CountDownLatch cdl;
    private CountDownLatch eating = new CountDownLatch(3);
    private boolean isEatingPrevious = false;

    public Philosophy(String name, CountDownLatch cdl) {
        this.name = name;
        this.cdl = cdl;
    }

    public String getName() {
        return name;
    }

    public void setLeftForkIndex(int leftForkIndex) {
        this.leftForkIndex = leftForkIndex;
    }

    public void setRightForkIndex(int rightForkIndex) {
        this.rightForkIndex = rightForkIndex;
    }

    public int getLeftForkIndex() {
        return leftForkIndex;
    }

    public int getRightForkIndex() {
        return rightForkIndex;
    }

    public void thinking(){
        System.out.println(name + " is thinking");
        isEatingPrevious = false;
    }

    public boolean checkEating(){
        return (eating.getCount() != 0) && !isEatingPrevious;
    }

    public void eating() throws InterruptedException {
                System.out.println(name + " is eating");
                Thread.sleep(100);
                eating.countDown();
                isEatingPrevious = true;

    }

    @Override
    public void run() {
        thinking();
    }
}
