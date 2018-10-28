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
import Input.Starter;

/**
 * @author Vibs
 *
 */
public class StarterTest {

	private FileProcessor fileProcessorForFile = null;
    private FileProcessor fileProcessorForFolder = null;
    private FileProcessor fileProcessorForBoth = null;
    private Starter starter = null;
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
		starter= null;
	}

	
	@Test
	public void testStarterForFile() {
		starter= new Starter(fileProcessorForFile);
		assertEquals("number of files should be 2 as saved in my system",2,starter.getListOfAllFiles("10").size());
	}
	
	@Test
	public void testStarterForFolder() {
		starter= new Starter(fileProcessorForFolder);
		assertEquals("number of files should be 2 as saved in my system",2,starter.getListOfAllFiles("10").size());
	}
	
	@Test
	public void testStarterForBoth() {
		starter= new Starter(fileProcessorForBoth);
		assertEquals("number of files should be 4 as saved in my system",4,starter.getListOfAllFiles("10").size());
	}
	@Test
	public void testStarterForFileInZeroSeconds() {
		starter= new Starter(fileProcessorForFile);
		assertEquals("number of files should be 2 as saved in my system",null,starter.getListOfAllFiles("0"));
	}
	
	@Test
	public void testStarterForFolderInZeroSeconds() {
		starter= new Starter(fileProcessorForFolder);
		assertEquals("number of files should be 2 as saved in my system",null,starter.getListOfAllFiles("0"));
	}
	
	@Test
	public void testStarterForBothInZeroSeconds() {
		starter= new Starter(fileProcessorForBoth);
		assertEquals("number of files should be 4 as saved in my system",null,starter.getListOfAllFiles("0"));
	}

}
