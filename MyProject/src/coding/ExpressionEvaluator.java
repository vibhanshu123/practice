/**
 * 
 */
package coding;

import java.util.StringTokenizer;

/**
 * @author Vibs
 *
 */
public class ExpressionEvaluator {
	
	public static int eval(String expr) {
	    StringTokenizer st = new StringTokenizer(expr, "()+- ", true);
	    return eval(st);
	}

	private static int eval(StringTokenizer st) {
	    int result = 0;
	    String tok;
	    boolean addition = true;
	    while ((tok = getNextToken(st)) != null) {
	        if (")".equals(tok))
	            return result;
	        else if ("(".equals(tok))
	            result = eval(st);
	        else if ("+".equals(tok))
	            addition = true;
	        else if ("-".equals(tok))
	            addition = false;
	        else if (addition)
	            result += Integer.parseInt(tok);
	        else
	            result -= Integer.parseInt(tok);
	    }
	    return result;
	}

	private static String getNextToken(StringTokenizer st) {
	    while (st.hasMoreTokens()) {
	        String tok = st.nextToken().trim();
	        if (tok.length() > 0)
	            return tok;
	    }
	    return null;
	}
	
	public static void main(String [] args){
       	System.out.println(eval("57+8-(1+42)"));	
	}

}
