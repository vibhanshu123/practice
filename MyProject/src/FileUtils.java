
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class FileUtils {
	
	public static void main(String [] args){
//	boolean newFile = false;
//	try{
//	File file = new File ("fileWrite2.txt");
//	FileWriter fw=new FileWriter(file);
//	fw.write("sdnkdjsnfksjdnf asdnaslndasd \n knjdwkjend");
//	fw.close();
//	fw.flush();
//	System.out.println("sdnk");
//	System.out.println(file.exists()); // look for a real file
//	newFile = file.createNewFile(); // maybe create a file!
//	System.out.println(newFile); // already there?
//	System.out.println(file.exists()); // look again
		try{
	File dir =new File("mydir");
	if(!dir.exists())
		dir.mkdir();
   File abc=new File(dir,"wer.txt");
   BufferedWriter br=new BufferedWriter(new FileWriter(abc));
   
   PrintWriter pw=new PrintWriter(abc);
   pw.println("wat did u do");
   pw.println("nothing it was all magic");
   pw.flush();
   pw.close();
	
	
	
	} catch(IOException e) { }
	
}

}
