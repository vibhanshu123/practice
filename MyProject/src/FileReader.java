import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;


public class FileReader {
	
	public static void main (String args[]){
		
		String filePath= "E:/softwares/jpo/performance/New Folder/sms2010012912301.txt";
		File file = new File(filePath);
		long start=System.currentTimeMillis();
		InputStreamReader inputStreamReader=null;
try {
	    inputStreamReader = new InputStreamReader(new FileInputStream(file));
		BufferedReader bw = new BufferedReader(inputStreamReader);
		String line= null;
		StringBuffer buffer = new StringBuffer();
        while((line=bw.readLine())!=null){
				buffer.append(line);
				buffer.append(System.getProperty("line.separator"));
		}	
		 
	 File newFile = new File("E:/softwares/jpo/performance/New Folder/sms.txt");	 
	 BufferedWriter bw1= new BufferedWriter(new OutputStreamWriter(new FileOutputStream(newFile)));
	//OutputStreamWriter ow1= new OutputStreamWriter(new FileOutputStream(newFile));
	bw1.write(buffer.toString());	 
	
	
	long end = System.currentTimeMillis();
	System.out.println("time "+(end-start));
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
}
	
	
	public String writeMessageToFile(String smsText) {
          OutputStreamWriter osw = null;
		  OutputStream fos = null;
		osw = new OutputStreamWriter(fos);

		  BufferedWriter bw = new BufferedWriter(osw);
		  try {
		      bw.write(smsText);
		      bw.newLine();
		      bw.flush();
		  } catch (IOException e) {
		     return null;
		  }
		return smsText;
		  
		}

		 

}
