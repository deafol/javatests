package nl.vinyamar.parallel

import rx.Observable;

/**
 * Created by Milan on 9-11-2014.
 */
class ObservableTester {

    /**
     * This example shows a custom Observable that does not block
     * when subscribed to as it spawns a separate thread.
     */
    def customObservableNonBlocking() {
        return Observable.create(
                /*
                 * This 'call' method will be invoked with the Observable is subscribed to.
                 *
                 * It spawns a thread to do it asynchronously.
                 */
                { subscriber ->
                    // For simplicity this example uses a Thread instead of an ExecutorService/ThreadPool
                    final Thread t = new Thread(new Runnable() {
                        void run() {
                            for (int i = 0; i < 75; i++) {
//                                if (true == subscriber.isUnsubscribed()) {
//                                    return;
//                                }
                                subscriber.onNext("value_" + i);
                            }
                            // after sending all values we complete the sequence
//                            if (false == subscriber.isUnsubscribed()) {
                                subscriber.onCompleted();
//                            }
                        };
                    });
                    t.start();
                }
        );
    }

    public static void main(String[] args) {
        new ObservableTester().customObservableNonBlocking().subscribe({ println(it) });
    }
}
