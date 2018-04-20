/**
 * 
 */
package algorithms;

import java.util.Stack;

import coding.TreeNode;

/**
 * @author Vibs
 *
 */
public class InorderWithoutRecursion {
	
	public static void doInOrderUsingRecursion(TreeNode root){
		Stack<TreeNode> stack= new Stack<TreeNode>();
		TreeNode current = null;
		if(root!=null){
			 current = root;
			 boolean done = false;
			while(!done){ 
			while(current!=null){
				stack.push(current);
				current=current.getLeft();
				
			}if (!stack.isEmpty()){
				current =stack.pop();
				System.out.print(current.getData()+",");
				current = current.getRight();				
			}else
			  done = true;
			}

			}
			
	}
	
	
	public static void traverseTreeInOrder(TreeNode root) {
	    Stack<TreeNode> nodes = new Stack<TreeNode>();
	    while (!nodes.isEmpty() || null != root) {
	        if (null !=root) {
	            nodes.push(root);
	            root = root.getLeft();
	        } else {
	            root = nodes.pop();
	            System.out.print(root.getData()+",");
	            root = root.getRight();
	        }
	    }                           
	}
	
	
	public static void doPreOrderUsingRecursion(TreeNode root){
		Stack<TreeNode> stack= new Stack<TreeNode>();
		stack.push(root);
			while(true){ 
				if(stack.isEmpty()) break;
				TreeNode current =stack.pop();
				System.out.print(current.getData()+",");
				if(current.getRight()!=null) stack.push(current.getRight());
				if(current.getLeft()!=null) stack.push(current.getLeft());
			}						
	}
	
	public static void doPostOrderUsingRecursion(TreeNode root){
		Stack<TreeNode> stack= new Stack<TreeNode>();
		stack.push(root);
			while(!stack.isEmpty()){
				TreeNode current =stack.peek();
				current.setVisited(true);  
				if(current.getLeft()!=null&&!current.getLeft().isVisited()) stack.push(current.getLeft());
				else if(current.getRight()!=null&& !current.getRight().isVisited()) stack.push(current.getRight());
				else{
				     System.out.print(current.getData()+",");
				     stack.pop();
				} 			
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
		
		
		System.out.println("----InOrder Traversal---");
		doInOrder(rootNode);
		System.out.println("");
		System.out.println("----PreOrder Traversal---");
		doPreOrder(rootNode);
		System.out.println("");
		System.out.println("--Inorder without using recursion--");
		doInOrderUsingRecursion(rootNode);
		System.out.println("");
		System.out.println("===preorder without using recursion----");
		doPreOrderUsingRecursion(rootNode);
		System.out.println("");
		System.out.println("===postOrder----");
		doPostOrder(rootNode);
		System.out.println("");
		System.out.println("===postorder without using recursion----");
		doPostOrderUsingRecursion(rootNode);
		System.out.println("inorder traversal---");
		System.out.println("");
		traverseTreeInOrder(rootNode);
	}
	
  public static void doInOrder (TreeNode node){
		
		if(node != null){
		doInOrder(node.getLeft());
		System.out.print(node.getData()+",");
		doInOrder(node.getRight());
		}
	}
	
public static void doPreOrder (TreeNode node){
		if(node == null) return;
		 System.out.print(node.getData()+",");
		 doPreOrder(node.getLeft());
		 doPreOrder(node.getRight());
		
	}

public static void doPostOrder (TreeNode node){
	if(node == null) return;
	doPostOrder(node.getLeft());
	doPostOrder(node.getRight());
	 System.out.print(node.getData()+",");
	
}
	
	
	

}
