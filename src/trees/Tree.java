package trees;

public class Tree {
	private Node root;

	public Tree() {
		root = null;
	}

	private Node createNode() {
		return new Node();
	}

	public void insert(Integer element) {

		Node traversal = root;
		Node previous = null;

		while (traversal != null) {

			if (traversal.getValue() < element) {
				previous = traversal;
				traversal = traversal.getRight();
			} else {
				previous = traversal;
				traversal = traversal.getLeft();
			}
		}

		if (root == null) {
			root = createNode();
			root.setValue(element);
			return;
		}

		if (previous.getValue() < element) {
			Node temp = createNode();
			temp.setValue(element);

			previous.setRight(temp);
			return;
		}

		if (previous.getValue() > element) {
			Node temp = createNode();
			temp.setValue(element);

			previous.setLeft(temp);
			return;
		}

	}

	public void delete(Integer element) {

	}

}

class Node {

	private int value;
	private Node left;
	private Node right;

	Node() {
		value = Integer.MIN_VALUE;
		left = null;
		right = null;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Node getLeft() {
		return left;
	}

	public void setLeft(Node left) {
		this.left = left;
	}

	public Node getRight() {
		return right;
	}

	public void setRight(Node right) {
		this.right = right;
	}

}
