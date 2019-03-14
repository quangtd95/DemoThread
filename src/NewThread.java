public class NewThread {

    public static void main(String args[]) {
        int i = 0;
        new Thread1().run();
        Runnable runnable = new Thread2();
        new Thread(runnable).start();
        while (true) {
            i++;
            System.out.println("main thread " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}

class Thread1 extends Thread {
    private int i = 0;

    @Override
    public void run() {
        super.run();
        while (true) {
            i++;
            System.out.println("thread1 " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 implements Runnable {
    private int i = 0;

    @Override
    public void run() {
        while (true) {
            i++;
            System.out.println("thread2 " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
