/**
 * 
 */
package amazon;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/**
 * @author Vibs
 *
 */
public class StackForRange extends Stack<Integer>{
	
	Stack<HashMap<Integer, Integer>> stackMin ;
	Stack<HashMap<Integer, Integer>> stackMax ;
	
	public StackForRange() {
		stackMin = new Stack<HashMap<Integer,Integer>>();
		stackMax = new Stack<HashMap<Integer,Integer>>();
	}
	
	public int range(){
		return max()-min();
	}
	
	public Integer pop(){
		Integer value = super.pop();
		if(value==max()){
			int count = stackMax.peek().get(value);
			if(count ==1) stackMax.pop();
			else stackMax.peek().put(value, count-1);
		}
		if(value==min()){
			int count = stackMin.peek().get(value);
			if(count ==1) stackMin.pop();
			else stackMin.peek().put(value, count-1);
		}
		return value;
		
	}
	
	 public void push(int value){				  
		if(value==max()){
			 int countMax = stackMax.peek().get(value);
			 stackMax.peek().put(value, countMax+1);
		}
		if(value==min()){
			int countMin = stackMin.peek().get(value);	
			stackMin.peek().put(value, countMin+1); 
		}
		HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
		map.put(value, 1);
		if(value<=min())	stackMin.push(map);	
		if(value>=max())    stackMax.push(map);		
		super.push(value);
	 }
	
	 public Integer min(){
		 Integer key = null;
		if(stackMin.isEmpty())
			return Integer.MAX_VALUE;
		else {
			HashMap<Integer, Integer> map = stackMin.peek();
			Iterator iter = map.keySet().iterator();
			while(iter.hasNext())
				 key = (Integer)iter.next();
			return key;
		}
	   }
	
	 public int max(){
		 Integer key = null;
		 if(stackMax.isEmpty())
				return Integer.MIN_VALUE;
			else {
				HashMap<Integer, Integer> map = stackMax.peek();
				Iterator iter = map.keySet().iterator();
				while(iter.hasNext())
					 key = (Integer)iter.next();
				return key;
			}
	   }
	 	 
	 
	 public static void main(String [] args){
		 StackForRange rangeStack = new StackForRange();
		 rangeStack.push(5);
		 rangeStack.push(3);
		 rangeStack.push(6);
		 rangeStack.push(10);
		 rangeStack.push(1);
		 rangeStack.push(1);
		 rangeStack.pop();
		 System.out.println("range is "+rangeStack.range());
	 }

}
