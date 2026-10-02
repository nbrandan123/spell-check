package newsom;

public class Node {
	
	public String key;
    public Node left, right;

    public Node(String item) {
        key = item;
        left = right = null;
    }

}
