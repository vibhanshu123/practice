
public class StaticNestedClasses {
	int x=7;
	static class StaticClass{
		public void go(){
			System.out.println("inside static class");
		}
	}

}

class OtherClass{
	int x=7;
	static class StaticOtherClass{
		public void go(){
			System.out.println("inside other static class");
		}
	}
	
	public static void main(String [] args){
		StaticNestedClasses.StaticClass ab=new StaticNestedClasses.StaticClass();
		ab.go();
		StaticOtherClass as=new StaticOtherClass();
		as.go();
		//System.out.println(x);
	}
}
