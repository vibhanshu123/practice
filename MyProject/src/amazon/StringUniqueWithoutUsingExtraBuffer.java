/**
 * 
 */
package amazon;

/**
 * @author Vibs
 *
 */
public class StringUniqueWithoutUsingExtraBuffer {
	
	public static boolean algorithm(String abc){
		if (abc.length()>256) return false;
		boolean[] charset = new boolean[256];
		for(int i=0;i<abc.length();i++){
			int val=abc.charAt(i);
			if(charset[val]) return false ;
			else charset[val] = true ;
		}
		return true ;			
	}
	
	public static void main(String [] args){
		
		System.out.println(algorithm("abcdefe"));
		
	}
	
	public static int [] returnArrayFromBigListOfNumbers(int [] array){
		int [] arrayNew = new int[1024];
		for(int i=0;i<=10000;i++){
			arrayNew[array[i]]= arrayNew[array[i]] + 1;
		}
	}

}
