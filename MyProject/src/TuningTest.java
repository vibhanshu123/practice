
public class TuningTest {

    private static final int WARMUP_ITERATIONS = 1000;
    private static final int TIME_ITERATIONS = 1000;

    public static void main(String[] args) {
        // Create array of 1024 ints
        int[] array = new int[1024];
        for ( int i=0; i<array.length; i++ ) {
            array[i] = array.length - i;
        }

 //        Warmup
        for ( int i=0; i<WARMUP_ITERATIONS; i++ )
            getSortedString(array);

        // Time implementation
        long start = System.currentTimeMillis();
        for ( int i=0; i<TIME_ITERATIONS; i++ )
            getSortedString(array);
        long end = System.currentTimeMillis();

        double avgTime = ((double)(end-start)) / TIME_ITERATIONS;

        System.err.println("Time per sort (ms) = " + avgTime);
    }


    /**
     * Sort the array of integers in ascending order and return a String for it
     */
    public static StringBuilder getSortedString(int[] array) {

        // Sort the array using bubble sort
    //	int length=array.length;
    	
        for ( int i=1; i<array.length; i++ ) {
            for ( int j=0; j<array.length-i; j++ ) {

                if ( array[j] > array[j+1] ) {
                    Integer tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                }
            }
        }

        // Create a String containing all elements in the array
        StringBuilder result = new StringBuilder();
        for ( int i=0; i<array.length; i++ ) {
          //  result += new Integer(array[i]).toString() + " ";
        	result.append(array[i]);
        }

        return result;
    }
}
