
public class BankExample {

    public static void main(String[] args) {
        Account account = new Account(5000);
        TransactionThread t1 = new 
                TransactionThread(account, TransactionType.CREDIT, "George", 2500.00);
        TransactionThread t2 = new 
                TransactionThread(account, TransactionType.CREDIT, "\tPeter", 3000.00);
        TransactionThread t3 = new 
                TransactionThread(account, TransactionType.DEBIT, "\t\tJane", 6000.00);
    
        t3.start();
        try {
			Thread.sleep(10);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        t1.start();
        t2.start();
        
        
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        System.out.println("Final Balance : " + account.getBalance());
        
    }

}
