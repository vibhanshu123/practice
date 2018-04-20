package practice;

public class PatternSearchingAlgos {
	
	public static void naivePatternSearchingAlgorithm(String text, String pattern){
	  	int patternLength = pattern.length();
	  	int textLength = text.length();
	  	for(int i=0;i<textLength-patternLength+1;i++){
	  		for(int j=0;j<patternLength;j++){
	  			if(pattern.charAt(j)!=text.charAt(i+j))
	  				break;
	  			if(j==patternLength-1)
	  				System.out.println("text is at index "+i);
	  		}
	  	}
	}
	
	public static void main(String [] args){
		System.out.println("---PRACTICING ALL PATTERN SEARCHING ALGOSRITHMS------");
		System.out.println("----NAIVE PATTERN SEARCHING ALGOS------");
		naivePatternSearchingAlgorithm("AABAACAADAABAAABAA", "AABA");
		Integer [] preProcesedPattern = preProcessingAlgoForKMP("AABA");
		for(int a:preProcesedPattern)
			System.out.print(a+",");
		
		knuthMorrisPrattAlgorithmInPatternSearching("AABAACAADAABAAABAA", "AABA", preProcesedPattern);
		
	}
	
	public static void knuthMorrisPrattAlgorithmInPatternSearching(String text, String pattern, Integer[] preProcessedPattern){
		char [] textArray = text.toCharArray();
		char [] patternArray = pattern.toCharArray();
		int i =0,j=0;
		int lengthOfPattern = pattern.length();
		int n = textArray.length;
		while(i<n){
		  if(textArray[i]==patternArray[j]){i++;j++;
		  }else{
			if(j==0) i++;
			else j = preProcessedPattern[j-1];				
		  }
		 if(lengthOfPattern ==j){
			 System.out.println("Pattern found at the index "+(i-j));
			 //Since j value is equal to 1 more than the index means the length so l[j-1] is done to start the index from the greatest prefix which is
			 // also the suffix of the array
		     j = preProcessedPattern[j-1];
		  }
		}		
	}
	
	public static Integer[] preProcessingAlgoForKMP(String pattern){
	   char[] patternArray = pattern.toCharArray();
	   Integer[] lps = new Integer[patternArray.length];
	   int i=1,j=0;
	   int n = patternArray.length;
	   lps[0]=0;
	   while(i<n){
		  if(patternArray[i]==patternArray[j]){
			  j++;
			  lps[i]=j;
		      i++;
			  }
	   else{
		   if(j==0){
			   lps[i] =0;
			   i++;
		   }else j=lps[j-1]; 
			//IT IS j =lps[j-1] and not lps[j-1]+1 beacuse the the definition of li is the maximum length of the prefix which is also the suffix of the
			// of the same pattern , so l[j-1] will return the maximum length which will return the common index + 1 .   		   
	      }	  
	     }
	   return lps;
	}
	
}
