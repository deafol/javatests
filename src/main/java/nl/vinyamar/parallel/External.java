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
        if (run == 2) {
//            Thread.sleep(1000);
            return "Failed" + run;
        } else {
            Thread.sleep(5000);
        }
        return "Run" + run;
    }
}
