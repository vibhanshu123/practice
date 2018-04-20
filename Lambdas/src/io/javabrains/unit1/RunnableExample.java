package io.javabrains.unit1;

public class RunnableExample {

	public static void main(String[] args) {
		Thread myThread= new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Inside runnable printing");
				
			}
		});
		
		myThread.start();
		
		Thread myLambdathREAD=new Thread(()->System.out.println("Printed Inside lambda runnable"));
		myLambdathREAD.start();

	}

}
