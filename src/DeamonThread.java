public class DeamonThread extends Thread {
    public DeamonThread() {
        this.setDaemon(true);
    }

    @Override
    public void run() {
        super.run();
        int i = 0;
        while (true) {
            System.out.println("deamon thread is running... " + i++);
            try {
                sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String args[]){
        DeamonThread deamonThread = new DeamonThread();
        deamonThread.start();
        UserThread userThread = new UserThread();
        userThread.start();
        for (int i = 0 ; i < 10; i++){
            System.out.println("main thread is running " + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("main thread stopped");
    }
}

class UserThread extends Thread{
    @Override
    public void run() {
        super.run();
        for (int i = 0 ; i < 5; i++){
            System.out.println("user thread is running..." + i);
            try {
                sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("user thread stopped");
    }
}