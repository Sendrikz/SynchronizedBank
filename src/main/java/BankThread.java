import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

class BankThread implements Runnable {

    private Bank bank;

    private int from;
    private int maxTransfer;
    private int delay;

    Random rg = new Random();

    public BankThread(Bank bank, int from, int maxTransfer, int delay) {
        this.bank = bank;
        this.from = from;
        this.maxTransfer = maxTransfer;
        this.delay = delay;
    }

    @Override
    public void run() {

        while (true) {
            int to = rg.nextInt(bank.size());
            int amount = rg.nextInt(maxTransfer);

            bank.transfer(from, to, amount, delay);
        }

    }

}
