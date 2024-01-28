package client;

import model.Account;
import worker.AccountHolder;

public class ClientTest {

	public static void main(String[] args) {
		Account account=new Account();
		AccountHolder AH=new AccountHolder(account);
		Thread t1=new Thread(AH);
		Thread t2=new Thread(AH);
		t1.setName("Joesph");
		t2.setName("jiya");
		
		t1.start();
		t2.start();
	}
}
