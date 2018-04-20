/**
 * 
 */
package coding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Vibs
 *
 */
public class NovelString {
	
	public static void main(String [] args){
		readFromFile("d:/abc.txt", "d:/output.txt");
		
	}
	
	public static boolean checkStringForNovel(String string){
		boolean stringIsNovel = true;
		int getMaxSingularity = string.length()-2;
		int getLengthOfMaxDataWithZeroSingularity = string.length() - 1;
		int startDifference = 1;
		for(int i=0;i<getMaxSingularity;i++){
			Set<String> setInNthSingularity = new HashSet<String>();
			for(int j=0;j< getLengthOfMaxDataWithZeroSingularity;j++){			
				String desiredString = ""+string.charAt(j)+string.charAt(j+startDifference);
				if(!setInNthSingularity.add(desiredString)){
					stringIsNovel = false ;
					break ;
				}
			}
			getLengthOfMaxDataWithZeroSingularity --;
			startDifference ++ ;
		}
		return stringIsNovel ;
	}
	
	
	public static void readFromFile(String filePath, String outputFilePath){
		File file = new File(filePath);
		BufferedReader br = null;
		BufferedWriter wr = null;
		try {
		 br = new BufferedReader(new FileReader(file));
		 wr = new BufferedWriter(new FileWriter(outputFilePath));
		String buffer = null ;		
			while((buffer=br.readLine())!=null){
				boolean b = checkStringForNovel(buffer);
				if(b)
				wr.write(buffer +" is a Novel String"+"\n");
				else
				wr.write(buffer + "is not a Novel String"+"\n");		
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				br.close();
				wr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
