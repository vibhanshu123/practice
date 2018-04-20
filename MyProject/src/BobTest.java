import java.util.HashMap;



	
	public class BobTest{
		public static void main(String[] args){
			HashMap hm= new HashMap();
			hm.put(1, "x");
			hm.put(1, "y");
			//System.out.println(hm);
			String s=  new String("Hello");
			String p=  new String("Hello");
			System.out.println(s==p);
			System.out.println(s.equals(p));
			
//			Bob a=  new Bob(p, 0);
//			Bob b=  new Bob(p, 0);
//			System.out.println(a);
//			
//			System.out.println(a==b);
//			System.out.println(a.equals(b));
//			
//			Bob f = new Bob("GoBobGo",19);
//			System.out.println(f);
			}
	}
    class Bob{
    	int shoesize;
    	String nickName;
    	Bob(String nickName,int shoesize){
    		this.shoesize=shoesize;
    		this.nickName=nickName;
    	}
    	
//    	public String toString(){
//    		return ("I am Bob but you can call me"+nickName+"my age is"+shoesize);
//    	}
    }

