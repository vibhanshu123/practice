/**
 * 
 */
package Validation;

/**
 * @author Vibs
 *
 */
public class ValidatorFactory extends ValidateInput{

	
	@Override
	Validator getValidator(String type) {
		if(type.equals("folder"))
			return new ValidateStartingFolder();
		else if(type.equals("time"))
			return new ValidateTime();
		else if (type.equals("searchOn"))
			return new ValidateTypeOfSearch();
		else return null;
	}

}
