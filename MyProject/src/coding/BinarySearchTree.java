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
public class BinarySearchTree {
	
	public static void doPrePorder (TreeNode node){
		
		if(node!= null){
		System.out.println(node.getData());
		doPrePorder(node.getLeft());
		doPrePorder(node.getRight());
		}
		
	}
	
	public static void doPostOrder (TreeNode node){
	
		if(node!= null){
		doPostOrder(node.getLeft());
		doPostOrder(node.getRight());
		System.out.println(node.getData());
		}
		
	}
	
	public static void doInPorder (TreeNode node){
	
		if(node != null){
		doInPorder(node.getLeft());
		System.out.println(node.getData());
		doInPorder(node.getRight());
		}
	}
	
	public static TreeNode insertInBST(TreeNode node , Integer data){
		TreeNode insertedNode = null;
		if(data < node.getData()){
		   if(node.getLeft()!=null){
		      insertedNode = insertInBST(node.getLeft(), data);
			}
		   else{
			 insertedNode = new TreeNode(data); 
			 insertedNode.setParent(node);  
			 node.setLeft(insertedNode) ;
		   }  
		}else{
		 if(node.getRight() != null){	
		  insertedNode = insertInBST(node.getRight(), data);			  
		  }
		 else {
			 insertedNode = new TreeNode(data);
			 insertedNode.setParent(node);  
			 node.setRight(insertedNode) ;
		   }
		}
		return insertedNode;
	}
	
	public static Integer getMinimum (TreeNode node){
		if(node == null) return null;
		while(node.getLeft() != null){
			node= node.getLeft();
		}
		return node.getData();
	}
	
	
	public static Integer getMaximum (TreeNode node){
		if(node == null) return null;
		while(node.getRight() != null){
			node= node.getRight();
		} 
		return node.getData();	
	}
	
	public static Integer getPredecessor(TreeNode node){
		TreeNode x = node;
		TreeNode y = node.getParent();
   	  if(node.getLeft() != null){
	     return getMaximum(node.getLeft());
	  }else{
		  while(y!=null && y.getLeft()==x){
			  x=y;
			  y=x.getParent();
		  }
		  return y.getData();
      }
	}
   	  
	
    public static Integer getSuccessor(TreeNode node){
    	if(node == null) return null;
    	if(node.getRight() != null){
    		return getMinimum(node.getRight());
    	}else{
    	TreeNode x = node;
    	TreeNode y = x.getParent() ;
    	while(y!=null && y.getRight()==x){
    		x= y;
    		y= x.getParent();
    	   }
    	return y.getData();
    	}
    } 	  
		
    
    public static void deleteNodeFromBST(TreeNode node){
//    	if(node.left == null && node.right == null){
//    	  TreeNode y = Parent[node];
//    	  if(y.right==node)
//    		  y.right=null;
//    	} else
    	
    }
	
    
    private static Integer min_value = Integer.MIN_VALUE;
    public static boolean checkBinaryTreeIsBinarySearchTree(TreeNode node){
    	if (node == null) return true;
    	if(!checkBinaryTreeIsBinarySearchTree(node.getLeft())) return false;
    	if(node.getData()<min_value) return false ;
    	min_value = node.getData();
    	if(!checkBinaryTreeIsBinarySearchTree(node.getRight())) return false ;
    	return true ;
    }
    
    public static boolean checkBST(TreeNode node , int max , int min){
    	if (node == null) return true;
    	if(node.getData()<min||node.getData()>max) return false;
    	if(!checkBST(node.getLeft(), node.getData(), min) || !checkBST(node.getRight(),max , node.getData()))
    			return false;
    	return true ;
    }
    
    public static int getHeightOfBST(TreeNode root){
    	if (root == null) return 0;
    	else
    		return Math.max(getHeightOfBST(root.getLeft()), getHeightOfBST(root.getRight()))+1;
    }
    
    public static boolean isBalanced(TreeNode root){
       if(root == null) return true;
       int getLeftHeight = getHeightOfBST(root.getLeft());
       int rightHeight = getHeightOfBST(root.getRight());
       int diffInheight= Math.abs(rightHeight-getLeftHeight);
       if(diffInheight >1) return false ;
       else
    	   return isBalanced(root.getLeft())&& isBalanced(root.getRight());
    }
    
    public static boolean moreEfficientIsBalancedTree(TreeNode rootNode){
    	if(checkHeightForBalancedOtherThanGettingTheHeight(rootNode)==-1)
    		return false ;
    		else
    			return true ; 	
    }
    
    public static int checkHeightForBalancedOtherThanGettingTheHeight(TreeNode node){
    	if(node == null)
    		return 0;
    	int leftHeight = checkHeightForBalancedOtherThanGettingTheHeight(node.getLeft());
    	if(leftHeight == -1)
    		return -1;
    	int rightHeight = checkHeightForBalancedOtherThanGettingTheHeight(node.getRight());
    	if(rightHeight == -1)
    		return -1;
    	if(Math.abs(rightHeight-leftHeight)>1){
    		return -1;
    	}
    	else
    		return Math.max(leftHeight, rightHeight)+1;
    	
    }
    
    
	public static void main(String [] args){
		TreeNode rootNode = new TreeNode(10);
		insertInBST(rootNode, 20);
		insertInBST(rootNode, 9);
		insertInBST(rootNode, 8);
		TreeNode node=insertInBST(rootNode, 11);
		insertInBST(rootNode, 17);
		insertInBST(rootNode, 21);
		insertInBST(rootNode, 16);
		insertInBST(rootNode, 15);
		
		
		System.out.println("successor"+getSuccessor(node));
		System.out.println("predecessor"+getPredecessor(node));
		System.out.println("----postOrder Traversal---");
		doPostOrder(rootNode);
		System.out.println("----preOrder Traversal---");
		doPrePorder(rootNode);
		System.out.println("----InOrder Traversal---");
		doInPorder(rootNode);
		System.out.println("Maximum is"+getMaximum(rootNode));
		System.out.println("Minimum is "+getMinimum(rootNode));
		System.out.println("depth of bst is"+getHeightOfBST(rootNode));
		System.out.println("the tree is balanced "+isBalanced(rootNode));
		
		int [] sortedIntegerArray = {1,2,3,4,5,6,7,8,9,11,13,14,15,56,78,90,111,455,678,890};
		TreeNode nodea =createBinaryTreeWithMinimumHeight(sortedIntegerArray,0,sortedIntegerArray.length-1);
		System.out.println("depth of tree is"+getHeightOfBST(nodea));
		System.out.println("tree is balanced"+moreEfficientIsBalancedTree(nodea));
		System.out.println(checkBST(nodea, Integer.MAX_VALUE, Integer.MIN_VALUE));
		System.out.println(checkBinaryTreeIsBinarySearchTree(nodea));
		//System.out.println(createNlinkedListsForNlevelFromBinarySearchTree(nodea));
		//doPostOrder(nodea);
		iterateOverArrayList(createNlinkedListsForNlevelFromBinarySearchTree(nodea));
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
	
	
	public static ArrayList<LinkedList<TreeNode>> createNlinkedListsForNlevelFromBinarySearchTree(TreeNode node){
		
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
	
	public static void iterateOverArrayList(ArrayList<LinkedList<TreeNode>> list){
		int count = 0;
		for(LinkedList<TreeNode> link: list){
			System.out.print("in level "+count+"---");
			for(TreeNode node :link){
			  System.out.print(node.getData()+",");	
			}
			System.out.println("");
			count ++;	
		}
	}
}
