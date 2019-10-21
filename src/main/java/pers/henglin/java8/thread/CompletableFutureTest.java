package pers.henglin.java8.thread;

import org.junit.Test;

import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by linheng on 21/10/2019.
 */
public class CompletableFutureTest {

    @Test
    public void testCompletableFuture(){
        int threadPoolSize = 5;
        int threadSize = 10;

        ExecutorService threadPool = Executors.newFixedThreadPool(threadPoolSize);

        System.out.println("start...");

        for(int count=0; count<threadSize; count++){
            runTask(threadPool);
        }

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadPool.shutdown();

        System.out.println("finish.");
    }

    private void runTask(ExecutorService threadPool){
        CompletableFuture.runAsync(() -> {
            try {
                int num = new Random().nextInt(5);
                FutureTest.printInfo("start", Thread.currentThread().getId(), num);
                TimeUnit.SECONDS.sleep(num);
                FutureTest.printInfo("end", Thread.currentThread().getId(), num);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, threadPool).whenComplete((result, throwable) -> {
            FutureTest.printInfo("finish", Thread.currentThread().getId(), 0);
        });
    }
}
