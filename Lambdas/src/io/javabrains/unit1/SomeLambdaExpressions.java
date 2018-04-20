package io.javabrains.unit1;

public class SomeLambdaExpressions {
	
	public static void main(String [] args) {
		System.out.println("greetingfunction = () -> System.out.print(Hello World!)");
		System.out.println("doublenumberfunction =(int a) -> 2*a");
		System.out.println("addFunction = (inta,intb)->a+b");
		System.out.println("safeDivide =(int a, intb )->{if b==0 return 0 else return a/b");
			 
		System.out.println("}");
		 
		System.out.println("stringLengthCount = (String s) -> s.length()");
	}

}
