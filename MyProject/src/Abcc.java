import java.util.HashMap;


public class Abcc {
	
	public static void main(){
	Integer [] intarray={1,2,2,2,3,3};
	HashMap<Integer, Integer> map=new HashMap<Integer, Integer>();
	for(int a:intarray){
		if(map.get(a)==null){
			map.put(a, 1);
		}
		else{
			map.put(a, map.get(a)+1);
		}
	}
	}
	

}
