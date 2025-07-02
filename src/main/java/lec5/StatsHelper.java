package lec5;

import java.util.Scanner;

public class StatsHelper {

    private static int cntr = 0;

    public static void main(String[] args) throws InterruptedException {

        Thread readThread = new Thread(() -> {
            Scanner in = new Scanner(System.in);
            while(in.hasNextLine() && !Thread.interrupted()){
                in.nextLine();
                cntr++;
            }
        });
        readThread.setDaemon(true);
        readThread.start();
        readThread.interrupt();
        while(true){
            System.out.println(cntr + " messages inputted by user");
            Thread.sleep(1000);
        }
    }
}