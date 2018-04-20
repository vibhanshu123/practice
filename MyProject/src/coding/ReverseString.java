/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class ReverseString {
	
	public static void main(String [] args){
		String s ="vibhanshu is a good boy";
		reverseStringByWords(s);
		serioulsyReverseString(s);
	}

	
	private static void serioulsyReverseString(String s) {
		char [] charArray = s.toCharArray();
		for(int i=0;i<charArray.length;i++)
			System.out.print(charArray[i]-'O');
		// TODO Auto-generated method stub
		
	}



	private static void reverseStringByWords(String s) {
		// TODO Auto-generated method stub
		
	}

}
