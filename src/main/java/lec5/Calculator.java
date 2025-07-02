package lec5;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Calculator {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Queue<Task> queue =new ArrayDeque<>();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Thread taskService = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(2000);
                    executorService.submit(() -> {
                        Task task = queue.poll();
                        if(task != null){
                            System.out.println("Task " + task + " started");
                            task.run();
                        }
                    });
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        taskService.start();
        while(in.hasNextLine()) {
            try {
                int value = Integer.parseInt(in.nextLine());
                Task task = new Task(value);
                queue.add(task);
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        }
        executorService.shutdown();
    }
}
