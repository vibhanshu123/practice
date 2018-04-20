package effectivejava.serialization;

// Broken singleton - has nontransient object reference field! - Page 309

import java.util.*;
import java.io.*;



// Broken singleton - has nontransient object reference field!
public class ElvisOld implements Serializable {
	
    public static final ElvisOld INSTANCE = new ElvisOld();
    private ElvisOld() { }

    private String[] favoriteSongs =
        { "Hound Dog", "Heartbreak Hotel" };
    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }

    private Object readResolve() throws ObjectStreamException {
        return INSTANCE;
    }
    public static void main(String [] args){
     ElvisOld x =ElvisOld.INSTANCE;
     x.printFavorites();
     serialize(ElvisOld.INSTANCE);
     ElvisOld elvis = (ElvisOld) deserialize();
     if(elvis == x) System.out.println("same reference");
     System.out.println(elvis.toString());
     System.out.println(x.toString());
     if(elvis.equals(x)) System.out.println("different objects");
      elvis.printFavorites();
    }
    

    // Returns the object with the specified serialized form
    private static Object deserialize() {
        try {
        	FileInputStream fis = new FileInputStream("testSer.ser");
        	ObjectInputStream ois = new ObjectInputStream(fis);
        	return ois.readObject();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
    
    
    private static void serialize(ElvisOld elvis) {
        try {
        	FileOutputStream fs = new FileOutputStream("testSer.ser");
            ObjectOutputStream ois = new ObjectOutputStream(fs);
           ois.writeObject(elvis);
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }
  
}
