import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 */

/**
 * @author Vibs
 *
 */
public class RegEx {
	
	public static void main(String [] args){
		
		Pattern p = Pattern.compile("asdf12");
		Matcher m = p.matcher("asdf12asdf12asdf12asdf12asdf12asdf12asdf12asdf1");
		while(m.find()){
			System.out.println(m.start());
		}
	}

}
