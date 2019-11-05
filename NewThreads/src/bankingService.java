
class bankingService {
                public void transferFunds(Account from, Account to, double amt){
                        if(from.balLock.tryLock()) {
                        	try{
                                                
                        		if(to.balLock.tryLock()) {
                        			try {
                                        	from.withdraw(amt);
                                                to.deposit(amt);
                                    }
                                    finally {
                                    		to.balLock.unlock();
                                            }
                                    }
                                }
                            } 
                        	finally {
                                    from.balLock.unlock();
                            }
                		}
        }
