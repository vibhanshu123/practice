/**
 * 
 */
package amazon;

/**
 * @author Vibs
 *
 */
public class TreeNode {
	
	private TreeNode left ;
	
	private TreeNode right ;
	
	private TreeNode parent ;
	
	private Integer data ;
	/**
	 * 
	 */
	public TreeNode(Integer data) {
		this.data = data ;
		this.left = null ;
		this.right = null ;
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
	public TreeNode getParent() {
		return parent;
	}
	public void setParent(TreeNode parent) {
		this.parent = parent;
	}
	public Integer getData() {
		return data;
	}
	public void setData(Integer data) {
		this.data = data;
	}

}
