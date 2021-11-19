import java.util.ArrayList;

public class MorseCodeTree implements LinkedConverterTreeInterface<String> {
	
	protected TreeNode<String> root = null;
	protected String lastLetter;
	
	/**
	 * Constructor
	 */
	public MorseCodeTree() {
		buildTree();
	}
	
	/**
	 * Insert New Node
	 * 
	 * @param String placement code
	 * @param String letter
	 * @throws None
	 */
	public LinkedConverterTreeInterface<String> insert(String code, String letter) {
		this.addNode(this.root, code, letter.toLowerCase());
		return this;
	}

	/**
	 * Add New Node
	 * 
	 * @param TreeNode<String> new node
	 * @param String placement code
	 * @param String letter
	 */
	public void addNode(TreeNode<String> node, String code, String letter) {
		TreeNode<String> newNode = new TreeNode<String>();
		newNode.setData(letter);
		
		if (code.length() == 1) {
			if (code.equals(".")) {
				node.setLeftChild(newNode);
			} else {
				node.setRightChild(newNode);
			}
		} else if (code.substring(0, 1).equals(".")) {
			this.addNode(node.getLeftChild(), code.substring(1), letter);
		} else {
			this.addNode(node.getRightChild(), code.substring(1), letter);
		}
	}
	
	/**
	 * Get Root Node
	 * 
	 * @param None
	 * @return TreeNode<String> root
	 * @throws None
	 */
	public TreeNode<String> getRoot() {
		return root;
	}	

	/**
	 * Set Root Node
	 * 
	 * @param Node new nod
	 * @return None
	 * @throws None
	 */
	public void setRoot(TreeNode<String> node) {
		root = node;
		root.setData("");
	}
	
	/**
	 * Finds A Node Given A Code
	 * 
	 * @param String code
	 * @return String data
	 * @throws None
	 */
	public String fetch(String code) {
		return this.fetchNode(root, code);
	}

	/**
	 * Iterate Through Nodes To Find Value
	 * 
	 * @param TreeNode<String> start node
	 * @param String code
	 * @return String data
	 * @throws None
	 */
	public String fetchNode(TreeNode<String> node, String code) {
		if (code.length() == 1) {
			lastLetter = code.equals(".") ? node.getLeftChild().getData() : node.getRightChild().getData();
		} else {
			if (code.substring(0, 1).equals(".")) {
				this.fetchNode(node.getLeftChild(), code.substring(1));
			} else {
				this.fetchNode(node.getRightChild(), code.substring(1));
			}
		}
		return lastLetter;
	}

	/**
	 * Convert Tree To ArrayList
	 * 
	 * @param None
	 * @return ArrayList<String> sorted list
	 * @throws None
	 */
	public ArrayList<String> toArrayList() {
		ArrayList<String> list = new java.util.ArrayList<String>();
		this.LNRoutputTraversal(this.root, list);
		return list;
	}

	/**
	 * Build Tree with elements
	 */
	public void buildTree() {
		root = new TreeNode<String>();
		
		this.insert(".", "e");
		this.insert("-", "t");
		this.insert("..", "i");
		this.insert(".-", "a");
		this.insert("-.", "n");
		this.insert("--", "m");
		this.insert("...", "s");
		this.insert("..-", "u");
		this.insert(".-.", "r");
		this.insert(".--", "w");
		this.insert("-..", "d");
		this.insert("-.-", "k");
		this.insert("--.", "g");
		this.insert("---", "o");
		this.insert("....", "h");
		this.insert("...-", "v");
		this.insert("..-.", "f");
		this.insert(".-..", "l");
		this.insert(".--.", "p");
		this.insert(".---", "j");
		this.insert("-...", "b");
		this.insert("-..-", "x");
		this.insert("-.-.", "c");
		this.insert("-.--", "y");
		this.insert("--..", "z");
		this.insert("--.-", "q");
	}
	
	/**
	 * Recursively Sort Tree
	 * 
	 * @param TreeNode<String> node
	 * @param ArrayList<String> list
	 * @throws None
	 */
	public void LNRoutputTraversal(TreeNode<String> node, java.util.ArrayList<String> list) {
		if (node == null) { return; }
		this.LNRoutputTraversal(node.getLeftChild(), list);
		list.add(node.getData());
		this.LNRoutputTraversal(node.getRightChild(), list);
	}
	
	public LinkedConverterTreeInterface<String> delete(String data) throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Unsupported method");
	}

	public LinkedConverterTreeInterface<String> update() throws UnsupportedOperationException {
		throw new UnsupportedOperationException("Unsupported method");
	}
	
}
