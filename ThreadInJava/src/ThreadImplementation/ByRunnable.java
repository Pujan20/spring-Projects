package ThreadImplementation;

class thread1 implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println("thread1 is running");
			
		}
		
	}
	
}


class thread2 implements Runnable{

	@Override
	public void run() {
		while(true) {
			System.out.println("thread2 is running");
			
		}
	}
	
}

public class ByRunnable {
	public static void main(String[] args) {
		
	thread1 bullet1=new thread1();
	Thread gun1=new Thread(bullet1);

	thread2 bullet2=new thread2();
	Thread gun2=new Thread(bullet2);
	
	gun1.setPriority(Thread.MIN_PRIORITY);
	gun2.setPriority(Thread.MAX_PRIORITY);
	gun1.start();
	gun2.start();
	}
	
}
