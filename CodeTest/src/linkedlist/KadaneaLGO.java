package linkedlist;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class KadaneaLGO {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
//    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
//    BufferedReader in = new BufferedReader(reader);
//    String line;
//    int i=0;
//     int [] array = null;
//    String[] tokens = null;
//    while ((line = in.readLine()) != null) {
//      tokens=line.split(" ");
//      array = new int[tokens.length];
//      for(String j:tokens){
//       // System.out.println(j);
//        array[i]=Integer.parseInt(j);
//        i++;
//      }
//     // System.out.println(line);
//      
//    }
	  int [] array= {-2,-3,4,-1,-2,1,5,-3};
     System.out.println(maxSum(array));
   
  }
  
   public static int maxSum(int [] array){
    // System.out.println(array.length);
    int sum =0, maxsum=0;
    for(int i: array){
      sum+=i;
      if(maxsum<sum){
        maxsum=sum;
      }
      if(sum<0){
        sum =0;
      }
        
      }
    return maxsum;
    }

    
  }