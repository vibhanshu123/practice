package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

final class Car {
	int a;
	static float b;
	static String c;
	public Car(){
		System.out.println("default");
	}
	public Car(int a){
		this.a=a;
	}
	
	public Car(float b){
	this.b=b;	
	}
	
	public Car(String c){
		this.c=c;
	
	}
	
	public static void method1(){
		System.out.println("method1");
	}
	
	public int method2(){
		return 1;
	}
	
	
	public final static int method3(){
		System.out.println("fadu method");
	 return 2;
	}
	
	
	
	public static void main(String[] args) throws ClassNotFoundException{
		//Class c1=Class.forName("Car");
		Map map = new HashMap();
		map.put("a", 1);
		map.put("b", 2);
		Set set = map.keySet();
		System.out.println("set is"+set);
		for(Iterator iter = set.iterator();iter.hasNext();){
		   String key =(String) iter.next();
		   System.out.println("key is"+key);
		   System.out.println("value is"+map.get(key));
		}
		
		
		Class c1=Car.class;
//		String classname= c1.getName();
//		System.out.println(c1);
//		System.out.println(classname);
//		Car c=new Car();
		Class classa=Class.forName(c1.getClass().getName());
//		System.out.println(c1.getModifiers());
//		System.out.println(Modifier.isPublic(c1.getModifiers()));
//		System.out.println(c1.getPackage());
//		System.out.println(c1.getSuperclass());
//		System.out.println(c1.getConstructors());
	Constructor[] constructors = c1.getConstructors();
	for(Constructor a:constructors){
		System.out.println(a);
		for(Class classc:a.getParameterTypes()){
		System.out.println(classc);
		}
	}
	
	Method[] methods=c1.getMethods();
	for(Method m:methods){
		System.out.println(m);
	}
	
	System.out.println("----------------fields-----------");
	Field [] fields=c1.getFields();
	for(Field f:fields){
		System.out.println(f);
	}
	
	// constructor= c1.getConstructor(new Class[]{String.class});
//	Constructor constructor=Car.class.getConstructor(int.class);
	
	}
	
	
	
}
