/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class ReplaceSpaceBypercent20 {
	
	public static char[] replaceSpaceBysomeText(String s,int length){
		char [] charArray = s.toCharArray();
		int numberOfSpaces = 0;
		for(int i=0;i<length;i++){
			if(charArray[i]==' '){
              numberOfSpaces ++;				
			}	
		}
		int newLength = length + 2*numberOfSpaces;
		charArray[newLength]='\0';
		for(int i=length-1;i>0;i--){
			if(charArray[i]==' '){
				charArray[newLength]='0';
				charArray[newLength-1]='2';
				charArray[newLength-2]=	'%';
				newLength = newLength -3 ;
				}
			else{
				charArray[newLength]=charArray[i];
				newLength -- ;
			}
		}
		return charArray;
	}
	
	public static void main(String [] args){
	  char[] charARRAY = replaceSpaceBysomeText("i am a good boy         ","i am a good boy         ".trim().length());
	  for(char c :charARRAY)
		  System.out.print(c);
	}

}
