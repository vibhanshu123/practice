/**
 * 
 */
package Validation;

/**
 * @author Vibs
 *
 */
public class ValidateTypeOfSearch implements Validator{

	
	@Override
	public boolean validate(String input) {
		if(input.equalsIgnoreCase("both")||input.equalsIgnoreCase("folder")||input.equalsIgnoreCase("file"))
		return true;
		else return false;
	}

}
