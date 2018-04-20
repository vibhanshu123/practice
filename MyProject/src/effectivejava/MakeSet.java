package effectivejava;

// Reflective instantiation with interface access - Page 231

import java.util.*;

public class MakeSet {
    public static void main(String[] args) {
        // Translate the class name into a Class object
        Class<?> cl = null;
        try {
            cl = Class.forName("java.util.TreeSet");
        } catch(ClassNotFoundException e) {
            System.err.println("Class not found.");
            System.exit(1);
        }

        // Instantiate the class
        Set<String> s = null;
        try {
            s = (Set<String>) cl.newInstance();
        } catch(IllegalAccessException e) {
            System.err.println("Class not accessible.");
            System.exit(1);
        } catch(InstantiationException e) {
            System.err.println("Class not instantiable.");
            System.exit(1);
        }

        // Exercise the set 
        System.out.println(Arrays.asList("d","c","c","b","a").subList(1, 3).toString());
        s.addAll(Arrays.asList("d","c","b","a").subList(1, 3));
        System.out.println(s);
    }
}
