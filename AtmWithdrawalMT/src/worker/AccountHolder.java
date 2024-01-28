package worker;

import model.Account;

public class AccountHolder implements Runnable{
private Account account;

public AccountHolder(Account account) {
	this.account=account;
}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		for(int i=1;i<=4;i++) {
			makeWithdrawal(2000);
			if(account.getBalance()<=0) {
				System.out.println("insufficient balance");
				
			}
		}
	}

	private void makeWithdrawal(int withdrawAmount) {
		
		// TODO Auto-generated method stub
		if(account.getBalance()>=withdrawAmount) {
			System.out.println(Thread.currentThread().getName()+"is going to withdraw$"+withdrawAmount);
			try {
				Thread.sleep(3000);
			}
			catch(InterruptedException ex){
				
			}
			account.withdraw(withdrawAmount);
			System.out.println(Thread.currentThread().getName()+"completes the withdrawal of $"+withdrawAmount);
		}
		else {
			System.out.println("not enough balance for"+Thread.currentThread().getName()+"to withdraw the amount"+account.getBalance());
		}
	}
	

}
