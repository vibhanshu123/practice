package algorithms;

public class InsertionSort {
	
	public static void main(String[] args){
		int [] intArray={9,8,7,6,5,4,3,2,1};
		insertionSort(intArray);
		int i=0;
		int key;
		
		for(int j=1;j<intArray.length;j++){
			key=intArray[j];
			i=j-1;
			while(i>=0&&intArray[i]>key){
				intArray[i+1]=intArray[i];
				i=i-1;
			  }
			intArray[i+1]=key;
		}
		for(int a:intArray){
		System.out.print(a);
		}
	}
	
	public static void insertionSort(int [] array){
		int key ;
		int j;
		for(int i=1;i<array.length;i++){
			key = array[i];
			j=i-1;
			while(j>=0&&key<array[j]){
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=key;
		}
		
		for(int a:array)
			System.out.print(a);
	}

}
