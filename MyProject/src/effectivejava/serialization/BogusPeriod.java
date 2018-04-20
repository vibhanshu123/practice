package effectivejava.serialization;

// Bogus Period attack - Page 303

import java.io.*;
import java.util.Date;

public class BogusPeriod {
    // Byte stream could not have come from real Period instance!
   

    public static void main(String[] args) {
    	Period p = new Period(new Date(), new Date());
    	ByteArrayOutputStream bos = new ByteArrayOutputStream();
    	ObjectOutputStream os;
		try {
			os = new ObjectOutputStream(bos);
			os.writeObject(p);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    
        Period q = (Period) deserialize(bos.toByteArray());
        System.out.println(q);
    }

    // Returns the object with the specified serialized form
    private static Object deserialize(byte[] sf) {
        try {
            InputStream is = new ByteArrayInputStream(sf);
            ObjectInputStream ois = new ObjectInputStream(is);
            return ois.readObject();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
