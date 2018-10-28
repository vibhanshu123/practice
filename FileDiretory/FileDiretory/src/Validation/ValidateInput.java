/**
 * 
 */
package Validation;

/**
 * @author Vibs
 *
 */
public abstract class ValidateInput {
	
	abstract Validator getValidator(String type);
	
	public boolean validate(String input,String inputByUser){
		Validator validator = getValidator(input);
		return validator.validate(inputByUser);
	}
	
}
