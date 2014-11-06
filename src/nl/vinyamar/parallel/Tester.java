package nl.vinyamar.parallel;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Milan on 5-11-2014.
 */
public class Tester {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        testSynchronous();

        testASyncFuture();
    }

    private static void testSynchronous() throws InterruptedException {
        long start = new Date().getTime();
        int i = 0;
        while (i < 10) {
            new External(i).call();
            i++;
        }
        long end = new Date().getTime();
        double timed = end - start;
        System.out.println("synchronous timed: " + timed + "ms");
    }

    private static void testASyncFuture() throws InterruptedException, ExecutionException {
        ExecutorService executor = new ScheduledThreadPoolExecutor(1);
        long start = new Date().getTime();
        int i = 0;
        List<Future<String>> futures = new ArrayList<>();
        while (i < 10) {
            futures.add(executor.submit(new External(i)));
            i++;
        }

        for (Future future : futures) {
            future.get();
        }
        long end = new Date().getTime();
        double timed = end - start;
        System.out.println("futures timed: " + timed + "ms");
        executor.shutdown();
    }

}
