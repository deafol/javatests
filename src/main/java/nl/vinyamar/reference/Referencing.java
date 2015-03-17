package nl.vinyamar.reference;

public class Referencing {

    public static void main(String[] args) {
        Dog aDog = new Dog("Max");

        new Thread (() -> {
            System.out.println(Thread.currentThread().getName() + ":" + aDog.getName());
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            aDog.setName("Fifi");
        }).start();

        new Thread(new Runnable() {
            @Override public void run() {
                System.out.println(Thread.currentThread().getName() + ":" + aDog.getName());
            }
        }).start();
    }

    private static class Dog {
        private String name;

        public Dog(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
