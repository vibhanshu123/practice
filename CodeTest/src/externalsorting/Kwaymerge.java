package externalsorting;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.stream.Stream;

public class Kwaymerge {
	
	public static void main(String [] args) {
		int[] array1= {1,4,6,8,9,34};
		int[] array2= {2,5,7,9,35,67};
		int[] array3= {3,90,213,546,678,8910};
		int[] array4= {6,7,8,34,56,89};
		int[] array5= {9,11,23,27,31,33};
		int[] array6= {12,14,16,18,19,21};
		int[] array7= {40,50,60,70,80,90};
		int array[][] = new int[7][6];
		convert1dto2d(array1, array,0);
		convert1dto2d(array2, array,1);
		convert1dto2d(array3, array,2);
		convert1dto2d(array4, array,3);
		convert1dto2d(array5, array,4);
		convert1dto2d(array6, array,5);
		convert1dto2d(array7, array,6);
	    merge(array);
	    
	   
	}

	private static void merge(int[][] array) {
		PriorityQueue<QueueNode> pq = new PriorityQueue<QueueNode>();
		int size =0;
		for(int i=0;i<array.length;i++) {
			size+=array[i].length;
			if(array[i].length>0) {
				pq.add(new QueueNode(i,0,array[i][0]));
			}
		}
		
		int [] result = new int[size];
		for(int i=0;!pq.isEmpty();i++) {
			QueueNode node = pq.poll();
			result[i]=node.value;
			int newIndex= node.index+1;
			if(newIndex<array[node.array].length) {
				pq.add(new QueueNode(node.array, newIndex, array[node.array][newIndex]));
			}
			
		}
		
		System.out.println(Arrays.toString(result));
		
	}

	public static void convert1dto2d(int[] array1, int[][] array,int n) {
		for(int j=0;j<array1.length;j++) {
			array[n][j]=array1[j];
		}
	}

}

