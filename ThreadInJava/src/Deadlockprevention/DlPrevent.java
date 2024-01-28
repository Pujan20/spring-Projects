package Deadlockprevention;

public class DlPrevent {
public static void main(String[] args) throws InterruptedException {
	Object O1=new Object();
	Object O2=new Object();
	Object O3=new Object();
	
	Thread t1=new Thread(new SyncThread(O1,O2),"t1");
	Thread t2=new Thread(new SyncThread(O2,O3),"t2");
	
	t1.start();
	Thread.sleep(2000);
	t2.start();
	Thread.sleep(2000);
}
}


class SyncThread implements Runnable{
private Object O1;
private Object O2;

	public SyncThread(Object o1, Object o2) {
		
		this.O1=o1;
		this.O2=o2;
	}

	@Override
	public void run() {
		
		String name=Thread.currentThread().getName();
		System.out.println(name+"acquiring lock on "+O1);
		
		synchronized(O1) {
			System.out.println(name+"acquired lock on "+O1);
			work();
		}
		System.out.println(name+"released lock on "+O1);
		System.out.println(name+"acquiring lock on "+O2);
	    synchronized(O2) {
	    	System.out.println(name+"acquired lock on"+O2);
	    	work();
	    }
		System.out.println(name+"released lock on "+O2);
		System.out.println("finished execution");
	}
	
	private void work() {
		try {
			Thread.sleep(5000);
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
	}
}
