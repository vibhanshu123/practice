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
public class FileProcessorFileImpl extends FileProcessor{


	public FileProcessorFileImpl(File filePath, String searchString) {
		setCurrentFilePath(filePath);
		setSearchPattern(searchString);
	}
	
	@Override
	public List<String> processFile() {
		File file = getCurrentFilePath();
		File currentFile = null;
        File listFile[] = file.listFiles();
        if (listFile.length>0 && listFile!=null) {
            for (int i=0; i<listFile.length; i++) {
            	currentFile =listFile[i];
                if (listFile[i].isDirectory()) {
                	setCurrentFilePath(currentFile);
                    processFile();
                } else {
                    if (RegexPatternMatcher.matchPattern(getSearchPattern(), listFile[i].getName().trim())) {
                        listOfFiles.add(listFile[i].getPath());
                    }
                }
            }
        }
        return listOfFiles;
    }

}
