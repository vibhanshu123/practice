package practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class BinarySearchTree {
	
	//private static TreeNode<Integer> root = null;
	 private static Integer MAX_INTEGER = Integer.MAX_VALUE;
	 
	 private static Integer MIN_INTEGER = Integer.MIN_VALUE;
	
	 public static void main(String [] args){
		 TreeNode<Integer> root = new TreeNode<Integer>(null,null,10);
		 TreeNode<Integer> root1 = new TreeNode<Integer>(null,null,10);
		 insertDataInBST(root);	 
		 System.out.println("---INORDER TRAVERSAL----");
		 doInOrder(root);
		 System.out.println("-------");
		 System.out.println("---PREORDER TRAVERSAL----");
		 doPreOrder(root);
		 System.out.println("-------");           
		 System.out.println("-----POSTORDER TRAVERSAL----");
		 doPostOrder(root);
		 System.out.println("-------");  
		 System.out.println("--IS BINARY TREE A BINARY SEARCH TREE---");
		 System.out.println("recursive approach "+isBinaryTreeIsABST(root));
		 System.out.println("using inorder "+isBinaryTreeIsABinarySearchTreeUsingInOrder(root));
		 System.out.println("----MAXIMUM NODE IN BINARY TREE---");
		 System.out.println("Maximum node is "+getMaximum(root));
		 System.out.println("----MINIMUM NODE IN BINARY TREE---");
		 System.out.println("Minimum node is "+getMinimum(root));
		 System.out.println("--HEIGHT OF THE TREE----");
		 System.out.println("height of the tree is"+getHeightOfTheTree(root));
		 System.out.println("-FINDING SUCCESSOR OF GIVEN NODE--");
		 getSuccessorFromVariousInputs(root);
		 System.out.println("-FINDING PREDECESSOR OF GIVEN NODE--");
		 getPredecessorFromVariousInputs(root);
		 System.out.println("-----IS BINARY TREE A BALANCED TREE----");
		 insertDataInBalancedBST(root1);
		 System.out.println("is it balanced using n2 complexity "+isBinaryTreeIsABalancedTreeOrderNSquareAlgo(root));
		 System.out.println("is it balanced using n2 complexity "+isBinaryTreeIsABalancedTreeOrderNSquareAlgo(root1));
		 System.out.println("is it balanced using n complexity "+isBinaryTreeIsABalancedTreeOrderNAlgo(root));
		 System.out.println("is it balanced using n complexity "+isBinaryTreeIsABalancedTreeOrderNAlgo(root1));
		 System.out.println("----ANCESTOR IN A BINARY TREE---");
		 getClosestAncestorOfBinaryTreeForALLBoundaryConditions(root);
		 System.out.println("---ANCESTOR IN A BINARY SEARCH TREE----");
		 getClosestAncestorOfBinarySearchTreeForALLBoundaryConditions(root);
		 System.out.println("---DIAMETER OF A GIVEN BINARY SEARCH TREE----");
		 System.out.println("diameter of bigger tree "+findDiameterOfAGivenBinaryTree(root));
		 System.out.println("diameter of smaller tree "+findDiameterOfAGivenBinaryTree(root1));
		 System.out.println("---DIAMETER USING MORE OPTIMIZED ALGO-------");
		 System.out.println("diameter of bigger tree "+findDiameterOfAGivenBinaryTreeMoreOtimized(root, 0));
		 System.out.println("diameter of smaller tree "+findDiameterOfAGivenBinaryTreeMoreOtimized(root1, 0));
		 System.out.println("---------TRAVERSALS WITHOUT RECURSION-----");
		 System.out.println("----INORDER TRAVERSAL------");
		 doInOrderWithoutRecursion(root);
		 System.out.println("-------");
		 System.out.println("----POSTORDER TRAVERSAL------");
		 doPostOrderWithoutRecursion(root);
		 System.out.println("--------");
		 System.out.println("----PREORDER TRAVERSAL------");
		 doPreOrderWithoutRecursion(root);
		 System.out.println("--------");
		 System.out.println("-----LEVEL ORDER TRAVERSAL USING LINKED LIST FOR EACH LEVEL----");
		 itearteOverArrrayListOfLinkedLists(getLinkedListsForDifferentLevelsFromGivenTree(root));
		 System.out.println("--------");
		 itearteOverArrrayListOfLinkedLists(getLinkedListsForDifferentLevelsFromGivenTree(root1));
		 System.out.println("--BEST BINARY SEARCH TREE FROM A SORTED ARRAY-----");
		 int [] intArray={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,20,25,27};
		 int [] intArray1={4,5,7,8,9,10,20,25,27};
		 itearteOverArrrayListOfLinkedLists(getLinkedListsForDifferentLevelsFromGivenTree(createMostCompleteBinarySearchTreeFromASortedArray(intArray,0,intArray.length)));
		 System.out.println("-------");
		 itearteOverArrrayListOfLinkedLists(getLinkedListsForDifferentLevelsFromGivenTree(createMostCompleteBinarySearchTreeFromASortedArray(intArray1,0,intArray1.length)));
		 System.out.println("-----CHECK IF A TREE IS SUBSET OF ANOTHER TREE---");
		 methodForCheckingVariousInputsForTreeIsASubsetOfAnotherTree(root); 
		 System.out.println("----NUMBER OF LEAF NODES IN THE BINARY TREE----");
		 System.out.println("Number of Leaf nodes for bigger tree is "+countNumberOfLeafNodesInABinaryTree(root));
		 System.out.println("Number of Leaf nodes in smaller tree is "+countNumberOfLeafNodesInABinaryTree(root1));
		 System.out.println("-----NUMBER OF NODES HAVING ONLY ONE CHILD IN A BINARY TREE----");
		 System.out.println("No. of nodes with one child in bigger tree is "+numberOfNodesWithOnlyOneChild(root));
		 System.out.println("No. of nodes with one child in smaller tree is "+numberOfNodesWithOnlyOneChild(root1));
		 System.out.println("----PRINT THE MIRROR OF THE GIVEN BINARY TREE BY CHANGING THE SAME BINARY TREE------");		 
		 itearteOverArrrayListOfLinkedLists(getLinkedListsForDifferentLevelsFromGivenTree(root));
		 itearteOverArrrayListOfLinkedLists(getLinkedListsForDifferentLevelsFromGivenTree(root1));
		 System.out.println("-------CHECK WHETHER GIVEN TREE IS A MIRROR OF ITSELF-----");
		 checkForMirrorTestOfBinaryTrees();	
		 System.out.println("---KTH SMALLEST ELEMENT IN A BINARY TREE-----");
		 System.out.println("3rd smallest element in the binary tree is"+nthSmallestElementInABinarySearchTree(root,3));
		 System.out.println("---KTH LARGEST ELEMENT IN A BINARY TREE-----");
		// System.out.println("3rd largesr element in the binary tree is"+nthSmallestElementInABinarySearchTree(root,3));
		 System.out.println("-----PRINT ALL ROOT TO LEAF PATHS --------------");
		 int path [] = new int[100];
		 printAllRootToLeafPaths(root1,path,0);
		 System.out.println("----TOTAL NUMBER OF NODES IN THE BINARY TREE----");
		 System.out.println("Number of nodes in the bigger tree "+returnNumberOfNodesInTheTree(root));
		 System.out.println("Number of nodes in the smaller tree "+returnNumberOfNodesInTheTree(root1));
		 System.out.println("---DOES TREE HAS A PATH FROM ROOT TO LEAF WHOSE SUM IS ZERO----");
		 System.out.println("check for sum 30 "+isTreeHasPathFromfromRootToLeafSuchThatAddingUpALLValuesAlongPathEqualsSum(root1, 30));
		 System.out.println("check for sum 82 "+isTreeHasPathFromfromRootToLeafSuchThatAddingUpALLValuesAlongPathEqualsSum(root1, 82));
		 System.out.println("check for sum 32 "+isTreeHasPathFromfromRootToLeafSuchThatAddingUpALLValuesAlongPathEqualsSum(root1, 32));
		 System.out.println("check for sum 19 "+isTreeHasPathFromfromRootToLeafSuchThatAddingUpALLValuesAlongPathEqualsSum(root1, 19));
		 System.out.println("----MAX NO OF NODES IN ANY LEVEL-----");
		 System.out.println("max no of nodes in any level in bigger tree is "+getMaxNoOfNodesInAnyLevel(root));
		 System.out.println("max no of nodes in any level in smaller tree is "+getMaxNoOfNodesInAnyLevel(root1));
		 System.out.println("-----LEVEL ORDER TRAVERSAL OF THE TREE-----");
		 doLevelOrderTraversalOfTree(root1);
		 System.out.println("");
		 doLevelOrderTraversalOfTree(root);
		 System.out.println("----");
		 System.out.println("---DO MORRIS TRAVERSAL OF BINARY TREES------");
		 doMorrisTraversalOfBinaryTree(root1);
		 System.out.println("");
		 doMorrisTraversalOfBinaryTree(root);
		 System.out.println("---");
		 doInOrderWithoutRecursion(root1);
		 
	 }
	 
	 

	/**
	 * 
	 */
	private static void checkForMirrorTestOfBinaryTrees() {
		TreeNode<Integer> root = new TreeNode<Integer>(null, null, 10);
		root.setLeft(new TreeNode<Integer>(null, null, 5));
		root.getLeft().setRight(new TreeNode<Integer>(null, null, 6));
		root.setRight(new TreeNode<Integer>(null, null, 5));
		root.getRight().setLeft(new TreeNode<Integer>(null, null, 6));
		System.out.println(returnTrueIfBinaryTreeIsMirrorImageOfItself(root.getLeft(), root.getRight()));
		
	}

   
	public static int returnNumberOfNodesInTheTree(TreeNode<Integer> root){
		if(root == null) return 0;
		else
			return 1+returnNumberOfNodesInTheTree(root.getLeft())+
			 returnNumberOfNodesInTheTree(root.getRight());
		
	}

	private static void methodForCheckingVariousInputsForTreeIsASubsetOfAnotherTree(
			TreeNode<Integer> root) {
		TreeNode<Integer> node = new TreeNode<Integer>(null,null,6);
		node.setRight(new TreeNode<Integer>(null,null,9));
		TreeNode<Integer> node1 = new TreeNode<Integer>(null,null,6);
		node1.setLeft(new TreeNode<Integer>(null,null,9));
		System.out.println(isGivenTreeSubsetOfABiggerTree(node,node1));
		TreeNode<Integer> node2 = new TreeNode<Integer>(null,null,12);
		node2.setLeft(new TreeNode<Integer>(null,null,11));
		node2.setRight(new TreeNode<Integer>(null,null,14));
		node2.getRight().setLeft(new TreeNode<Integer>(null,null,13));
		node2.getRight().setRight(new TreeNode<Integer>(null,null,15));
		System.out.println(isGivenTreeSubsetOfABiggerTree(root,root.getRight()));
	
	}



	private static void itearteOverArrrayListOfLinkedLists(ArrayList<LinkedList<TreeNode<Integer>>> list){
		 for(LinkedList<TreeNode<Integer>> llist:list){
			 for(TreeNode<Integer> node :llist){
				 System.out.print(node+",");
			 }
			 System.out.println(" ");
		 }
	 }
	 
	 private static boolean isTreeHasPathFromfromRootToLeafSuchThatAddingUpALLValuesAlongPathEqualsSum(TreeNode<Integer> root,int sum){
		if(root ==null) return (sum==0);
		else {
			int sumNew = sum - root.getData();
			return isTreeHasPathFromfromRootToLeafSuchThatAddingUpALLValuesAlongPathEqualsSum(root.getLeft(), sumNew)||
			isTreeHasPathFromfromRootToLeafSuchThatAddingUpALLValuesAlongPathEqualsSum(root.getRight(), sumNew);
		}		
	 }
	 
	 
	 private static int numberOfNodesWithOnlyOneChild(TreeNode<Integer> root){
		 if(root == null) return 0;
		 else if(root.getLeft()==null && root.getRight() == null) return 0;
		 else if(root.getLeft()==null){
			return 1+numberOfNodesWithOnlyOneChild(root.getRight());
		 }else if(root.getRight() == null){
			 return 1+numberOfNodesWithOnlyOneChild(root.getLeft()); 
		 }
		 else 
			 return numberOfNodesWithOnlyOneChild(root.getLeft())+
			 numberOfNodesWithOnlyOneChild(root.getRight());
	 }
	 
	 
	 private static void doLevelOrderTraversalOfTree(TreeNode<Integer> root){
		 int heightOfTree = getHeightOfTheTree(root);
		 for(int i=0;i<heightOfTree;i++){
			 traverseForLevel(root,i);
		 }		
	 }
	 
	 
	 
	private static void traverseForLevel(TreeNode<Integer> root, int i) {
	   if(root == null) return ;
	   if(i==0) System.out.print(root.getData()+",");
	   else{
		   traverseForLevel(root.getLeft(),i-1);
		   traverseForLevel(root.getRight(),i-1);
	   }
		 
	}

	private static int getMaxNoOfNodesInAnyLevel(TreeNode<Integer> root){
		 if(root == null) return 0;
		 LinkedList<TreeNode<Integer>> list = new LinkedList<TreeNode<Integer>>();
		 list.add(root);
		 int max = 1;
		 while(list.size()>0){
			 LinkedList<TreeNode<Integer>> parents = list;
			 list = new LinkedList<TreeNode<Integer>>();
			 for(TreeNode<Integer> parent:parents){				 
				 if(parent.getLeft()!=null) list.addLast(parent.getLeft());
				 if(parent.getRight()!=null)list.addLast(parent.getRight());
			 }
			if(list.size()> max) max= list.size();	 
		 }
		return max; 
	 }
	 
	 private static void makeMirrorOfABinaryTree(TreeNode<Integer> root){
		 TreeNode<Integer> tempNode = null;
		 if(root==null) return ;
		 if(root.getLeft()==null&&root.getRight()==null) 
			 return ;
		 else {
			 tempNode = root.getLeft();
			 root.setLeft(root.getRight());
			 root.setRight(tempNode);
			 makeMirrorOfABinaryTree(root.getLeft());
			 makeMirrorOfABinaryTree(root.getRight());
		 }
			 
	}
	 
	 private static void convertTreeIntoDoublyLinkedList(){
		 
	 }
	 
     private static void convertTreeIntoDoublyLinkedListInZigZagWay(){
		 
	 }
	 
	 private static int countNumberOfLeafNodesInABinaryTree(TreeNode<Integer> root){
		 if(root == null) return 0;
		 else if(root.getRight()==null&&root.getLeft()==null) return 1;
		 else 
			 return countNumberOfLeafNodesInABinaryTree(root.getLeft())+
			 countNumberOfLeafNodesInABinaryTree(root.getRight());
		 
	 }
	 
	 private static void nthLargestElementInABinarySearchTree(TreeNode<Integer> root, int k){
		 if(root!=null){
		 }
	 }
	 

    private static int nthSmallestElementInABinarySearchTree(TreeNode<Integer> root, int n){
        int k=0 ;
        int el=-1;
        if(root==null) return 0;
        nthSmallestElementInABinarySearchTree(root.getLeft(),n);
         if(++k==n) el=root.getData();
         else
        	nthSmallestElementInABinarySearchTree(root.getRight(),n);
          return el;
	 }
    
    private static void printAllRootToLeafPaths(TreeNode<Integer> root, int[] path, int pathLength){
    	if(root == null) return;
    	path[pathLength++] = root.getData();
    	if(root.getLeft() == null &&root.getRight() == null)
    		printPath(path);
    	else{
    		printAllRootToLeafPaths(root.getLeft(), path,pathLength);
    		printAllRootToLeafPaths(root.getRight(),path,pathLength);
    	} 	
    }
    
    /**
	 * @param path
	 */
	private static void printPath(int[] path) {
		for(int a:path)
		 System.out.print(","+a);
		System.out.println("--");
	}



	private static void printEulerTourOfTheGivenBinaryTree(TreeNode<Integer> root){
    	
    }
    
    private static void makeBinaryTreeWithNextPointerPointingToSibling(){
    	
    }
    
    private static boolean returnTrueIfBinaryTreeIsMirrorImageOfItself(TreeNode leftTree,TreeNode rightTree){
    	if(leftTree ==null || rightTree ==null) return (leftTree==null)&&(rightTree == null);
    	return (leftTree.equals(rightTree)&&returnTrueIfBinaryTreeIsMirrorImageOfItself(leftTree.getLeft(),rightTree.getRight())
    			&&returnTrueIfBinaryTreeIsMirrorImageOfItself(leftTree.getRight(),rightTree.getLeft()));
    }
    
    private static void doMorrisTraversalOfBinaryTree(TreeNode<Integer> root){
    
    	 TreeNode<Integer> current = root;
    	 TreeNode<Integer> prev = null;
    	 while(current!=null){
    		 if(current.getLeft()==null){
    			 System.out.print(current.getData()+",");
    			 current = current.getRight();
    		 }else{
    			 prev = current.getLeft();
    			 while(prev.getRight()!=null && prev.getRight()!=current)
    				 prev = prev.getRight();
    			 if(prev.getRight()==null){
    				 prev.setRight(current);
    				 current = current.getLeft();
    			 }else{
    				 System.out.print(current.getData()+",");
    				 prev.setRight(null);
    				 current = current.getRight(); 				 
    			 }
    		 }
    	 }
    	
    	
    }
	 
	 private static void getClosestAncestorOfBinarySearchTreeForALLBoundaryConditions(
				TreeNode<Integer> root) {
			TreeNode<Integer> node = new TreeNode<Integer>(null,null,6);
			TreeNode<Integer> node1 = new TreeNode<Integer>(null,null,9);
			TreeNode<Integer> node2 = new TreeNode<Integer>(null,null,25);
			TreeNode<Integer> node3 = new TreeNode<Integer>(null,null,27);
			TreeNode<Integer> node4 = new TreeNode<Integer>(null,null,4);
			TreeNode<Integer> node5 = new TreeNode<Integer>(null,null,1);
			TreeNode<Integer> node6 = new TreeNode<Integer>(null,null,100);
			TreeNode<Integer> node7 = new TreeNode<Integer>(null,null,200);
			TreeNode<Integer> node8 = new TreeNode<Integer>(null,null,14);
		    System.out.println("Ancestor for  25 and 27 is "+findClosestAncestorsofABinarySearchTree(root, node2, node3));
		    System.out.println("Ancestor for  1 and 4 is "+findClosestAncestorsofABinarySearchTree(root, node4, node5));
		    System.out.println("Ancestor for  25 and 6 is "+findClosestAncestorsofABinarySearchTree(root, node, node2));
		    System.out.println("Ancestor for  1 and 27 is "+findClosestAncestorsofABinarySearchTree(root, node3, node5));
		    System.out.println("Ancestor for  25 and 100 is "+findClosestAncestorsofABinarySearchTree(root, node6, node2));
		    System.out.println("Ancestor for  100 and 200 is "+findClosestAncestorsofABinarySearchTree(root, node6, node7));
		    System.out.println("Ancestor for  9 and 4 is "+findClosestAncestorsofABinarySearchTree(root, node1, node4));
		    System.out.println("Ancestor for  9 and 14 is "+findClosestAncestorsofABinarySearchTree(root, node1, node8));
		    System.out.println("Ancestor for  25 and 14 is "+findClosestAncestorsofABinarySearchTree(root, node2, node8));
		    
		}
	 
	 private static void getClosestAncestorOfBinaryTreeForALLBoundaryConditions(
			TreeNode<Integer> root) {
		TreeNode<Integer> node = new TreeNode<Integer>(null,null,6);
		TreeNode<Integer> node1 = new TreeNode<Integer>(null,null,9);
		TreeNode<Integer> node2 = new TreeNode<Integer>(null,null,25);
		TreeNode<Integer> node3 = new TreeNode<Integer>(null,null,27);
		TreeNode<Integer> node4 = new TreeNode<Integer>(null,null,4);
		TreeNode<Integer> node5 = new TreeNode<Integer>(null,null,1);
		TreeNode<Integer> node6 = new TreeNode<Integer>(null,null,100);
		TreeNode<Integer> node7 = new TreeNode<Integer>(null,null,200);
		TreeNode<Integer> node8 = new TreeNode<Integer>(null,null,14);
	    System.out.println("Ancestor for  25 and 27 is "+findClosestAncestorsofABinaryTree(root, node2, node3));
	    System.out.println("Ancestor for  1 and 4 is "+findClosestAncestorsofABinaryTree(root, node4, node5));
	    System.out.println("Ancestor for  25 and 6 is "+findClosestAncestorsofABinaryTree(root, node, node2));
	    System.out.println("Ancestor for  1 and 27 is "+findClosestAncestorsofABinaryTree(root, node3, node5));
	    System.out.println("Ancestor for  25 and 100 is "+findClosestAncestorsofABinaryTree(root, node6, node2));
	    System.out.println("Ancestor for  100 and 200 is "+findClosestAncestorsofABinaryTree(root, node6, node7));
	    System.out.println("Ancestor for  9 and 4 is "+findClosestAncestorsofABinaryTree(root, node1, node4));
	    System.out.println("Ancestor for  9 and 14 is "+findClosestAncestorsofABinaryTree(root, node1, node8));
	    System.out.println("Ancestor for  25 and 14 is "+findClosestAncestorsofABinaryTree(root, node2, node8));
	    
	}

	public static void getSuccessorFromVariousInputs(TreeNode<Integer> root){
		 System.out.println("successor of 10 is "+getSuccessor(root));
		 System.out.println("successor of 1 is "+getSuccessor(root.getLeft().getLeft().getLeft().getLeft().getLeft()));
		 System.out.println("successor of 20 is "+getSuccessor(root.getRight()));
		 System.out.println("successor of 5 is "+getSuccessor(root.getLeft()));
		 System.out.println("successor of 7 is "+getSuccessor(root.getLeft().getRight().getLeft()));
		 System.out.println("successor of 15 is "+getSuccessor(root.getRight().getLeft().getRight().getRight()));
		 System.out.println("successor of 27 is "+getSuccessor(root.getRight().getRight().getRight()));
	 } 
	 
	 
	 public static void getPredecessorFromVariousInputs(TreeNode<Integer> root){
		 System.out.println("Predecessor of 10 is "+getPredecessor(root));
		 System.out.println("Predecessor of 1 is "+getPredecessor(root.getLeft().getLeft().getLeft().getLeft().getLeft()));
		 System.out.println("Predecessor of 20 is "+getPredecessor(root.getRight()));
		 System.out.println("Predecessor of 5 is "+getPredecessor(root.getLeft()));
		 System.out.println("Predecessor of 7 is "+getPredecessor(root.getLeft().getRight().getLeft()));
		 System.out.println("Predecessor of 15 is "+getPredecessor(root.getRight().getLeft().getRight().getRight()));
	 }

	public static void insertDataInBST(TreeNode<Integer> root) {
		 createBinarySearchTree(root, 20);
		 createBinarySearchTree(root, 5);
		 createBinarySearchTree(root, 4);
		 createBinarySearchTree(root, 8);
		 createBinarySearchTree(root, 7);
		 createBinarySearchTree(root, 9);
		 createBinarySearchTree(root, 6);
		 createBinarySearchTree(root, 3);
		 createBinarySearchTree(root, 2);
		 createBinarySearchTree(root, 1);
		 createBinarySearchTree(root, 12);
		 createBinarySearchTree(root, 14);   
		 createBinarySearchTree(root, 25);
		 createBinarySearchTree(root, 11);
		 createBinarySearchTree(root, 27);
		 createBinarySearchTree(root, 13);
		 createBinarySearchTree(root, 15);
	}
	
	public static void insertDataInBalancedBST(TreeNode<Integer> root) {
		 createBinarySearchTree(root, 20);
		 createBinarySearchTree(root, 5);
		 createBinarySearchTree(root, 4);
		 createBinarySearchTree(root, 8);
		 createBinarySearchTree(root, 7);
		 createBinarySearchTree(root, 9);
		 createBinarySearchTree(root, 25);
		 createBinarySearchTree(root, 27);
	}
	 
	 
	 
	 public static void createBinarySearchTree(TreeNode<Integer> root,Integer data){
		 if(data<root.getData()){
			 if(root.getLeft()!=null)
				 createBinarySearchTree(root.getLeft(),data);
			 else {
				 TreeNode<Integer> node = new TreeNode<Integer>(null,null,data);
				 root.setLeft(node);
				 node.setParent(root);
			 }
		 }else{
			 if(root.getRight()!=null)
				 createBinarySearchTree(root.getRight(), data);
			 else {
				 TreeNode<Integer> node = new TreeNode<Integer>(null,null,data);
				 root.setRight(node);
				 node.setParent(root);
			 }
		 }
	 }
	
	 public static void doInOrder(TreeNode<Integer> root){
		 if(root!=null){
		 doInOrder(root.getLeft());
         System.out.print(root.getData()+",");
         doInOrder(root.getRight());         
		 }
	 }
	 
	 public static void doPreOrder(TreeNode<Integer> root){
		 if(root!=null){
	         System.out.print(root.getData()+",");
			 doPreOrder(root.getLeft());
	         doPreOrder(root.getRight());         
			 }	
			
	 }
	 
	 public static void doPostOrder(TreeNode<Integer> root){
		 if(root!=null){
			 doPostOrder(root.getLeft());
	         doPostOrder(root.getRight());
	         System.out.print(root.getData()+",");
			 }
			
	 }
	 
	 public static void doPostOrderWithoutRecursion(TreeNode<Integer> root){
		 Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();	
		 TreeNode<Integer> current = root ;
		 stack.push(current);	 
		 while(!stack.isEmpty()){
			 current = stack.peek();
			 current.setVisited(true);
			 if(current.getLeft()!=null&&!current.getLeft().isVisited()) stack.push(current.getLeft());
			 else if (current.getRight()!=null&&!current.getRight().isVisited()) stack.push(current.getRight());
			 else {
				 current = stack.pop();
				 System.out.print(current.getData()+",");
			 }
			 
		 }			
	 }
	 
	 public static void doInOrderWithoutRecursion(TreeNode<Integer> root){
		Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();	
		TreeNode<Integer> current = root;
		while(current!=null){
			stack.push(current);
			current= current.getLeft();
		}
		while(!stack.isEmpty()){
		  current = stack.pop();	
		  System.out.print(current+",");
		  current = current.getRight();
			  while(current!=null){
					stack.push(current);
					current= current.getLeft();
				}
	   }
	 }
	 
	 public static void doPreOrderWithoutRecursion(TreeNode<Integer> root){
		 Stack<TreeNode<Integer>> stack = new Stack<TreeNode<Integer>>();	
		 TreeNode<Integer> current = root;
		 stack.push(current);
		 while(!stack.isEmpty()){
			 current = stack.pop();
			 System.out.print(current+",");
			 if(current.getRight()!=null) stack.push(current.getRight());
			 if(current.getLeft()!=null) stack.push(current.getLeft());
		 }
			
	 }
	 
	 
	 public static Integer getHeightOfTheTree(TreeNode<Integer> root){
		 if(root == null) return 0;
		  return Math.max(getHeightOfTheTree(root.getLeft()),getHeightOfTheTree(root.getRight()))+1;	 
	 }
	 
	 public static boolean isBinaryTreeIsABalancedTreeOrderNSquareAlgo(TreeNode<Integer> root){
		 if(root == null) return true;
		 int leftHeight = getHeightOfTheTree(root.getLeft());
		 int rightHeight = getHeightOfTheTree(root.getRight());
		 int diffHeight = rightHeight- leftHeight;
		 if(Math.abs(diffHeight)>1)
			 return false;
		 else return isBinaryTreeIsABalancedTreeOrderNSquareAlgo(root.getLeft())&& 
		 isBinaryTreeIsABalancedTreeOrderNSquareAlgo(root.getRight());
	 }
	 
     public static int isBinaryTreeIsABalancedTreeOrderNAlgo(TreeNode<Integer> root){
    	 if(root == null) return 0;
    	 int leftHeight = isBinaryTreeIsABalancedTreeOrderNAlgo(root.getLeft());
		 if(leftHeight == -1) return -1;
    	 
    	 int rightHeight = isBinaryTreeIsABalancedTreeOrderNAlgo(root.getRight());
    	 if(rightHeight == -1) return -1;
    	 
    	 if(Math.abs(leftHeight-rightHeight)>1) return -1;
    	 else
    		return  Math.max(isBinaryTreeIsABalancedTreeOrderNAlgo(root.getLeft()), 
    				 isBinaryTreeIsABalancedTreeOrderNAlgo(root.getRight()))+1;
	 }
	 
	 
	 public static boolean isBinaryTreeIsABinarySearchTreeUsingInOrder(TreeNode<Integer> root){
		if (root == null) return true ;
		isBinaryTreeIsABinarySearchTreeUsingInOrder(root.getLeft());
		if(root.getData()< MIN_INTEGER) return false;
		MIN_INTEGER = root.getData();
		isBinaryTreeIsABinarySearchTreeUsingInOrder(root.getRight());
		return true;
	 }
	 
     public static boolean isBinaryTreeIsABinarySearchTree(TreeNode<Integer> root,Integer max, Integer min){
		 if (root == null) return true;
		 if(root.getData()>max||root.getData()<min) return false;
		 if(!isBinaryTreeIsABinarySearchTree(root.getLeft(), root.getData(), min)||
				 !isBinaryTreeIsABinarySearchTree(root.getRight(), max, root.getData())) 
			 return false;
		 return true;
	 }
     
     public static boolean isBinaryTreeIsABST(TreeNode<Integer> root){
    	 if(isBinaryTreeIsABinarySearchTree(root,MAX_INTEGER,MIN_INTEGER)) return true;
    	 else
    		 return false;
     }
	 
	 public static Integer getMaximum(TreeNode<Integer> root){
		 while(root.getRight()!=null){
			 root= root.getRight();
		 }
		 return root.getData();
	 }
	 
	 public static Integer getMinimum(TreeNode<Integer> root){
		 while(root.getLeft()!=null){
			 root= root.getLeft();
		 }
		 return root.getData();	 
	 }
	 
	 public static Integer getSuccessor(TreeNode<Integer> rootNode){	
		 if(rootNode.getRight()!=null) return getMinimum(rootNode.getRight());
		 TreeNode<Integer> current = rootNode;
		 TreeNode<Integer> parent = rootNode.getParent();
		 while(parent!=null && parent.getRight()!=null && parent.getRight().equals(current)){
			 current = parent ;
			 parent = current.getParent();
		 }
		 if(parent != null) return parent.getData(); 
		 else return null;
	 }
 	 
	 
	 public static Integer getPredecessor(TreeNode<Integer> rootNode){	
		 if(rootNode.getLeft()!=null) return getMaximum(rootNode.getLeft());
		 TreeNode<Integer> current = rootNode;
		 TreeNode<Integer> parent = rootNode.getParent();
		 while(parent!=null &&  parent.getLeft()!=null && parent.getLeft().equals(current)){
			 current = parent ;
			 parent = current.getParent();
		 }
		 if(parent != null) return parent.getData(); 
		 else return null;
	 }
	 	
	 
	 public static TreeNode<Integer> createMostCompleteBinarySearchTreeFromASortedArray(int [] array, int start, int end){
		 if(start>=end) return null;
		 int mid = (start+end)/2;
		 TreeNode<Integer> root = new TreeNode<Integer>(null,null,array[mid]);
		 root.setLeft(createMostCompleteBinarySearchTreeFromASortedArray(array, start, mid));
		 root.setRight(createMostCompleteBinarySearchTreeFromASortedArray(array, mid+1, end));
		 return root ;
		 
	 }
	 
	 public static boolean isGivenTreeSubsetOfABiggerTree(TreeNode<Integer> node1, TreeNode<Integer> node2){
		 if((node1==null)&&(node2==null)) return true;
		 if(node1==null) return false;
		 if(node2==null) return true;	 
		 if(node1.equals(node2)) return isMatch(node1,node2);
		 else return isGivenTreeSubsetOfABiggerTree(node1.getLeft(), node2)|| 
		 isGivenTreeSubsetOfABiggerTree(node1.getRight(), node2);
		 
	 }
	 
	 private static boolean isMatch(TreeNode<Integer> node1,
			TreeNode<Integer> node2) {
		if(node1==null&&node2==null) return true;
		if(node1==null)return false;
		if(node2==null)return true;
		return isMatch(node1.getLeft(),node2.getLeft()) && 
		isMatch(node1.getRight(), node2.getRight());
	}



	public static ArrayList<LinkedList<TreeNode<Integer>>> getLinkedListsForDifferentLevelsFromGivenTree(TreeNode<Integer> root){
		if(root == null) return null;
		LinkedList<TreeNode<Integer>> current = new LinkedList<TreeNode<Integer>>();
		ArrayList<LinkedList<TreeNode<Integer>>> result = new ArrayList<LinkedList<TreeNode<Integer>>>();
		current.add(root);
		while(current.size()>0){
			result.add(current);
			LinkedList<TreeNode<Integer>> parents = current ;
			current = new LinkedList<TreeNode<Integer>>();
			for(TreeNode<Integer> parent:parents){
				if(parent.getLeft()!=null) current.addLast(parent.getLeft());
				if(parent.getRight()!=null) current.addLast(parent.getRight());
			}
		}			
	    return result;
	 }
	 
	 /**
	 * @param right
	 * @param right2
	 * @return
	 */


	public static TreeNode<Integer> findClosestAncestorsofABinaryTree(TreeNode<Integer> rootNode,TreeNode<Integer> p,TreeNode<Integer> q){
		if((rootNode == null) || p==null || q==null)
			return null;
		if(!isNodePresentInTheTree(rootNode,p)||!isNodePresentInTheTree(rootNode,q)) return null;
		else 
			return findAncestorOf2Nodes(rootNode,p,q);
	 }
	 
	 /**
	 * @param rootNode
	 * @param p
	 * @param q
	 * @return
	 */
	private static TreeNode<Integer> findAncestorOf2Nodes(
			TreeNode<Integer> rootNode, TreeNode<Integer> p, TreeNode<Integer> q) {
		if(rootNode.equals(p)||rootNode.equals(q)) return rootNode;
		boolean isPPresentOnLeft = isNodePresentInTheTree(rootNode.getLeft(), p);
		boolean isQPresentOnLeft = isNodePresentInTheTree(rootNode.getLeft(), q);
		if(isPPresentOnLeft!=isQPresentOnLeft) return rootNode ;
		if(isPPresentOnLeft) return findAncestorOf2Nodes(rootNode.getLeft(), p, q);
		else return findAncestorOf2Nodes(rootNode.getRight(), p, q);			
		
	}

	/**
	 * @param rootNode
	 * @param q
	 * @return
	 */
	private static boolean isNodePresentInTheTree(TreeNode<Integer> rootNode,
			TreeNode<Integer> node) {
		if(rootNode == null) return false;
		if(rootNode.equals(node)) return true;
		else 
			return isNodePresentInTheTree(rootNode.getLeft(), node)|| isNodePresentInTheTree(rootNode.getRight(), node);
	}

	public static TreeNode<Integer> findClosestAncestorsofABinarySearchTree(TreeNode<Integer> rootNode,
			TreeNode<Integer> p,TreeNode<Integer> q){
		if(rootNode == null || p == null || q== null) return null;
		if(!isNodePresentInTheTree(rootNode, p)|| !isNodePresentInTheTree(rootNode, q)) return null;
		else 
		  return ancestorINABST(rootNode, p ,q);
		 
	 }
	 
	 private static TreeNode<Integer> ancestorINABST(TreeNode<Integer> rootNode,
			TreeNode<Integer> p, TreeNode<Integer> q) {
		if(rootNode.equals(p)||rootNode.equals(q)) return rootNode ; 
		if(p.getData()>rootNode.getData()&&q.getData()>p.getData()) return ancestorINABST(rootNode.getRight(), p, q);
		else if(p.getData()<rootNode.getData()&&q.getData()<rootNode.getData()) return ancestorINABST(rootNode.getLeft(), p, q);
		else if(p.getData()<rootNode.getData()&&rootNode.getData()<q.getData()
				||p.getData()>rootNode.getData()&&rootNode.getData()>q.getData()) return rootNode ;
        return null;
	}

	public static int findDiameterOfAGivenBinaryTree(TreeNode<Integer> node){
		if(node == null) return 0;
		 int leftheight = getHeightOfTheTree(node.getLeft());
		 int rightheight = getHeightOfTheTree(node.getRight());
		 int leftDiameter = findDiameterOfAGivenBinaryTree(node.getLeft());
		 int rightDiameter = findDiameterOfAGivenBinaryTree(node.getRight());
		 return Math.max(rightheight+leftheight+1,Math.max(leftDiameter, rightDiameter)); 
	 }
	
	public static int findDiameterOfAGivenBinaryTreeMoreOtimized(TreeNode<Integer> node,int height){
        int leftHeight =0, rightHeight=0;
		if(node == null){ 
			height = 0;
			return 0;
		}
		 int leftDiameter = findDiameterOfAGivenBinaryTreeMoreOtimized(node.getLeft(),leftHeight);
		 int rightDiameter = findDiameterOfAGivenBinaryTreeMoreOtimized(node.getRight(),rightHeight);
		 height = Math.max(leftHeight,rightHeight)+1;
		 return Math.max(height,Math.max(leftDiameter, rightDiameter)); 
	 }
	
	public static int findMaxHorizantalWidthInABinaryTree(TreeNode<Integer> root){
		return 0;
	 	
	 	
	 }

}
