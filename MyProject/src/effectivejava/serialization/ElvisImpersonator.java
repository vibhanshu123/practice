package effectivejava.serialization;

// Stealer attack program, produces two distinct Elvis instances! - Page 310

import java.io.*;

public class ElvisImpersonator {
    // Byte stream could not have come from real Elvis instance!
  
    public static void main(String[] args) {
        // Initializes ElvisStealer.impersonator and returns
        // the real Elvis (which is Elvis.INSTANCE)
    	serialize(Elvis.INSTANCE);
        Elvis elvis = (Elvis) deserialize();
        Elvis impersonator = ElvisStealer.impersonator;

        elvis.printFavorites();
        impersonator.printFavorites();
    }

//    // Returns the object with the specified serialized form
//    private static Object deserialize(byte[] sf) {
//        try {
//            InputStream is = new ByteArrayInputStream(sf);
//            ObjectInputStream ois = new ObjectInputStream(is);
//            return ois.readObject();
//        } catch (Exception e) {
//            throw new IllegalArgumentException(e);
//        }
//    }
//    
    
    private static Object deserialize() {
        try {
        	FileInputStream fis = new FileInputStream("testSer.ser");
        	ObjectInputStream ois = new ObjectInputStream(fis);
        	return ois.readObject();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    
    private static void serialize(Elvis elvis) {
        try {
        	FileOutputStream fs = new FileOutputStream("testSer.ser");
            ObjectOutputStream ois = new ObjectOutputStream(fs);
           ois.writeObject(elvis);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
}
