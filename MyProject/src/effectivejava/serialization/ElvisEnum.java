package effectivejava.serialization;

// Enum singleton - the preferred approach - Page 311

import java.util.*;

public enum ElvisEnum {
    INSTANCE;
    private String[] favoriteSongs =
        { "Hound Dog", "Heartbreak Hotel" };
    public void printFavorites() {
        System.out.println(Arrays.toString(favoriteSongs));
    }
    
    public static void main(String [] args){
    	System.out.println(Arrays.toString(ElvisEnum.INSTANCE.favoriteSongs));
    }
}