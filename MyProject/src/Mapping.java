import java.util.HashMap;


public class Mapping {
	
	public static void main(String[] args){
		doDuplicatesForIntegers();
		doDuplicatesForStrings();
	}

	
	private static void doDuplicatesForStrings() {
		String str="aaaaassssdddfqwer";
		char [] chararray=str.toCharArray();
		String b=null;
		HashMap<String, Integer> hash=new HashMap<String,Integer>();
		for(char a:chararray){
			b=""+a;
			if(hash.get(b)==null){
			  hash.put(b, 1);	
			}
			else{
				hash.put(b,hash.get(b)+1);
			   }
		     }
		 System.out.println(hash);
	   }
		


	public static void doDuplicatesForIntegers(){
		Integer [] intArray={2,2,2,3,3,3,3,6,4,5,9,9,9,9,9,9,9,10};
		HashMap<Integer, Integer> hash=new HashMap<Integer,Integer>();
		for(int a:intArray){
			if(hash.get(a)==null){
			  hash.put(a, 1);	
			}
			else{
				hash.put(a,hash.get(a)+1);
			   }
		     }
		 System.out.println(hash);
	   }
	}