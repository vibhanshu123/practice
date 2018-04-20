/**
 * 
 */

/**
 * @author Vibs
 *
 */
public class MyObject {

	/**
	 * @param name
	 */
	public static synchronized void foo(String name) {
		System.out.println("foo Thread name"+name+".foo: starting");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("foo Thread name"+name+".foo: ending");		
	}
	
	public static synchronized void bar(String name) {
		System.out.println("bar Thread name"+name+".bar: starting");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
		System.out.println("bar Thread name"+name+".bar: ending");		
	}

}
