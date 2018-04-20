/**
 * 
 */
package amazon;

import java.util.ArrayList;
import java.util.LinkedList;



/**
 * @author Vibs
 *
 */
public class BinarySearchTree {
	
	
	
	public static void doInOrder(TreeNode node){
		if(node != null){
			doInOrder(node.getLeft());
			System.out.print(node.getData()+",");
			doInOrder(node.getRight());
		}
		
	}
	
    public void doPreOrder(TreeNode node){
    	if(node != null){
    		System.out.println(node.getData());
			doInOrder(node.getLeft());
			doInOrder(node.getRight());
		}
		
	}

    public void doPostOrder(TreeNode node){
    	if(node != null){
			doInOrder(node.getLeft());
			doInOrder(node.getRight());
			System.out.println(node.getData());
		}
    }
    
    
   

	public static TreeNode insertIntoBST(TreeNode root,Integer data){
		TreeNode insertedNode = null ;
    	if(data<root.getData()){
    		if(root.getLeft()!=null){
    			insertIntoBST(root.getLeft(), data);
    		}else{
    			 insertedNode = new TreeNode(data);
    			root.setLeft(insertedNode) ;
    			insertedNode.setParent(root);
    		}
    	}else{
    		if(root.getRight()!=null){
    			insertIntoBST(root.getRight(), data);
    		}else{
    			insertedNode = new TreeNode(data);
    			root.setRight(insertedNode) ;
    			insertedNode.setParent(root);
    		}
    	} 
    	return insertedNode ;
    }
    
	public static Integer getMaximum(TreeNode root){
		if (root == null) return null ;
		while(root.getRight()!=null) {
			root = root.getRight();
		} 
		return root.getData();
			
	}
	
	public static Integer getMinimum (TreeNode root){
		if (root == null) return null ;
		while(root.getLeft()!=null) {
			root = root.getLeft();
		} 
	   return root.getData();
	}
	
    public static Integer getSuccessor(TreeNode node){
    	if(node == null) return null;
    	TreeNode current = node ;
    	TreeNode parent = node.getParent();
    	if(node.getRight()!=null){
    		return getMinimum(node.getRight());
    	}else {
    		while(parent!=null && parent.getRight()==current){
    			current = parent ;
    			parent = current.getParent();
    		}
    		return parent.getData();
    	}
    }
    
    public static Integer getPredessor(TreeNode node){
    	
    	if(node == null) return null;
    	TreeNode current = node ;
    	TreeNode parent = node.getParent();
    	if(node.getLeft()!=null){
    		return getMinimum(node.getLeft());
    	}else {
    		while(parent!=null && parent.getLeft()==current){
    			current = parent ;
    			parent = current.getParent();
    		}
    		return parent.getData();
    	}
    	
    }
    
    public static boolean isTreeBalanced(TreeNode root){
    	if (root == null) return true ;
    	int getLeftHeight = getHeightOfTree(root.getLeft());
    	int getRightHeight = getHeightOfTree(root.getRight());
    	int diffInHeight = getRightHeight-getLeftHeight;
    	if(Math.abs(diffInHeight)>1)
    		return false ;
    	else return (isTreeBalanced(root.getLeft())&& isTreeBalanced(root.getRight()));
    	
    }
    
    public static Integer getHeightOfTree(TreeNode root){
    	if(root == null) return null ;
    	return Math.max(getHeightOfTree(root.getLeft()), getHeightOfTree(root.getLeft()))+1;
    	
    }
    
    public static Integer getHeightForGettingBalancedOtherThanCheckingHeight(TreeNode root){
    	if(root == null)
    		return 0;
    	int leftHeight = getHeightForGettingBalancedOtherThanCheckingHeight(root.getLeft());
    	if(leftHeight == -1) return -1;
    	int rightHeight = getHeightForGettingBalancedOtherThanCheckingHeight(root.getRight());
    	if(rightHeight == -1) return -1;
    	if(Math.abs(leftHeight-rightHeight)>1) return -1;
    	else 
    		return Math.max(getHeightForGettingBalancedOtherThanCheckingHeight(root.getLeft()),getHeightForGettingBalancedOtherThanCheckingHeight(root.getRight())+1);
    }
    
    public static boolean isBSTBalancedMoreEfficientAlgorithm(TreeNode root){
    	if (getHeightForGettingBalancedOtherThanCheckingHeight(root) == -1)
    		return false;
    	else
    		return true;
    }
    
    public static boolean isBinaryTreeABST(TreeNode root){
    	int minimum = Integer.MIN_VALUE;
    	if(root == null) return true ;
    	if(!isBinaryTreeABST(root.getLeft())) return false ;
    	if(root.getData()<minimum) return false ;
    	minimum = root.getData();
    	if(!isBinaryTreeABST(root.getRight())) return false;
    	return true ;
    	
    }
    
    public static boolean checkBTISBST(TreeNode root){
       return checkBTISABST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);	
    	
    }
    
 
	private static boolean checkBTISABST(TreeNode root, int maxValue,
			int minValue) {
		if(root == null) return true ;
		if(root.getData()<minValue|| root.getData()>maxValue) return false ;
		if((!checkBTISABST(root.getLeft(), root.getData(), minValue)) || (!checkBTISABST(root.getRight(), maxValue, root.getData()))){
			return false ;
		}
		return true;
	}

	public static TreeNode createBSTWIthMinimalHeight(int [] array, int start, int end){
    	if(start>end) return null;
    		int mid = (start+end)/2;	
    		TreeNode rootNode = new TreeNode(array[mid]);
    		rootNode.setLeft(createBSTWIthMinimalHeight(array, start, mid-1));
    		rootNode.setRight(createBSTWIthMinimalHeight(array, mid+1, end));
    		return rootNode ;	
    }
	
	public static void doInOrderWithoutRecursionUsingStack(TreeNode node){
		while (node!=null){
			node = node.getLeft();
			System.out.println(node.getData());
			node = node.getRight();
		}
	}
	
	public static void doInOrderWithoutRecursionUsingThreadedBinaryTrees(TreeNode node){
		while (node!=null){
			node = node.getLeft();
			System.out.println(node.getData());
			node = node.getRight();
		}
	}
     
public static ArrayList<LinkedList<TreeNode>> createNlinkedListsForNlevelFromBinarySearchTree(TreeNode node){		
		if(node == null) return null ;
		LinkedList<TreeNode> current = new LinkedList<TreeNode>();
		ArrayList<LinkedList<TreeNode>> result = new ArrayList<LinkedList<TreeNode>>();
		current.add(node);
		while(current.size()>0){
			result.add(current);
			LinkedList<TreeNode> parents = current;
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

public static boolean isSubTree(TreeNode t1, TreeNode t2){
	if(t1==null && t2 ==null) return true ;
	if(t2== null) return true ;
	if(t1 == null) return false ;
	if(t1.getData() == t2.getData()) return isMatch(t1, t2);
	return isSubTree(t1.getLeft(), t2) || isSubTree(t1.getRight(), t2);	
  }
		
    /**
 * @param t1
 * @param t2
 * @return
 */
private static boolean isMatch(TreeNode t1, TreeNode t2) {
   if(t1.getData()!=t2.getData()) return false ;
   return isMatch(t1.getLeft(), t2.getLeft())&& isMatch(t1.getRight(), t2.getRight());   
    
}

//public static boolean isRootDescendantOfGivenNode(TreeNode root,TreeNode p){
//	if(root == null) return false ;
//	if(root == p) return true ;
//	return isRootDescendantOfGivenNode(root.getLeft(), p)|| isRootDescendantOfGivenNode(root.getRight(), p);
//}
//
//public static TreeNode getClosestAncestorsOfGivenNodes(TreeNode rootNode , TreeNode p,TreeNode q){
//	if (!isRootDescendantOfGivenNode(rootNode, p) || !isRootDescendantOfGivenNode(rootNode, q)){
//     return null ;		
//	}
//	return getAncestorOf(rootNode,p,q);
//}
//
//
//private static TreeNode getAncestorOf(TreeNode rootNode, TreeNode p, TreeNode q) {
//	boolean isPOnLeftSide = isRootDescendantOfGivenNode(rootNode.getLeft(), p);
//	boolean isQOnLeftSide = isRootDescendantOfGivenNode(rootNode.getLeft(), q);
//	if(isPOnLeftSide!=isQOnLeftSide) return rootNode ;
//	TreeNode chilsSide = null ;
//	if(isPOnLeftSide) chilsSide = rootNode.getLeft();
//	else chilsSide = rootNode.getRight();
//	return getAncestorOf(chilsSide, p, q);
//}

	public static void main(String args[]) {
		int [] array = new int[] {1,2,5,8,9,12,23,45,67,89,112,345,346,678};
		TreeNode node = createBSTWIthMinimalHeight(array, 0, array.length-1);
		doInOrder(node);
		System.out.println("------sdfb");
		ArrayList<LinkedList<TreeNode>> list=createNlinkedListsForNlevelFromBinarySearchTree(node);
		iterateOverList(list);
    	TreeNode node1 = new TreeNode(67) ;
    	TreeNode node2 = new TreeNode(1234);
    	System.out.println("is ancestor "+getAncestorOf2nodes(node, node1, node2));
    	System.out.println("is ancestor "+getAncestorOf2nodesInABST(node, node1, node2));
	}
	
	
/**
 * @param list
 */
private static void iterateOverList(ArrayList<LinkedList<TreeNode>> list) {
	for(LinkedList<TreeNode> linkedlist:list){
		for(TreeNode node:linkedlist){
			System.out.print(node.getData()+",");
		}
		System.out.println("----");
	}
	
}

public static boolean isRootNodeAncestorOfGivenNode(TreeNode root,TreeNode node){
	if(root == null) return false ;
	if(root.getData().intValue() == node.getData().intValue()) return true ;
	return (isRootNodeAncestorOfGivenNode(root.getLeft(), node)) || isRootNodeAncestorOfGivenNode(root.getRight(), node);
}

public static TreeNode getClosestAncestors(TreeNode root,TreeNode p, TreeNode q){
	if(root.getData().intValue() == p.getData().intValue() || root.getData().intValue() == q.getData().intValue()){
		return root;
	}
	boolean isPOnLeft = isRootNodeAncestorOfGivenNode(root.getLeft(), p);
	boolean isQOnLeft = isRootNodeAncestorOfGivenNode(root.getLeft(), q);
	if(isPOnLeft!=isQOnLeft) return root;
	TreeNode childSide = null;
	if(isPOnLeft) childSide = root.getLeft();
	else childSide = root.getRight();
	return getClosestAncestors(childSide, p, q);
}

/**
 * @param root
 * @param p
 * @param q
 * @return
 */
private static TreeNode getAncestorOf2nodes(TreeNode root, TreeNode p,TreeNode q) {
    if(!isRootNodeAncestorOfGivenNode(root, p)||!isRootNodeAncestorOfGivenNode(root, q)){
           return null ;
    }
    return getClosestAncestors(root, p, q);
}


private static TreeNode getAncestorOf2nodesInABST(TreeNode root,TreeNode p, TreeNode q){
	if(root==null || p==null|| q==null)
		return null;
	if(!isRootNodeAncestorOfGivenNode(root, p)||!isRootNodeAncestorOfGivenNode(root, q))
		return null;
	return getAncestorOfGivenNodesInABST(root, p,q);
}

/**
 * @param root
 * @param p
 * @param q
 * @return
 */
private static TreeNode getAncestorOfGivenNodesInABST(TreeNode root,
		TreeNode p, TreeNode q) {
	if(root.getData()<p.getData()&&root.getData()<q.getData())
		return getAncestorOfGivenNodesInABST(root.getRight(), p, q);
	else if(root.getData()>p.getData()&&root.getData()>q.getData())
		return getAncestorOfGivenNodesInABST(root.getLeft(), p, q);
	else return root;
}


}	
 

