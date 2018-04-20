/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class RotateArrayByKTimes {
	
	public static int getGCD(int a, int b){
		if (b==0) return a;
		return getGCD(b, a%b);
	}
	
	public static void main(String [] args){
		System.out.println(getGCD(5, 2));
		int [] array = {1,2,3,4,5,6};
		for(int a: array)
			System.out.print(a);
		System.out.println("--");
		array=rotateCopyClockWise(array, 2);
		
		for(int a: array)
			System.out.print(a);
	}
	
	public static int[] rotateCopyClockWise(int [] array, int distance){
		int temp, temp2;
		int gcd = getGCD(array.length, distance);
		for(int i=0;i<gcd;i++){
			temp = array[i];
			int a=i;
			for(int j=0;j<array.length/gcd;j++){
				temp2=array[(a+distance)%array.length];
				array[(a+distance)%array.length] = temp;
				temp = temp2;
				a=(a+distance)%array.length;
			}
		}
		return array;
	}
	
	
	
	public static int[] rotateCopyAntiClockWise(int [] array, int distance){
		int temp, temp2;
		int gcd = getGCD(array.length, distance);
		for(int i=0;i<gcd;i++){
			temp = array[i];
			int a=i;
			for(int j=0;j<array.length/gcd;j++){
				temp2=array[(a+distance)%array.length];
				array[(a+distance)%array.length] = temp;
				temp = temp2;
				a=(a+distance)%array.length;
			}
		}
		return array;
	}
		
	

}
