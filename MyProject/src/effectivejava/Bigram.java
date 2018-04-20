package effectivejava;

// Can you spot the bug? - Page 176

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;

public class Bigram {
    private final char first;
    private final char second;
    public Bigram(char first, char second) {
        this.first  = first;
        this.second = second;
    }
    
    public boolean equals(Bigram b) {
        return b.first == first && b.second == second;
    }
    @Override
    public int hashCode() {
        return 31 * first + second;
    }

    public static void main(String[] args) {
    	Bigram b = new Bigram('a', 'a');
    	try {
			FileOutputStream fs = new FileOutputStream(new File("d:/FactoryLog"));
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(b);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
			
		}
    	
        Set<Bigram> s = new HashSet<Bigram>();
        for (int i = 0; i < 10; i++)
            for (char ch = 'a'; ch <= 'z'; ch++)
                s.add(new Bigram(ch, ch));
        System.out.println(s.size());
    }
}
