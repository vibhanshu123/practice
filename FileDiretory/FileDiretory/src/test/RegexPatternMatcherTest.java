/**
 * 
 */
package test;


import static org.junit.Assert.assertEquals;

import org.junit.Test;

import patternMatcher.RegexPatternMatcher;

/**
 * @author Vibs
 *
 */
public class RegexPatternMatcherTest {
   
	
	@Test
	public void testMatchPattern1() {
		assertEquals("pattern matching between mnasd.try and mn*.* ",true,RegexPatternMatcher.matchPattern("mn*.*","mnadfsf.dfsdf"));
	}
	
	@Test
	public void testMatchPattern2() {
		assertEquals("pattern matching between amnasd.try and mn*.* ",false,RegexPatternMatcher.matchPattern("mn*.*","amnadfsf.dfsdf"));
	}
	
	@Test
	public void testMatchPattern3() {
		assertEquals("pattern matching between amnasd.try and amn*.t* ",false,RegexPatternMatcher.matchPattern("amn*.t*","amnadfsf.dfsdf"));
	}

}
