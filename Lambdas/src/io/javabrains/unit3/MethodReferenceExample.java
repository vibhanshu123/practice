package io.javabrains.unit3;

public class MethodReferenceExample {
	
	public static void main(String [] args) {
		Thread t = new Thread(()->printMessage());
		Thread t1 = new Thread(MethodReferenceExample::printMessage);//()->method()
		t.start();
		t1.start();
	}
	
	public static void printMessage() {
		System.out.println("Hello");
	}

}
