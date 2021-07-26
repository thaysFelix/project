package arvorebinaria;

public class Node {

	protected int value;

	public Node left;
	public Node right;
        public Node parent;

	public Node(int value) {
		this.value = value;
	}
        
        public Node() {}
        
        public int getValor() {
            return value;
        }

	public boolean isLeaf() {
		return left == null && right == null;
	}

	public boolean hasLeft() {
		return left != null;
	}

	public boolean hasRight() {
		return right != null;
	}

	public void setChilds(Node left, Node right) {
		this.left = left;
		this.right = right;
	}
	
	public String toString() {
		return Integer.toString(value);
	}
}
