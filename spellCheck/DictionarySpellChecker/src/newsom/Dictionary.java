package newsom;

public class Dictionary {
	
	public Node root;
	public String displayTxt = "";
	
	public Dictionary() {
		root = null;
	}
	
	// INSERTION
	public void insertWordNode(String key) {
		root = insertNode(root, key);
	}
	
	Node insertNode(Node root, String key) {
		if (root == null) {
			root = new Node(key);
			return root;
		}
		
		if (key.compareTo(root.key) < 0)
			root.left = insertNode(root.left, key);
		else if (key.compareTo(root.key) > 0)
			root.right = insertNode(root.right, key);
		
		return root;
	}
	
	// DELETION
	public void checkWord(String key) {
		root = deleteNode(root, key);
	}
	
	Node deleteNode(Node root, String key) {
		if (root == null)
			return root;
		if (key.compareTo(root.key) < 0)
			root.left = deleteNode(root.left, key);
		else if (key.compareTo(root.key) > 0)
			root.right = deleteNode(root.right, key);
		else {
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			
			root.key = minValue(root.right);
			
			root.right = deleteNode(root.right, root.key);
		}
		
		return root;
	}
	
	// MINIMUM VALUE / FIRST WORD ALPHABETICALLY
	public String minValue(Node root) {
		String mv = root.key;
		while (root.left != null) {
			mv = root.left.key;
			root = root.left;
		}
		return mv;
	}
	
	// CHECKS IF WORD IS IN BST (SPELLED CORRECTLY)
	public boolean check(String key) {
        return spellCheck(root, key);
    }
	
	boolean spellCheck(Node root, String key) {
		if (root == null)
			return false;
		if (root.key.equals(key))
			return true;
		if (root.key.compareTo(key) < 0)
			return spellCheck(root.right, key);
		else 
			return spellCheck(root.left, key);
	}
	
	// PRINT LIST IN ALPHABETICAL ORDER
	public void inorder() {
		inorderNode(root);
	}
	
	void inorderNode(Node root) {
		if (root != null) {
			inorderNode(root.left);
			displayTxt += root.key + " ";
			inorderNode(root.right);
		}
	}

}
