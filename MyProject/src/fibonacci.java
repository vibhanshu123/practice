import java.util.ArrayList;
import java.util.List;


public class fibonacci {
	
	public static void main(String [] args){
		int i=0;
		int j=1;
	    List<Integer> list=new ArrayList<Integer>();
	    
	    list.add(i);
	    list.add(j);
	    int c;
	    for(int k=2;k<=10;k++){
	    	c=i+j;
	    	list.add(c);
	    	i=j;
	    	j=c;
	    }
	    
	    System.out.println(list);
		
	}

}
