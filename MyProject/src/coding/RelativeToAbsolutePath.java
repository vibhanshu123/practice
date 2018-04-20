/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class RelativeToAbsolutePath {
	public static void main(String[] args)
    {
        String path = "/windows/abs/../temp/new/../";
        java.util.Stack<String> parts = new java.util.Stack<String>();
        String part;
        int start = 0;
        for(int i = start; i< path.length(); i++) {
            if(path.charAt(i) == '/') {
                part = path.substring(start, i);
                start = i + 1;
                if(part.isEmpty()) continue;                
                if(part.equals("..")){
                    if(parts.isEmpty()){
                        throw new IllegalArgumentException();
                    } else {
                        parts.pop();
                    }
                } else {
                    parts.push(part);
                }
            }
        }
        
      if(parts.isEmpty()){
            System.out.print("/");
        } else {
            while(!parts.isEmpty())
            {
                System.out.print("/");
                System.out.print(parts.pop());
            }
        }
    }

}
