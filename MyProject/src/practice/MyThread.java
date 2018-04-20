/**
 * 
 */
package practice;

import java.util.Arrays;

/**
 * @author Vibs
 *
 */
public class MyThread extends Thread{
  /**
 * 
 */
public MyThread() {
	// TODO Auto-generated constructor stub
}

MyThread(Runnable r){
	super(r);
}

public void run(){
	System.out.println("Inside thread");
}
}

class MyRunnable implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		System.out.println("Inside runnable");
		
	} 
	
}


class Test{
	
	public static void main(String [] args){
		new MyThread().start();
		new MyThread(new MyRunnable()).start();
		int[] array1 ={1,2,3};
		int[] array2 = {1,2,3};
		System.out.println(array1.equals(array2));
		System.out.println(Arrays.equals(array1, array2));
		int x=10;int y=20;
		int i=10;
		boolean b=(i++>10)&&(++i<15);
		System.out.println("alkfas"+i);
		
		String str1="one";
		String str2="two";
		System.out.println("");
		
		
		
	}
}
