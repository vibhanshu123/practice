import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 */

/**
 * @author vibhanshu.jha
 *
 */
public class FileProcessor {
	
	public static void main(String [] args){
      File file = new File("e:/base/data.csv");
      try {
		BufferedReader reader=new BufferedReader(new FileReader(file));
		String line=null;
		HashMap<String, String> abc= new HashMap<String ,String>();
		
		while((line=reader.readLine())!=null){
		  String [] tokens=line.split(",");
		  String mdn=tokens[0];
		  String contentString =tokens[1]+"^"+tokens[2];
		  if (abc.get(mdn)!=null){
			  String rbtString=abc.get(mdn)+"|"+contentString;
			  abc.put(mdn, rbtString);
		  }else{
			  abc.put(mdn, contentString);
		  }		  
		} 
		
		writeDataToFile(abc);
		
		System.out.println("process completed");
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	/**
	 * @param abc
	 */
	private static void writeDataToFile(HashMap<String,String> abc) {
		BufferedWriter writer=null;
		try {
			writer=new BufferedWriter(new FileWriter(new File("e:/base/data3.csv")));
			Set keySet=abc.keySet();
			for(Iterator iter=keySet.iterator();iter.hasNext();){
				String mdn=(String)iter.next();
				String rbtList=abc.get(mdn);
				writer.write(mdn+","+rbtList);
				writer.newLine();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				writer.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}
