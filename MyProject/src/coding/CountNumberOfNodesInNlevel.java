/**
 * 
 */
package coding;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author Vibs
 *
 */
public class CountNumberOfNodesInNlevel {
	
	public static void main(String [] args){
		
		int [] sortedIntegerArray = {1,2,3,4,5,6,7,8,9,11,13,14,15,56,78,90,111,455,678,890};
		TreeNode nodea =createBinaryTreeWithMinimumHeight(sortedIntegerArray,0,sortedIntegerArray.length-1);
		iterateOverArrayList(oldcreateNlinkedListsForNlevelFromBinarySearchTree(nodea));
		//doPostOrder(nodea);
		createNlinkedListsForNlevelFromBinarySearchTree(nodea);
		
	}
	
	/**
	 * 
	 */
	private static TreeNode createBinaryTreeWithMinimumHeight(int[] array, int start, int end) {
		if(start>end) return null;
		else{
		int mid = (start + end)/2 ;
		TreeNode rootNode = new TreeNode(array[mid]);
		rootNode.setLeft(createBinaryTreeWithMinimumHeight(array, start, mid-1));
		rootNode.setRight(createBinaryTreeWithMinimumHeight(array, mid+1, end));
		return rootNode;
		}
	}	
	
public static void createNlinkedListsForNlevelFromBinarySearchTree(TreeNode node){
		
		ArrayList<TreeNode> current = new ArrayList<TreeNode>();
		int levelCount =0 ;
		if(node!=null)
			levelCount = 1;
		int count = 1;
		int level = 0;
		int maxLevel = 0;
		while(levelCount>0){
			level ++ ;
			ArrayList<TreeNode> parents = current ;
			levelCount = 0 ;
			for(TreeNode parent : parents){
				if(parent.getLeft()!=null)
					levelCount ++ ;
				if(parent.getRight()!=null)
					levelCount ++;
			}
			
		  if(levelCount>count){
			 count = current.size();
			 maxLevel = level ;
		  }	
		
		}
		System.out.println("level is"+maxLevel+"size is"+count);
	}	
	
	public static void iterateOverArrayList(ArrayList<LinkedList<TreeNode>> list){
		int count = 0;
		for(LinkedList<TreeNode> link: list){
			System.out.println("in level"+count);
			for(TreeNode node :link){
			  System.out.println(node.getData());	
			}
			count ++;	
		}
	}
	
	
	
	public static ArrayList<LinkedList<TreeNode>> oldcreateNlinkedListsForNlevelFromBinarySearchTree(TreeNode node){
		
		if(node == null) return null ;
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		if(node!=null)
			current.add(node);
		
		while(current.size()>0){
			result.add(current);
			LinkedList<TreeNode> parents = current ;
			current = new LinkedList<TreeNode>();
			for(TreeNode parent : parents){
				if(parent.getLeft()!=null)
					current.add(parent.getLeft());
				if(parent.getRight()!=null)
					current.add(parent.getRight());
			}
		}
		return result ;
	}	
	
	


}
