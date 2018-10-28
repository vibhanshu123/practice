package Input;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import Validation.ValidateInput;
import Validation.ValidatorFactory;
import FileProcessor.FileProcessor;
import FileProcessor.FileProcessorBothImpl;
import FileProcessor.FileProcessorFileImpl;
import FileProcessor.FileProcessorFolderImpl;


public class Input {
	
    public static void main(String[] args) {
    	ValidateInput validation= new ValidatorFactory();
    	boolean validInput = true;
    	System.out.println("Enter The top folder to start search.Example: C:/MyFolders");
    	String inputUser =getInputFromConsole();
    	validInput =validation.validate("folder", inputUser);
    	while(!validInput){
    		System.out.println("Please enter a valid Input:There is No Folder By That Name");
    		 inputUser =getInputFromConsole();
    		validInput =validation.validate("folder",inputUser);
    	}
		File startFolder=new File(inputUser);
		System.out.println("Enter Type of item to search. File or Folder or Both.Please Enter FILE for file ,FOLDER for FOLDER and BOTH for BOTH ");
		inputUser =getInputFromConsole();
		validInput =validation.validate("searchOn", inputUser);
    	while(!validInput){
    		System.out.println("Please enter a valid Input: FILE/FOLDER/BOTH");
    		 inputUser =getInputFromConsole();
    		validInput =validation.validate("searchOn",inputUser);
    	}
    	String searchType = inputUser;
		System.out.println("Enter Search pattern - Java regular expressions (java.util.regex) are accepted as the pattern");
		String searchPattern =getInputFromConsole();
		System.out.println("Enter Timeout (in secs) by which application must return.");
		inputUser =getInputFromConsole();
		validInput =validation.validate("time", inputUser);
    	while(!validInput){
    		System.out.println("Please enter a valid Input:Time should be a valid integer");
    		 inputUser =getInputFromConsole();
    		validInput =validation.validate("time",inputUser);
    	}
		String timeOutSeconds = inputUser;
        processInput(startFolder,searchType,searchPattern,timeOutSeconds); //Replace this with a suitable directory
    }
    
    public static String getInputFromConsole(){
    	BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
		String input = null;
		try {
			input = bufferedReader.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return input;
    }
 
 
    public static void processInput(File dir, String searchType, String searchPattern,String timeOutInSeconds) {
       FileProcessor processor = null;	
       if(searchType.equalsIgnoreCase("FILE"))
    	   processor=new FileProcessorFileImpl(dir,searchPattern);
       else if(searchType.equalsIgnoreCase("FOLDER"))
    	   processor=new FileProcessorFolderImpl(dir,searchPattern);
       else if(searchType.equalsIgnoreCase("BOTH"))
    	   processor = new FileProcessorBothImpl(dir,searchPattern);
       Starter starter= new Starter(processor);
       List<String> getAllNames =starter.getListOfAllFiles(timeOutInSeconds);
       printAllNames(getAllNames);
    }

	
	private static void printAllNames(List<String> getAllNames) {
		if(getAllNames!=null&&getAllNames.size()>0){
		 for(String s:getAllNames)
			 System.out.println(s);
		}
	}
}