package nl.vinyamar.parallel;

import java.util.concurrent.Callable;

/**
 * Created by Milan on 5-11-2014.
 */
public class External implements Callable<String> {

    private int run = 0;

    public External(int run) {
        this.run = run;
    }

    public String call() throws InterruptedException {
        double wait = run < 20 ? (20 - run) * 0.1 : 0.1;
        System.out.println("Run " + run + ", waiting " + wait);
        Thread.sleep((long) wait);
        return "Run" + (run);
    }
}
