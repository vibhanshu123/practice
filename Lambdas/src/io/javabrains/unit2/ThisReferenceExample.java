package io.javabrains.unit2;

public class ThisReferenceExample {

	public void doProcess(int i, Process p) {
		p.process(i);
	}
	
	public String toString() {
		return "This is the main class ThisrEference exmaple";
	}
	
	public void execute() {
		doProcess(10, i->{
			System.out.println("value of i is"+i);
			System.out.println(this); 
		});
	}
	
	public static void main(String [] args) {
		ThisReferenceExample thisReferenceExample = new ThisReferenceExample();
		thisReferenceExample.doProcess(10, new Process() {
			
			@Override
			public void process(int i) {
				System.out.println("value of i is"+i);
				System.out.println(this);
				
			}
			
			public String toString() {
				return "This is anonymous inner class";
			}
		});
		
		thisReferenceExample.doProcess(10, i->{
			System.out.println("value of i is"+i);
			//System.out.println(this); This will not work
		});
		
		thisReferenceExample.execute();
	}
}
