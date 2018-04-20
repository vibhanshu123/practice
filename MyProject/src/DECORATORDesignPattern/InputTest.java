package DECORATORDesignPattern;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputTest {
	
	public static void main(String[] args)throws IOException{
		int c;
		
			try {
				InputStream in=new LowerCaseInputStream(new BufferedInputStream(new FileInputStream("e:/abc.txt")));
				while((c=in.read())>0){
				System.out.println((char)c);	
				}
				in.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		
	}

}
