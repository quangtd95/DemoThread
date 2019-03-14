public class SynchronizedThread {
    public static void main(String args[]) {
        A a = new A();
        Thread5 t1 = new Thread5(a, "thread 1");
        Thread5 t2 = new Thread5(a, "thread 2");
        t1.start();
        t2.start();
    }
}

class Thread5 extends Thread {
    private A a;

    public Thread5(A a, String name) {
        super(name);
        this.a = a;
    }

    @Override
    public void run() {
        super.run();
        a.execute(getName());
    }
}

class A {
    public synchronized void execute(String nameThread) {
        for (int i = 1; i <= 5; i++) {
            System.out.println(nameThread + ": " + i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println(nameThread + "------------------------------------------ " );
    }

    public void execute2(String nameThread) {
        synchronized (this) {
            for (int i = 1; i <= 5; i++) {
                System.out.println(nameThread + ": " + i);
            }
        }

    }
}
