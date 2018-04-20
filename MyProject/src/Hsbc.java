import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;




public class Hsbc {
	
	public Hsbc() {
		// TODO Auto-generated constructor stub
		f1();
	}
	
	public void f1(){
		System.out.println("HSBC");
	}

}

class Hsbca extends Hsbc{
	
	public void f1(){
		System.out.println("kuch nahi hone wala tum aram karo");
	}
	
}

class Hsbcc extends Hsbc{
	
	public void f1(){
		System.out.println("yahin to doubt hai");
	}
}

class D {
	
	public static void main(String [] args){
		
		Hsbc a= new Hsbcc();
		a.f1();
		HashMap b= new HashMap();
		b.put("", 1);
		b.put(null, 2);
		b.put(1, 3);
		System.out.println(b);
		Set s=b.keySet();
		
		
		//for()
		for(Iterator iter=s.iterator();iter.hasNext();){
		//	System.out.println(iter.next());
			System.out.println(b.get(iter.next()));
		}
	}
}

