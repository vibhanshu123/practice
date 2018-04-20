


public class InnerClassWithinMethod {
	
	private String x="Outer2";
	
	void doStuff(){
		final String v="vibs";
		class MyInner1{
			public void seeOuter(){
				System.out.println(" the value of x is"+x);
				System.out.println("accessing local variable"+v);
				
			}
		}
	
	MyInner1 mi=new MyInner1();
	mi.seeOuter();
	
	}
}
