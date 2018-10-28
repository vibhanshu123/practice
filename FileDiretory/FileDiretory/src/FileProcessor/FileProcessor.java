/**
 * 
 */
package FileProcessor;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Vibs
 *
 */
public abstract class FileProcessor {
	
	private  File currentFilePath = null;

	private  String searchPattern = null;
	
	protected List<String> listOfFiles = new ArrayList<String>();
	
	public File getCurrentFilePath() {
		return currentFilePath;
	}

	public void setCurrentFilePath(File currentFilePath) {
		this.currentFilePath = currentFilePath;
	}

	public String getSearchPattern() {
		return searchPattern;
	}

	public void setSearchPattern(String searchPattern) {
		this.searchPattern = searchPattern;
	}

	public abstract List<String> processFile();
	
}
