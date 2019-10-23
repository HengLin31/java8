package pers.henglin.java8.thread;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * Created by linheng on 21/10/2019.
 */
public class FutureTest {
    private static Logger logger = LoggerFactory.getLogger(FutureTest.class);

    @Test
    public void testFuture(){
        int threadPoolSize = 5;
        int threadSize = 10;

        ExecutorService threadPool = Executors.newFixedThreadPool(threadPoolSize);
        List<Future<Integer>> results = new ArrayList<>();

        for(int count=0; count<threadSize; count++){
            results.add(threadPool.submit(initTask()));
        }

        logger.info("start...");

        results.forEach(result -> {
            try {
                logger.info(result.get().toString());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
                logger.warn(e.getMessage(), e);
            }
        });

        threadPool.shutdown();

        logger.info("finish.");
    }

    private Callable<Integer> initTask(){
        return () -> {
            int num = new Random().nextInt(10);
            printInfo("start", Thread.currentThread().getId(), num);
            TimeUnit.SECONDS.sleep(num);
            printInfo("end", Thread.currentThread().getId(), num);
            return num;
        };
    }

    public static void printInfo(String type, long id, int num){
        StringBuffer info = new StringBuffer();
        info.append(type).append(" - thread: ").append(id)
                .append(", num: ").append(num);
        logger.info(info.toString());
    }
}
