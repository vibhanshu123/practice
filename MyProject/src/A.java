/**
 * 
 */

/**
 * @author vibhanshu.jha
 *
 */
public class A extends Thread {
	
	public void run(){
		synchronized (this) {
			try{
				wait();
			}catch(InterruptedException e){
				
			}
		}
	}
  
	public static void main(String [] args){
		A a1=new A();
		a1.setDaemon(true);
		long startTime=System.currentTimeMillis();
		a1.start();
		System.out.println(System.currentTimeMillis()-startTime+",");
		
	}
}
