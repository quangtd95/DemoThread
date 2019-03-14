public class WaitNotifyThread {

    public static void main(String args[]) {
        ATM atm = new ATM();
        Thread thread = new Thread(() -> atm.withdraw(10000));
        thread.start();

        Thread thread2 = new Thread(() -> {
            try {
                atm.deposit(1000);
                Thread.sleep(1000);
                atm.deposit(5000);
                Thread.sleep(1000);
                atm.deposit(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        });
        thread2.start();
    }
}

class ATM {
    private int balance = 1000;

    public ATM() {
        System.out.println("tài khoản của bạn là " + balance);
    }

    public synchronized void withdraw(int amount) {
        System.out.println("Đang thực hiện giao dịch rút tiền " + amount + "...");
        while (balance < amount) {
            System.out.println("Không đủ tiền rút!!!");
            try {
                wait(); // Chờ nạp tiền
            } catch (InterruptedException ie) {
                System.out.println(ie.toString());
            }
        }
        balance -= amount;
        System.out.println("Rút tiền thành công. Tài khoản của bạn hiện tại là " + balance);
    }

    public synchronized void deposit(int amount) {
        System.out.println("Đang thực hiện giao dịch nạp tiền " + amount + "...");
        balance += amount;
        System.out.println("Nạp tiền thành công. Tài khoản của bạn hiện tại là " + balance);
        notify(); // Thông báo đã nạp tiền
    }
}
