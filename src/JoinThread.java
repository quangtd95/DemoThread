public class JoinThread {
    public static void main(String args[]) throws InterruptedException {
        Thread3 threadLong = new Thread3("Thread Long");
        Thread3 threadGiang = new Thread3("Thread Giang");
        threadLong.start();
//        threadLong.join();
//        threadLong.join(1000);
        threadGiang.start();
        System.out.println("main thread finished...");

    }
}

class Thread3 extends Thread {

    Thread3(String name) {
        super(name);
    }

    @Override
    public void run() {
        super.run();
        for (int i = 0; i < 5; i++) {
            System.out.println(getName() + " is running... " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
