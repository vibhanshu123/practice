/**
 * 
 */
package coding;

/**
 * @author Vibs
 *
 */
public class TreeNode {
	
	private TreeNode left;
	
	private TreeNode right;
	
	private Integer data ;
	
	private TreeNode parent;
	
	private boolean isVisited;
	
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	public TreeNode getLeft() {
		return left;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public Integer getData() {
		return data;
	}

	public void setData(Integer data) {
		this.data = data;
	}

	public TreeNode getParent() {
		return parent;
	}

	public void setParent(TreeNode parent) {
		this.parent = parent;
	}

	/**
	 * 
	 */
	public TreeNode(Integer data) {
		this.data = data ;
		this.left = null;
		this.right = null;
	}
	
		
	}


