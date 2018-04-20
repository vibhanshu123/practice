
public class OveridingEquals {
	
	public static void main(String[] args){
		A a=new A(10);
		A b=new A(10);
		if(a.equals(null)){
			System.out.println("botha are same objects");
		}
		else{
			System.out.println("no they r not");
		}
		
	}

}

class A {
	private int aValue;
	A(int val){
		aValue=val;
	}
	public int getAValue(){
		return aValue;
	}
//	@Override
//	public boolean equals(Object obj) {
//		// TODO Auto-generated method stub
//		 if ((obj instanceof A)&& (((A)obj).getAValue()==this.getAValue())) {
//		   return true;
//			}
//		 else{
//		   return false;
//		 }
//			 
//	}
	
}
