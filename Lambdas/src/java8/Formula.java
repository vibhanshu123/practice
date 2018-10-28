package java8;
interface Formula {
    double calculate(int a);

    
    /**
     * Java 8 enables us to add non-abstract method implementations to interfaces by 
     * utilizing the default keyword. This feature is also known as Extension Methods
     */
    		
    default double sqrt(int a) {
        return Math.sqrt(a);
    }
}

