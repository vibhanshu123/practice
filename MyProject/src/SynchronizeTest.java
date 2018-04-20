/**
 * 
 */

/**
 * @author Vibs
 *
 */
public class SynchronizeTest implements Runnable{

	private String name;
	
	private MyObject myObj;
	
	public SynchronizeTest(String name,MyObject myObj){
		this.name = name;
		this .myObj = myObj;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
//	  myObj.foo(name);
//	  myObj.bar(name);
	  if (name.equals("1")){
		  myObj.foo(name);
	  } else{
		  myObj.bar(name);
	  }
		
	}
	
	public static void main(String[] args){
		
		MyObject obj1= new MyObject();
		MyObject obj2 = new MyObject();
		SynchronizeTest t1= new SynchronizeTest("1", obj1);
		SynchronizeTest t2= new SynchronizeTest("2", obj2);
		Thread thread1= new Thread(t1);
		Thread thread2= new Thread(t2);
		
		thread1.start();
		thread2.start();
	}

}
