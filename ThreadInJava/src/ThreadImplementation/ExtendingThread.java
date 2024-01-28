package ThreadImplementation;

class Thread1 extends Thread{
	
	public void run() {
		while(true) {
		System.out.println("running my thread class");
		
	}
	}
}
class Thread2 extends Thread{
	public void run() {
		while(true) {
		System.out.println("thread2 is running");
	}
}
}
public class ExtendingThread{

public static void main(String[] args) {
	
	Thread1 t1=new Thread1();
	Thread t2=new Thread2();

	t1.start();
	t2.start();
	
	
	
}}
