/**
 * 
 */
package Validation;

import java.io.File;

/**
 * @author Vibs
 *
 */
public class ValidateStartingFolder implements Validator{

    @Override
	public boolean validate(String input) {
		
		File startFolder=new File(input);
		if(startFolder.exists()) return true;
		else return false;
	
	 }
   
}

