/**
 * 
 */
package test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import FileProcessor.FileProcessor;
import FileProcessor.FileProcessorBothImpl;
import FileProcessor.FileProcessorFileImpl;
import FileProcessor.FileProcessorFolderImpl;

/**
 * @author Vibs
 *
 */
public class FileProcessorTest {
	
    private FileProcessor fileProcessorForFile = null;
    private FileProcessor fileProcessorForFolder = null;
    private FileProcessor fileProcessorForBoth = null;
	
	@Before
	public void setUp() throws Exception {
		fileProcessorForFile = new FileProcessorFileImpl(new File("c:/MyFolder"),"mn*.*");
		fileProcessorForFolder = new FileProcessorFolderImpl(new File("c:/MyFolder"),"mn*.*");
		fileProcessorForBoth = new FileProcessorBothImpl(new File("c:/MyFolder"),"mn*.*");
	}

	@After
	public void tearDown() throws Exception {
		fileProcessorForFile=null;
		fileProcessorForFolder=null;
		fileProcessorForBoth=null;
	}

	
	@Test
	public void testProcessFileForBoth() {
		assertEquals("number of files should be 4 as saved in my system",4,fileProcessorForBoth.processFile().size());
	}
	
	@Test
	public void testProcessFileForFolder() {
		assertEquals("number of files should be 2 as saved in my system",2,fileProcessorForFolder.processFile().size());
	}
	
	@Test
	public void testProcessFileForFile() {
		assertEquals("number of files should be 2 as saved in my system",2,fileProcessorForFile.processFile().size());
	}

}
