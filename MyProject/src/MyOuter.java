
public class MyOuter {
	
	private int x=7;
	public void makeInner(){
		Myinner in=new Myinner();
		in.seekOuter();
		
	}
	class Myinner{
		public void seekOuter(){
			System.out.println("Outer x is "+x);
			System.out.println("Inner class object refernece"+this);
			System.out.println("Outer class current object refernece"+MyOuter.this);
		}
	}

}

class Outer{
	
	public static void main(String[] args){
		
		//MyOuter mo=new MyOuter();
		MyOuter.Myinner inner=new MyOuter().new Myinner();
		inner.seekOuter();
		
		
	}
	
}
