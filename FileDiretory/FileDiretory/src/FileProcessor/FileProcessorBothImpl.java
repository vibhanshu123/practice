/**
 * 
 */
package FileProcessor;

import java.io.File;
import java.util.List;

import patternMatcher.RegexPatternMatcher;

/**
 * @author Vibs
 *
 */
public class FileProcessorBothImpl extends FileProcessor{
	
	public FileProcessorBothImpl(File filePath, String searchString) {
		setCurrentFilePath(filePath);
		setSearchPattern(searchString);
	}
	
	@Override
	public List<String> processFile() {
        File listFile[] = getCurrentFilePath().listFiles();
        if (listFile != null) {
            for (int i=0; i<listFile.length; i++) {
                if (listFile[i].isDirectory()) {
               if (RegexPatternMatcher.matchPattern(getSearchPattern(), listFile[i].getName().trim())) {
                    listOfFiles.add(listFile[i].getPath());
                     }
                   setCurrentFilePath(listFile[i]);
                   processFile(); 
                }else if (RegexPatternMatcher.matchPattern(getSearchPattern(), listFile[i].getName().trim())) {
                    	listOfFiles.add(listFile[i].getPath());
                }
              }
             }
        return listOfFiles;
	     }
}
