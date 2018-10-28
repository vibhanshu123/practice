package patternMatcher;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTestPatternMatcher {
 // public static final String EXAMPLE_TEST = "This is my small example string which I'm going to use for pattern matching.";

  public static boolean matchPattern(String patternString,String filePathName) {
	  Pattern pattern=Pattern.compile(patternString);
	  Matcher matcher = pattern.matcher(filePathName);
	  if (matcher.matches()){
		  return true;
	  }
     return false;
  }
  
  public static void main(String[] args){
	  String patternString ="MFile*.*";
	  String filePathName ="UMFile123.txt";
	 System.out.println(matchPattern(patternString, filePathName));
  }
} 