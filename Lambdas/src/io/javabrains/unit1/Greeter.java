package io.javabrains.unit1;

public class Greeter {
	
	public void greet(Greeting greeting) {
		//System.out.println("Hello World!");
		greeting.perform();
	}

	
	 
	
	public static void main(String[] args) {
		Greeter greet = new Greeter();
		Greeting greeting = new HellowWorldGreeting();
		//greet.greet();
		greet.greet(greeting);
		MyLambda myLambdaFunction1 =()->System.out.println("Hello World!");
		MyAdd addFunction = (int a,int b)-> a + b;
		Greeting myLambdaFunction =()->System.out.println("Hellooooooo World!");
		
		Greeting innerClass = new Greeting() {
			public void perform() {
				System.out.println("Heelo inner class");
			}
		};
		greet.greet(myLambdaFunction);
		greet.greet(innerClass);

	}
	
	

}

interface MyLambda{
	void foo();
}

interface MyAdd{
	int getSum(int x,int y);
}
