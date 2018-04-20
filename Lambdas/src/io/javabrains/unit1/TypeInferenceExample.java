package io.javabrains.unit1;

public class TypeInferenceExample {
	
	public static void main(String[] args) {
		StringLengthLamba slambda=s->s.length();
		System.out.println(slambda.getLength("hello world"));
		printLambda(s->s.length());
	}
	
	public static void printLambda(StringLengthLamba l) {
		System.out.println(l.getLength("hello lambda"));
	}
	
	interface StringLengthLamba{
		int getLength(String s);
	}

}
