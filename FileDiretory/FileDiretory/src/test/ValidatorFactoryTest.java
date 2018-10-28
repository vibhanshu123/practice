/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Validation.ValidateStartingFolder;
import Validation.ValidateTime;
import Validation.ValidateTypeOfSearch;
import Validation.Validator;

import FileProcessor.FileProcessor;
import FileProcessor.FileProcessorBothImpl;
import FileProcessor.FileProcessorFileImpl;
import FileProcessor.FileProcessorFolderImpl;

/**
 * @author Vibs
 *
 */
public class ValidatorFactoryTest {
    private Validator timeValidator = null;
    private Validator typeOfSearchValidator = null;
    private Validator folderValidator = null;
	
	@Before
	public void setUp() throws Exception {
		timeValidator = new ValidateTime();
		typeOfSearchValidator = new ValidateTypeOfSearch();
		folderValidator = new ValidateStartingFolder();
	}

	@After
	public void tearDown() throws Exception {
		timeValidator=null;
		typeOfSearchValidator=null;
		folderValidator=null;
	}

	
	@Test
	public void testTimeValidatorForValidInput() {
		assertEquals("valid number",true,timeValidator.validate("123"));
	}
    
	@Test
	public void testTimeValidatorForInValidInput() {
		assertEquals("Invalid number",false,timeValidator.validate("12a3"));
	}
	
	@Test
	public void testTypeOfSearchValidatorForValidInput() {
		assertEquals("valid serch type",true,typeOfSearchValidator.validate("both"));
	}
    
	@Test
	public void testTypeOfSearchValidatorForInValidInput() {
		assertEquals("Invalid number",false,typeOfSearchValidator.validate("none"));
	}
	@Test
	public void teststartingFolderForValidInput() {
		assertEquals("Folder Exists",true,folderValidator.validate("c:/MyFolder"));
	}
    
	@Test
	public void teststartingFolderForInValidInput() {
		assertEquals("Folder doesnt exist",false,folderValidator.validate("c:/asf"));
	}
	

}
