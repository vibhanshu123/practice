import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;


public class Reflection {
	private String privateData=null;

	public void check(){
		System.out.println("check");
	}
	
	public Reflection(String abc){
		this.privateData=abc;
	}
	public Reflection(){
		System.out.println("just time pass");
	}
}

class Class1 extends Reflection{
	
	
}

class Class2 extends Reflection{
	
}

class Class3 extends Reflection{
	
}

class checkup{
	public static void main(String[] args){
		List<Reflection> list=new ArrayList<Reflection>();
		Class1 a=new Class1();
		Class2 b=new Class2();
		Class3 c=new Class3();
        list.add(a);
        list.add(b);
        list.add(c);
        //System.out.println(list);
        
       for(Reflection r:list){
    	   String className=r.getClass().getName();
    	   System.out.println(className);
         }
      Reflection r= new Reflection("xyz");
      
      for(Field f: Reflection.class.getFields()){
    	  System.out.println(f);
      }
      
      //Field f1=Reflection.class.getDeclaredField("privateData");
      
       
	}
}