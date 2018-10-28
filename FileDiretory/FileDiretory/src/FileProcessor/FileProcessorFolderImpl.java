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
public class FileProcessorFolderImpl extends FileProcessor{

	public FileProcessorFolderImpl(File filePath, String searchString) {
		setCurrentFilePath(filePath);
		setSearchPattern(searchString);
	}
	
	@Override
	public List<String> processFile() {
        File listFile[] = getCurrentFilePath().listFiles();
        File currentFile = null;
        if (listFile != null) {
            for (int i=0; i<listFile.length; i++) {
            	currentFile =listFile[i];
                if (listFile[i].isDirectory()) {
           if (RegexPatternMatcher.matchPattern(getSearchPattern(), listFile[i].getName().trim())) {
                	listOfFiles.add(listFile[i].getPath());
                	}
               setCurrentFilePath(currentFile);
              processFile();
            }
        }
      }
      return listOfFiles;
	}
	
}
