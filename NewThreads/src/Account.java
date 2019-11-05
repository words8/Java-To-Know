import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {
    private double balance;
    private Lock balLock = new ReentrantLock();
    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return balance;
    }

    private void setBalance(double balance) {
        try {
            Thread.sleep((long) (Math.random() * 2000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        this.balance = balance;
    }

    public void deposit(String name, double amt) {
        try {
        	balLock.lock();
	    	System.out.println(name + " trying to deposit " + amt);
	        System.out.println(name + " getting balance");
	        double bal = getBalance();
	        System.out.println(name + " got balance : " + bal);
	        bal += amt;
	        System.out.println(name + " setting balance : " + bal);
	        setBalance(bal);
        } finally {
        	balLock.unlock();
        }
//        balLock.
    }

    public  void withdraw(String name, double amt) {
    	try {
    		balLock.lock();
	        System.out.println(name + " trying to withdraw " + amt);
	        while(amt >getBalance())
	        {
	        	try {
					balLock.newCondition().await();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	        }
	        System.out.println(name + " getting balance");
	        double bal = getBalance();
	        System.out.println(name + " got balance : " + bal);
	        bal -= amt;
	        System.out.println(name + " setting balance : " + bal);
	        setBalance(bal);
    	} finally {
    		balLock.unlock();
    	}
    }
}
