/**
 * 
 */
package Validation;

/**
 * @author Vibs
 *
 */
public class ValidateTime implements Validator{

	
	@Override
	public boolean validate(String input) {
		try{
			Integer inputTime= Integer.parseInt(input);
			}catch(NumberFormatException numberFormatException){
		      return false;
			}
			return true;
		}

}
