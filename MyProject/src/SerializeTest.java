
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.LinkedList;


public class SerializeTest {
	
	public static void main(String [] args) throws IOException{
		
		TestSerialize ts=new TestSerialize(1, 2);
		FileOutputStream fos= new FileOutputStream("e:/vib.txt");
		ObjectOutputStream os=new ObjectOutputStream(fos);
		os.writeObject(ts);
		
		LinkedList l = new LinkedList();
		
	}

}
