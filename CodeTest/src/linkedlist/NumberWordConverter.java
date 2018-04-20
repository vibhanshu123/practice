package linkedlist;

public class NumberWordConverter {
	
public static final String digits[] = { "One", "Two", "Three", "Four",
              "Five", "Six", "Seven", "Eight", "Nine"};

public static final String teens[] = {"Eleven", "Twelve", "Thirteen", "Fourteen",
     "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};

public static final String tens[] = {"Ten","Twenty", "Thirty", "Forty", "Fifty",
             "Sixty", "Seventy", "Eighty", "Ninety"};

public static final String bigs[] = {"","Thousand","Million"};
	
	/* A function that prints given number in words */
	public static String numToString(int num)
	{
	   if (num==0) {
		   return "Zero";
	   }else if(num<0) {
		   return "Negative "+numToString(-1*num);
	   }
	   int count =0;
	   String str="";
	   while (num>0) {
		   if(num%1000 !=0) {
			   str=numToString100(num%1000)+bigs[count]+""+str;
		   }
		   num=num/1000;
		   count++;
	   }
	   return str;
	}
	    /* Base cases */
	   
	private static String numToString100(int num) {
		String str= "";
		if(num>=100) {
			str+=digits[num/100-1]+"Hundred";
			num=num%100;
		}
		if(num>=11 && num<=19) {
			return str+teens[num-11]+"";
		}else if(num==10||num>=20) {
			str+=tens[num/10-1]+"";
			num=num%10;
		}
		if(num>=1&&num<=9) {
			str+=digits[num-1]+"";
		}
 		return str;
	}

	/* Driver program to test above function */
	public static void main(String [] args)
	{
	    System.out.println(numToString(9923));
	    System.out.println(numToString(523));
	    System.out.println(numToString(89));
	    System.out.println(numToString(8989));
	    System.out.println(numToString(19323984));
	    System.out.println(numToString(85));
	
	}
}

