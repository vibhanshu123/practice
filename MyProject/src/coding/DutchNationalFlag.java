/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class DutchNationalFlag {
	
	public static void dutchAlgorithm(char[] array){
		int indexOfR =0;
		int indexofB = array.length-1;
		for(int i=0;i<indexofB;){
			if(array[i]=='R'){
				swap(array,i,indexOfR);
				i++;
				indexOfR++;
			}else if(array[i]=='B'){
				swap(array,i,indexofB);
				indexofB --;
			}else{
				i++;
			}
		}
		
		for(char c:array){
			System.out.println(c);
		}
	}

	/**
	 * @param array
	 * @param i
	 * @param indexofB
	 */
	private static void swap(char[] array, int i, int j) {
		char temp =array[i];
		array[i]=array[j];
		array[j]=temp;
	}
	
	public static void main(String [] args){
		char [] charArray ={'R','B','G','R','B','G','R','G','B','B','G','R'};
		dutchAlgorithm(charArray);
	}

}
