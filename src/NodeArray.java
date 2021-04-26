
public class NodeArray {
	int _number;
	Node[] nodes;
	
	public NodeArray(int number) {
		_number = number;
		nodes = new Node[0];
	}
	
	public void add(Node newNode) {
		Node[] temp = nodes;
		nodes = new Node[temp.length + 1];
		for(int i = 0; i < temp.length; i++) {
			nodes[i] = temp[i];
		}
		nodes[nodes.length - 1] = newNode;
	}
}
