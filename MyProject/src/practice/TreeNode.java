package practice;

public class TreeNode<E> {
	
	private TreeNode<E> right ;
	
	private TreeNode<E> left ;
	
	private TreeNode<E> parent ;
	
	private boolean isVisited ;
	
	public boolean isVisited() {
		return isVisited;
	}

	public void setVisited(boolean isVisited) {
		this.isVisited = isVisited;
	}

	private E data ;
	
	public E getData() {
		return data;
	}

	public void setData(E data) {
		this.data = data;
	}

	public TreeNode<E> getRight() {
		return right;
	}

	public void setRight(TreeNode<E> right) {
		this.right = right;
	}

	public TreeNode<E> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<E> left) {
		this.left = left;
	}

	public TreeNode<E> getParent() {
		return parent;
	}

	public void setParent(TreeNode<E> parent) {
		this.parent = parent;
	}

	public TreeNode(TreeNode<E> right,TreeNode<E> left, E data) {
		this.data = data ;
		this.right = right;
		this.left = left ;
	}
	
	@Override
	public boolean equals(Object o){
		if(!(o instanceof TreeNode)) return false;
		TreeNode<Integer> node =(TreeNode<Integer>) o;
		if ((node == null)&&(this ==null)) return true;
		if(this.getData()!=null&&node.getData()!=null){
			if(node.getData()==this.getData())
				return true;
			}
		return false;		
	}
	
	@Override
	public  String toString(){
		StringBuilder str= new StringBuilder();
		str.append(this.getData());
		return str.toString();
	}

}
