/**
 * 
 */
package amazon;

import java.util.Stack;

/**
 * @author Vibs
 *
 */
public class StackWithMin extends Stack<Integer>{
	
	Stack<Integer> stackMin ;
	
	/**
	 * 
	 */
	public StackWithMin() {
		stackMin = new Stack<Integer>();
	}
	
	public Integer pop(){
	 int value = super.pop();
	 if(value==min())
		 stackMin.pop();
	 return value;
	}
	
	public void push(int value){
	 	if(value<=min()){
	 		stackMin.push(value);
	 	}
	 	super.push(value);
	}
	
	public int min(){
	 if(stackMin.isEmpty())
		 return Integer.MAX_VALUE;
	 else
		return stackMin.peek();
	}

}
