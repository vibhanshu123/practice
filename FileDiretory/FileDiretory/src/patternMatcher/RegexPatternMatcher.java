package patternMatcher;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPatternMatcher {

  public static boolean matchPattern(String patternString,String filePathName) {
	  
	  Pattern pattern=Pattern.compile(patternString);
	  Matcher matcher = pattern.matcher(filePathName);
	  return matcher.matches();
  }
  
} 