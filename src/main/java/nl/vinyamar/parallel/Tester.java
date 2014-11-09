package nl.vinyamar.parallel;

import rx.Observable;
import rx.functions.Action1;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by Milan on 5-11-2014.
 */
public class Tester {

    public static final int RUNS = 5;
    public static final int THREADS = 5;

    public static void main(String[] args) throws InterruptedException, ExecutionException {
//        testSynchronous();

        testASyncFuture();

        testASyncRxPlain();
    }

    private static void testSynchronous() throws InterruptedException {
        long start = new Date().getTime();
        int i = 0;
        while (i < RUNS) {
            System.out.print(new External(i).call());
            i++;
        }
        long end = new Date().getTime();
        double timed = end - start;
        System.out.println("synchronous timed: " + timed + "ms");
    }

    private static void testASyncFuture() throws InterruptedException, ExecutionException {
        ExecutorService executor = new ScheduledThreadPoolExecutor(THREADS);
        long start = new Date().getTime();
        int i = 0;
        List<Future<String>> futures = new ArrayList<>();
        while (i < RUNS) {
            futures.add(executor.submit(new External(i)));
            i++;
        }

        for (Future future : futures) {
            System.out.print(future.get());
        }
        long end = new Date().getTime();
        double timed = end - start;
        System.out.println("futures timed: " + timed + "ms");
        executor.shutdown();
    }

    private static void testASyncRx() throws InterruptedException, ExecutionException {
        ExecutorService executor = new ScheduledThreadPoolExecutor(THREADS);
        long start = new Date().getTime();
        int i = 0;
        List<Future<String>> futures = new ArrayList<>();
        while (i < RUNS) {
            futures.add(executor.submit(new External(i)));
            i++;
        }

        Observable.from(futures).subscribe(new Action1<Future<String>>() {
            @Override
            public void call(Future<String> stringFuture) {
                try {
                    System.out.print(stringFuture.get());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            }
        });
        long end = new Date().getTime();
        double timed = end - start;
        System.out.println("observable timed: " + timed + "ms");
        executor.shutdown();
    }

    private static void testASyncRxPlain() throws InterruptedException, ExecutionException {
        final ExecutorService executor = new ScheduledThreadPoolExecutor(THREADS);
        long start = new Date().getTime();
        int i = 0;
        List<External> externals = new ArrayList<>();
        while (i < RUNS) {
            External e = new External(i);
            externals.add(e);
            i++;
        }


        Observable.from(externals).subscribe(new Action1<External>() {
            @Override
            public void call(final External external) {
                Runnable runnable = new Runnable() {
                    @Override
                    public void run() {
                        try {
                            external.call();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                };
                new Thread(runnable).start();
//                executor.execute(
//                        new Runnable() {
//                            @Override
//                            public void run() {
//                                try {
//                                    external.call();
//                                } catch (InterruptedException e) {
//                                    e.printStackTrace();
//                                }
//                            }
            }
        });
        long end = new Date().getTime();
        double timed = end - start;
        System.out.println("observable timed: " + timed + "ms");
        executor.shutdown();
    }

}
